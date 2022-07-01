package org.example.services;

import org.example.DAO.*;
import org.example.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class BonusSystemUpdatePatient {

    //TODO Отключение по истечению года
    //TODO Анализы которые не входят

    BonusPatientDAO bonusPatientDAO;
    psPatitemDAO ps_PatitemDAO;
    BonusTransactionDAO bonusTransactionDAO;

    psPatLedgersDAO ps_PatLedgersDAO;

    psPatinvDAO ps_PatinvDAO;

    @Autowired
    public void setPs_PatinvDAO(psPatinvDAO ps_PatinvDAO) {
        this.ps_PatinvDAO = ps_PatinvDAO;
    }

    @Autowired
    public void setPs_PatLedgersDAO(psPatLedgersDAO ps_PatLedgersDAO) {
        this.ps_PatLedgersDAO = ps_PatLedgersDAO;
    }

    @Autowired
    public void setBonusPatientDAO(BonusPatientDAO bonusPatientDAO) {
        this.bonusPatientDAO = bonusPatientDAO;
    }

    @Autowired
    public void setPs_PatitemDAO(psPatitemDAO ps_PatitemDAO) {
        this.ps_PatitemDAO = ps_PatitemDAO;
    }

    @Autowired
    public void setBonusTransactionDAO(BonusTransactionDAO bonusTransactionDAO) {
        this.bonusTransactionDAO = bonusTransactionDAO;
    }

    Timestamp timestampStart;
    Timestamp timestampEnd;

    SimpleDateFormat simpleDateFormatAM = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
    List<BonusPatient> bonusPatients;
    List<psPatLedgers> ps_Patitems;
    List<BonusTransaction> bonusTransactions;

    List<BonusDiscount> bonusDiscounts;

    List<psPatLedgers> sortPsPatitems = new ArrayList<>();
    List<psPatLedgers> newSortPsPatitems = new ArrayList<>();
    List<psPatLedgers> finalPsPatitems = new ArrayList<>();

    List<psPatitem> psPatitemList = new ArrayList<>();
    List<psPatinv> psPatinvList = new ArrayList<>();

    BonusDiscountDAO bonusDiscountDAO;

    psPatRegistersDAO ps_PatRegistersDAO;

    @Autowired
    public void setPs_PatRegistersDAO(psPatRegistersDAO ps_PatRegistersDAO) {
        this.ps_PatRegistersDAO = ps_PatRegistersDAO;
    }

    @Autowired
    public void setBonusDiscountDAO(BonusDiscountDAO bonusDiscountDAO) {
        this.bonusDiscountDAO = bonusDiscountDAO;
    }

    public void update(){

        sortPsPatitems.clear();
        newSortPsPatitems.clear();

        timestampStart = Timestamp.valueOf(LocalDateTime.now().minusMinutes(10));
        timestampEnd = Timestamp.valueOf(LocalDateTime.now());

        bonusPatients = bonusPatientDAO.bPatientsGetAll();
        ps_Patitems = ps_PatLedgersDAO.findPaymentsHC(timestampStart,timestampEnd,simpleDateFormatAM);
        bonusTransactions = bonusTransactionDAO.getBonusTransactions();

        for (psPatLedgers p:ps_Patitems) {
            for (int i = 0; i <bonusPatients.size() ; i++) {
                if((long) p.getFK_emdPatients()==bonusPatients.get(i).getBizboxId()){
                    sortPsPatitems.add(p);
                }
            }
        }

        for (psPatLedgers p:sortPsPatitems) {
            for (int i = 0; i < bonusTransactions.size(); i++) {
                if(p.getFK_TRXNO()!=bonusTransactions.get(i).getBBTransIDinner() && (long)p.getFK_psPatRegisters()!=bonusTransactions.get(i).getBBTransID()){
                    newSortPsPatitems.add(p);
                }
            }
        }

        for (psPatLedgers p:newSortPsPatitems) {
            if(ps_PatRegistersDAO.getById(p.getFK_psPatRegisters())){
                finalPsPatitems.add(p);
            }
        }

        updateAndSave(finalPsPatitems);
        bonusPatients = bonusPatientDAO.bPatientsGetAll();
        bonusDiscounts = bonusDiscountDAO.findAll();

        for (BonusPatient b: bonusPatients) {
            for (int i = 0; i <bonusDiscounts.size() ; i++) {
                if (b.getSum().compareTo(bonusDiscounts.get(i).getBonusSum())==1){
                    bonusPatientDAO.updateRate(bonusDiscounts.get(i),b.getId());
                }
            }
        }
        System.out.println("==============================================================================================================");
        System.out.println("====================================================END THREAD================================================");
        System.out.println("==============================================================================================================");
    }


    public void updateAndSave(List<psPatLedgers> patientss){
        List<BonusPatient> bonusPatientsList;
        bonusPatientsList = bonusPatientDAO.bPatientsGetAll();

        for (psPatLedgers p: patientss) {
            for (int i = 0; i <bonusPatientsList.size() ; i++) {
                if((long)p.getFK_emdPatients()==bonusPatientsList.get(i).getBizboxId()){

                    if(bonusTransactionDAO.getByBbrranst((long) p.getFK_psPatRegisters(),p.getFK_TRXNO())) {

                        BonusTransaction transaction = new BonusTransaction();
                        transaction.setRate(bonusPatientsList.get(i).getBonusDiscount().getBonusRate());
                        transaction.setPatientId(bonusPatientsList.get(i));
                        transaction.setPayment(p.getDebit());
                        transaction.setBefore(p.getDebit());
                        transaction.setBBTransIDinner(p.getFK_TRXNO());
                        ps_PatLedgersDAO.update(formula(p.getDebit(), bonusPatientsList.get(i).getBonusDiscount().getBonusRate()), p.getPK_psPatledgers());
                        bonusPatientDAO.updateSum(formula(p.getDebit(), bonusPatientsList.get(i).getBonusDiscount().getBonusRate()),bonusPatientsList.get(i).getId());
                        transaction.setAfter(formula(p.getDebit(), bonusPatientsList.get(i).getBonusDiscount().getBonusRate()));
                        transaction.setCanceled(false);
                        transaction.setComplete(true);
                        transaction.setBBTransID((long) p.getFK_psPatRegisters());
                        bonusTransactionDAO.add(transaction);

                        psPatitemList = ps_PatitemDAO.getPsPatitems(p.getFK_TRXNO());

                        for (psPatitem ps:psPatitemList) {
                            ps_PatitemDAO.update(formula(ps.getRenprice(),bonusPatientsList.get(i).getBonusDiscount().getBonusRate()),ps.getPK_psPatitem());
                        }

                        psPatinvList = ps_PatinvDAO.get(p.getFK_TRXNO());
                        for (psPatinv pn:psPatinvList) {
                            ps_PatinvDAO.update(formula(pn.getRenamount(),bonusPatientsList.get(i).getBonusDiscount().getBonusRate()),
                                                formula(pn.getAmount(),bonusPatientsList.get(i).getBonusDiscount().getBonusRate()),
                                                formula(pn.getNetamount(),bonusPatientsList.get(i).getBonusDiscount().getBonusRate()),
                                                pn.getPK_TRXNO());
                        }

                        bonusTransactionDAO.refresh(transaction);
                    }
                }
            }
        }
    }

    public BigDecimal formula(BigDecimal start,Byte rated){
        BigDecimal rate = new BigDecimal(rated);
      return start = start.subtract(start.multiply(rate).divide(new BigDecimal(100)));
    }
}

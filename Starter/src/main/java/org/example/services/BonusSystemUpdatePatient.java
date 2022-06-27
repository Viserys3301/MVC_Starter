package org.example.services;

import org.example.DAO.BonusPatientDAO;
import org.example.DAO.BonusTransactionDAO;
import org.example.DAO.psPatLedgersDAO;
import org.example.DAO.psPatitemDAO;
import org.example.controllers.StartAppController;
import org.example.entities.BonusPatient;
import org.example.entities.BonusTransaction;
import org.example.entities.psPatLedgers;
import org.example.entities.psPatitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class BonusSystemUpdatePatient {

    BonusPatientDAO bonusPatientDAO;
    psPatitemDAO ps_PatitemDAO;
    BonusTransactionDAO bonusTransactionDAO;

    psPatLedgersDAO ps_PatLedgersDAO;

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

    List<psPatLedgers> sortPsPatitems = new ArrayList<>();
    List<psPatLedgers> newSortPsPatitems = new ArrayList<>();

    public void update(){
        sortPsPatitems.clear();
        newSortPsPatitems.clear();

        timestampStart = Timestamp.valueOf(LocalDateTime.now().minusHours(120));
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
                if((long)p.getFK_psPatRegisters()!=bonusTransactions.get(i).getBBTransID()){

                    newSortPsPatitems.add(p);
                }
            }
        }
        updateAndSave(newSortPsPatitems);
    }


    public void updateAndSave(List<psPatLedgers> patientss){
        System.out.println("====================================================");
        List<BonusPatient> bonusPatientsList;
        bonusPatientsList = bonusPatientDAO.bPatientsGetAll();
        for (psPatLedgers p: patientss) {
            for (int i = 0; i <bonusPatientsList.size() ; i++) {
                if((long)p.getFK_emdPatients()==bonusPatientsList.get(i).getBizboxId()){
                    if(bonusTransactionDAO.getByBbrranst((long)p.getFK_psPatRegisters())) {
                        BonusTransaction transaction = new BonusTransaction();
                        transaction.setRate(bonusPatientsList.get(i).getBonusDiscount().getBonusRate());
                        transaction.setPatientId(bonusPatientsList.get(i).getId());
                        transaction.setPayment(p.getDebit());
                        transaction.setBefore(p.getDebit());
                        //new BigDecimal(p.getDebit().longValue() - (p.getDebit().longValue() *  bonusPatientsList.get(i).getBonusDiscount().getBonusRate() / 100))
                        ps_PatLedgersDAO.update(formula(p.getDebit(), bonusPatientsList.get(i).getBonusDiscount().getBonusRate()), p.getPK_psPatledgers());
                        transaction.setAfter(formula(p.getDebit(), bonusPatientsList.get(i).getBonusDiscount().getBonusRate()));
                        transaction.setCanceled(false);
                        transaction.setComplete(true);
                        transaction.setBBTransID((long) p.getFK_psPatRegisters());
                        bonusTransactionDAO.add(transaction);
                    }
                }
            }
        }
    }

    public BigDecimal formula(BigDecimal start,Byte rated){
        System.out.println("==============================");
        System.out.println("BONUS RATE " + rated);
        System.out.println("SUM " + start);
        BigDecimal rate = new BigDecimal(rated);
      return start = start.subtract(start.multiply(rate).divide(new BigDecimal(100)));
    }
}

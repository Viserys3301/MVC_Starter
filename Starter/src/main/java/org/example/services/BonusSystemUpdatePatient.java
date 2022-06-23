package org.example.services;

import org.example.DAO.BonusPatientDAO;
import org.example.DAO.BonusTransactionDAO;
import org.example.DAO.psPatLedgersDAO;
import org.example.DAO.psPatitemDAO;
import org.example.entities.BonusPatient;
import org.example.entities.BonusTransaction;
import org.example.entities.psPatLedgers;
import org.example.entities.psPatitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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


    public void updateAndSave(List<psPatLedgers> patients){
        for (int i = 0; i < patients.size(); i++) {
            System.out.println("--------------------");
            System.out.println(patients.get(i));
            System.out.println("--------------------");
        }
    }
}

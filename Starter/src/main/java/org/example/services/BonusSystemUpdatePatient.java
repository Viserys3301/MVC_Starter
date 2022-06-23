package org.example.services;

import org.example.DAO.BonusPatientDAO;
import org.example.DAO.BonusTransactionDAO;
import org.example.DAO.psPatitemDAO;
import org.example.entities.BonusPatient;
import org.example.entities.BonusTransaction;
import org.example.entities.psPatitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BonusSystemUpdatePatient {

    BonusPatientDAO bonusPatientDAO;
    psPatitemDAO ps_PatitemDAO;
    BonusTransactionDAO bonusTransactionDAO;

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

    List<BonusPatient> bonusPatients;
    List<psPatitem> ps_Patitems;
    List<BonusTransaction> bonusTransactions;

    List<psPatitem> sortPsPatitems;
    List<psPatitem> newSortPsPatitems;

    public void update(){
        bonusPatients = bonusPatientDAO.bPatientsGetAll();
        ps_Patitems = ps_PatitemDAO.getPsPatitems();
        for (psPatitem p:ps_Patitems) {
            for (int i = 0; i <bonusPatients.size() ; i++) {
                if(p.getFK_emdPatients().equals(bonusPatients.get(i).getBizboxId())){
                    sortPsPatitems.add(p);
                }
            }
        }

        for (psPatitem p:sortPsPatitems) {
            for (int i = 0; i < bonusTransactions.size(); i++) {
                if(!p.getFK_psPatRegisters().equals(bonusTransactions.get(i).getBBTransID())){
                    newSortPsPatitems.add(p);
                }
            }
        }
        updateAndSave(newSortPsPatitems);
    }


    public void updateAndSave(List<psPatitem> patients){
        for (int i = 0; i < patients.size(); i++) {
            System.out.println("--------------------");
            System.out.println(patients.get(i));
            System.out.println("--------------------");
        }
    }
}

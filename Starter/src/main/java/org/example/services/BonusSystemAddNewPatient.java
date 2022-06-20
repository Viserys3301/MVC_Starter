package org.example.services;

import org.example.DAO.psPatLedgersDAO;
import org.example.entities.psPatLedgers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class BonusSystemAddNewPatient {
    Timestamp timestampStart;
    Timestamp timestampEnd;

    SimpleDateFormat simpleDateFormatAM = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");

    public static boolean find = true;

    psPatLedgersDAO psPatLedgersDAO;

    @Autowired
    public void setPsPatLedgersDAO(org.example.DAO.psPatLedgersDAO psPatLedgersDAO) {
        this.psPatLedgersDAO = psPatLedgersDAO;
    }

    List<psPatLedgers> payments;

    public void findNewPatient(){
        try {
            while (find){
                timestampStart = Timestamp.valueOf(LocalDateTime.now().minusHours(12));
                timestampEnd = Timestamp.valueOf(LocalDateTime.now());
                payments = psPatLedgersDAO.findPayments(timestampStart,timestampEnd,simpleDateFormatAM);
                addNewPatient();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addNewPatient(){

    }


}

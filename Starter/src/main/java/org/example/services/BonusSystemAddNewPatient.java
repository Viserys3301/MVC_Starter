package org.example.services;

import org.example.DAO.BonusDiscountDAO;
import org.example.DAO.BonusPatientDAO;
import org.example.DAO.psPatLedgersDAO;
import org.example.entities.BonusDiscount;
import org.example.entities.BonusPatient;
import org.example.entities.psPatLedgers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.NamedQuery;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class BonusSystemAddNewPatient {
    Timestamp timestampStart;
    Timestamp timestampEnd;

    SimpleDateFormat simpleDateFormatAM = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");

    public static boolean find = true;
    List<psPatLedgers> payments;
    List<BonusDiscount> discounts = null;
    List<BonusPatient> patients;
    psPatLedgersDAO ps_PatLedgersDAO;
    BonusDiscountDAO bonusDiscountDAO;

    BonusPatientDAO bonusPatientDAO;

    private BigDecimal bigDecimalSum;
    private Byte discountId;

    @Autowired
    public void setBonusPatientDAO(BonusPatientDAO bonusPatientDAO) {
        this.bonusPatientDAO = bonusPatientDAO;
    }

    @Autowired
    public void setPsPatLedgersDAO(org.example.DAO.psPatLedgersDAO ps_PatLedgersDAO) {
        this.ps_PatLedgersDAO = ps_PatLedgersDAO;
    }

    @Autowired
    public void setBonusDiscountDAO(BonusDiscountDAO bonusDiscountDAO) {
        this.bonusDiscountDAO = bonusDiscountDAO;
    }



    public List<psPatLedgers> findNewPatient(){
        try {
                timestampStart = Timestamp.valueOf(LocalDateTime.now().minusHours(120));
                timestampEnd = Timestamp.valueOf(LocalDateTime.now());
                payments = ps_PatLedgersDAO.findPayments(timestampStart,timestampEnd,simpleDateFormatAM);
            for (psPatLedgers p:payments) {
                if(bonusPatientDAO.getBollById(Long.valueOf(p.getFK_emdPatients()))){

                    discounts = bonusDiscountDAO.findAll();

                    for (int i = discounts.size()-1; i >=0 ; i--) {
                        if (bonusPatientDAO.getBollById(Long.valueOf(p.getFK_emdPatients()))){
                            if (p.getOramount().compareTo(discounts.get(i).getBonusSum()) == 1) {

                                BonusPatient pat = new BonusPatient();
                                pat.setIsActive(true);
                                pat.setBonusDiscount(discounts.get(i));
                                pat.setSum(new BigDecimal(0));
                                pat.setName(p.getFK_emdPatients() + "");
                                pat.setBizboxId(Long.valueOf(p.getFK_emdPatients()));
                                bonusPatientDAO.add(pat);
                            } else {

                            }
                    }
                    }
                }
                else {

                }
            }
            return payments;
        }catch (Exception e){
            e.printStackTrace();
        }
        return payments;
    }
}

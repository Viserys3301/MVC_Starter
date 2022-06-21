package org.example.controllers;

import org.example.services.BonusSystemAddNewPatient;
import org.example.services.BonusSystemUpdatePatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/start")
public class StartAppController {


    BonusSystemAddNewPatient bonusSystemAddNewPatient;
    BonusSystemUpdatePatient bonusSystemUpdatePatient;

    public static boolean ACTIVE = true;

    @Autowired
    public void setBonusSystemAddNewPatient(BonusSystemAddNewPatient bonusSystemAddNewPatient) {
        this.bonusSystemAddNewPatient = bonusSystemAddNewPatient;
    }

    @Autowired
    public void setBonusSystemUpdatePatient(BonusSystemUpdatePatient bonusSystemUpdatePatient) {
        this.bonusSystemUpdatePatient = bonusSystemUpdatePatient;
    }

    AtomicLong atomicLong = new AtomicLong(0);



    @GetMapping
    public String start(){

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (ACTIVE){
                    try {
                        bonusSystemAddNewPatient.findNewPatient();
                        System.out.println(atomicLong.incrementAndGet());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });


//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (ACTIVE){
//                        bonusSystemUpdatePatient.update();
//                        System.out.println(atomicLong.incrementAndGet());
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        });
        thread.start();
 //       thread2.start();

        return "bonus-system-models/patients";
    }
}

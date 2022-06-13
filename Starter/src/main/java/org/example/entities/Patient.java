package org.example.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@NoArgsConstructor
public class Patient {
    private int id;
    private String name;

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Patient> load(){
        List<Patient> patients = new ArrayList<>();

            patients.add(new Patient(1,"name" + 1) );
            patients.add(new Patient(2,"name" + 2) );
            patients.add(new Patient(3,"name" + 3) );
            patients.add(new Patient(4,"name" + 4) );
            patients.add(new Patient(5,"name" + 5) );
            patients.add(new Patient(6,"name" + 6) );

        return  patients;
    }
}

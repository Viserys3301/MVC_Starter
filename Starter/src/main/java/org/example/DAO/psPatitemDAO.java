package org.example.DAO;

import org.example.entities.psPatitem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class psPatitemDAO {

    List<psPatitem> psPatitems;

    public List<psPatitem> getPsPatitems(){
        return psPatitems;
    }
}

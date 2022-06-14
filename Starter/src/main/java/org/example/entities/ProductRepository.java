package org.example.entities;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {

    private static AtomicLong identity = new AtomicLong(0);

    private Map<Long,Product> identityMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        add( new Product(null,"Nac","Huita",new BigDecimal(3000)));
        add( new Product(null,"Fuck","Nice",new BigDecimal(5000)));
        add( new Product(null,"RAW","Ultra",new BigDecimal(7000)));
    }

    public Product add(Product product){
        product.setId(identity.incrementAndGet());
        identityMap.put(product.getId(),product);
        return identityMap.get(product.getId());
    }

    public void update(Product product){
        identityMap.put(product.getId(),product);
    }

    public void remove(Long id){
        identityMap.remove(id);
    }

    public Product findById(Long id){
        return identityMap.get(id);
    }

    public List<Product> findAll(){
        return new ArrayList<>(identityMap.values());
    }






}

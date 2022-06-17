package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bonus_discounts")
public class BonusDiscount {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "bonus_sum")
    private BigDecimal bonusSum;

    @Column(name = "bonus_rate")
    private Byte bonusRate;

    @OneToMany(mappedBy = "bonusDiscount")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    List<BonusPatient> bonusPatients;

    @CreationTimestamp
    @Column(name = "create_date")
    private Timestamp createDate;

    @UpdateTimestamp
    @Column(name = "date_time_update")
    private Timestamp dateTimeUpdate;


    @Column(name = "is_active")
    private Boolean isActive;

}

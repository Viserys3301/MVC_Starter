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
@Table(name = "bonus_patients")
public class BonusPatient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "bizbox_id")
    private Long bizboxId;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    BonusDiscount bonusDiscount;

    @Column(name = "sum")
    private BigDecimal sum;

    @CreationTimestamp
    @Column(name = "date_time_create")
    private Timestamp dateTImeCreate;

    @UpdateTimestamp
    @Column(name = "date_time_update")
    private Timestamp dateTImeUpdate;

    @Column(name = "is_aCtive")
    private Boolean isActive;

    @OneToMany(mappedBy = "patientId",fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    List<BonusTransaction> bonusTransactions;
}

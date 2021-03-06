package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bonus_transactions")
public class BonusTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private BonusPatient patientId;

    @Column(name = "b_b_trans_id")
    private Long BBTransID;

    @Column(name = "rate")
    private Byte rate;

    @Column(name = "payment")
    private BigDecimal payment;

    @Column(name = "after")
    private BigDecimal after;

    @Column(name = "before")
    private BigDecimal before;

    @Column(name = "complete")
    private Boolean complete;

    @Column(name = "canceled")
    private Boolean canceled;

    @Column(name = "b_b_trans_id_inner")
    private Long BBTransIDinner;
}



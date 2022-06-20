package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "psPatLedgers")
public class psPatLedgers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_psPatledgers")
    private Long PK_psPatledgers;

    @Column(name = "tstamp")
    private Byte[] tstamp;

    @Column(name = "ownerID")
    private String ownerID;

    @Column(name = "FK_mscBranches")
    private Short FK_mscBranches;

    @Column(name = "FK_psPatRegisters")
    private Integer FK_psPatRegisters;

    @Column(name = "FK_emdPatients")
    private Integer FK_emdPatients;

    @Column(name = "FK_TRXNO")
    private Long FK_TRXNO;

    @Column(name = "FK_mscBillTemplate")
    private Long FK_mscBillTemplate;

    @Column(name = "billtrancode")
    private String billtrancode;

    @Column(name = "dsfilecode")
    private String dsfilecode;

    @Column(name = "pattrantype")
    private String pattrantype;

    @Column(name = "doctype")
    private String doctype;

    @Column(name = "docno")
    private Integer docno;

    @Column(name = "docdate")
    private Timestamp docdate;

    @Column(name = "debit")
    private BigDecimal debit;

    @Column(name = "credit")
    private BigDecimal credit;

    @Column(name = "oramount")
    private BigDecimal oramount;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "adjamount")
    private BigDecimal adjamount;

    @Column(name = "gntramount")
    private BigDecimal gntramount;

    @Column(name = "cnamount")
    private BigDecimal cnamount;

    @Column(name = "phicamount")
    private BigDecimal phicamount;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "cancelflag")
    private Boolean cancelflag;
}

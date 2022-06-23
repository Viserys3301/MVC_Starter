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
@Table(name = "psPatinv")
public class psPatinv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_TRXNO")
    private Long PK_TRXNO;

    @Column(name = "tstamp")
    private Timestamp tstamp;

    @Column(name = "ownerID")
    private String ownerID;

    @Column(name = "FK_TRXNO_CN")
    private Long FK_TRXNO_CN;

    @Column(name = "FK_mscBranches")
    private Short FK_mscBranches;

    @Column(name = "FK_mscWarehouse")
    private Short FK_mscWarehouse;
    
    @Column(name = "FK_psPatRegisters")
    private Integer FK_psPatRegisters;

    @Column(name = "FK_emdPatients")
    private Integer FK_emdPatients;

    @Column(name = "FK_faCustomers")
    private Integer FK_faCustomers;

    @Column(name = "FK_mscDiscounts")
    private Integer FK_mscDiscounts;

    @Column(name = "FK_psPackDealTran")
    private Integer FK_psPackDealTran;

    @Column(name = "FK_emdDoctors")
    private Integer FK_emdDoctors;

    @Column(name = "FK_mscPriceGroups")
    private Integer FK_mscPriceGroups;

    @Column(name = "FK_mscPriceSchemes")
    private Integer FK_mscPriceSchemes;

    @Column(name = "FK_ASUReqUser")
    private Integer FK_ASUReqUser;

    @Column(name = "FK_ASURenUser")
    private Integer FK_ASURenUser;

    @Column(name = "FK_ASUCancel")
    private Integer FK_ASUCancel;

    @Column(name = "registryclass")
    private String registryclass;

    @Column(name = "forwarddate")
    private Timestamp forwarddate;

    @Column(name = "payername")
    private String payername;

    @Column(name = "spclareareq")
    private Boolean spclareareq;

    @Column(name = "packagedeal")
    private Boolean packagedeal;

    @Column(name = "shifttime")
    private String shifttime;

    @Column(name = "pattrantype")
    private String pattrantype;

    @Column(name = "refdocno")
    private Integer refdocno;

    @Column(name = "reqdate")
    private Timestamp reqdate;

    @Column(name = "rendate")
    private Timestamp rendate;

    @Column(name = "reqno")
    private Integer reqno;

    @Column(name = "doctype")
    private String  doctype;

    @Column(name = "docno")
    private Integer docno;

    @Column(name = "reqamount")
    private BigDecimal reqamount;

    @Column(name = "renamount")
    private BigDecimal renamount;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "rbamount")
    private BigDecimal rbamount;

    @Column(name = "netamount")
    private BigDecimal netamount;

    @Column(name = "vatamount")
    private BigDecimal vatamount;

    @Column(name = "statamount")
    private BigDecimal statamount;

    @Column(name = "rffee")
    private BigDecimal rffee;

    @Column(name = "status")
    private String status;

    @Column(name = "discflag")
    private Boolean discflag;

    @Column(name = "cancelflag")
    private Boolean cancelflag;

    @Column(name = "canceldate")
    private Timestamp canceldate;

    @Column(name = "reqprintflag")
    private Boolean reqprintflag;

    @Column(name = "reqprintcntr")
    private Short reqprintcntr;

    @Column(name = "chrgprintflag")
    private Boolean chrgprintflag;

    @Column(name = "chrgprintcntr")
    private Short chrgprintcntr;

    @Column(name = "requestfrom")
    private String  requestfrom;

    @Column(name = "reqremarks")
    private String reqremarks;

    @Column(name = "renremarks")
    private String renremarks;

    @Column(name = "canremarks")
    private String  canremarks;

    @Column(name = "returnflag")
    private Boolean returnflag;

    @Column(name = "anesdcno")
    private Integer anesdcno;

    @Column(name = "refdoctype")
    private String refdoctype;

    @Column(name = "totqty")
    private BigDecimal totqty;

    @Column(name = "totitm")
    private BigDecimal totitm;

    @Column(name = "FK_ASUGLPost")
    private Integer FK_ASUGLPost;

    @Column(name = "glpostflag")
    private Boolean glpostflag;

    @Column(name = "glpostdate")
    private Timestamp glpostdate;

    @Column(name = "invenflag")
    private Boolean invenflag;

    @Column(name = "invendate")
    private Timestamp invendate;

    @Column(name = "roomno")
    private String roomno;

    @Column(name = "sorter")
    private Short sorter;

    @Column(name = "FK_TRXNO_faJVMstr")
    private Long FK_TRXNO_faJVMstr;

    @Column(name = "regulateddocno")
    private String  regulateddocno;

    @Column(name = "FK_psPatinvCNSRC")
    private Integer FK_psPatinvCNSRC;

    @Column(name = "billno")
    private Integer billno;

    @Column(name = "billflag")
    private Integer billflag;

    @Column(name = "spclareacode")
    private String spclareacode;

    @Column(name = "spclareawhcode")
    private String  spclareawhcode;

    @Column(name = "orno")
    private Integer orno;

    @Column(name = "ordate")
    private Timestamp ordate;

    @Column(name = "priceclass")
    private String  priceclass;

    @Column(name = "nrstatcode")
    private String  nrstatcode;

    @Column(name = "supamount")
    private BigDecimal supamount;

    @Column(name = "medamount")
    private BigDecimal medamount;

    @Column(name = "examamount")
    private BigDecimal examamount;

    @Column(name = "procamount")
    private BigDecimal procamount;

    @Column(name = "mcothamount")
    private BigDecimal mcothamount;

    @Column(name = "mcsupamount")
    private BigDecimal mcsupamount;

    @Column(name = "mcmedamount")
    private BigDecimal mcmedamount;

    @Column(name = "mcexamamount")
    private BigDecimal mcexamamount;

    @Column(name = "mcprocamount")
    private BigDecimal mcprocamount;

    @Column(name = "othamount")
    private BigDecimal othamount;

    @Column(name = "gntramount")
    private BigDecimal gntramount;

    @Column(name = "paidamount")
    private BigDecimal paidamount;

    @Column(name = "reqtime")
    private String reqtime;

    @Column(name = "reqdcno")
    private Integer reqdcno;

    @Column(name = "rentime")
    private String rentime;

    @Column(name = "rendcno")
    private Integer rendcno;

    @Column(name = "paidflag")
    private Boolean paidflag;

    @Column(name = "paiddate")
    private Timestamp paiddate;

    @Column(name = "paidtime")
    private String  paidtime;

    @Column(name = "paiddcno")
    private Integer paiddcno;

    @Column(name = "canceluser")
    private Integer canceluser;

    @Column(name = "orctrlno")
    private Integer orctrlno;

    @Column(name = "barcodeID")
    private String barcodeID;

    @Column(name = "Datetoperform")
    private Timestamp Datetoperform;

    @Column(name = "IsRendered")
    private Boolean IsRendered;

    @Column(name = "barcodeIDStrFormat")
    private String  barcodeIDStrFormat;

    @Column(name = "isProcessLISFlag")
    private Boolean isProcessLISFlag;

    @Column(name = "isResultLISFlag")
    private Boolean isResultLISFlag;

    @Column(name = "lismsgsentdate")
    private Timestamp lismsgsentdate;

    @Column(name = "lisressentdate")
    private Timestamp lisressentdate;

    @Column(name = "barcodeimage")
    private Byte[] barcodeimage;

    @Column(name = "recalculateamt")
    private BigDecimal recalculateamt;

    @Column(name = "FK_emdDoctors_Referral")
    private Integer FK_emdDoctors_Referral;

    @Column(name = "FK_mscNrstation")
    private String  FK_mscNrstation;

    @Column(name = "isProcessRISFlag")
    private Boolean isProcessRISFlag;

    @Column(name = "rismsgsentdate")
    private Timestamp rismsgsentdate;























}


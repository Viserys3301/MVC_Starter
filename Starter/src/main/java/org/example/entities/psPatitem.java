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
@Table(name = "psPatitem")
public class psPatitem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_psPatitem")
    private Integer PK_psPatitem;

    @Column(name = "tstamp")
    private Byte[] tstamp;

    @Column(name = "FK_TRXNO")
    private Long FK_TRXNO;

    @Column(name = "FK_TRXNO_PHIC")
    private Long FK_TRXNO_PHIC;

    @Column(name = "FK_psPatRegisters")
    private Integer FK_psPatRegisters;

    @Column(name = "FK_emdPatients")
    private Integer FK_emdPatients;

    @Column(name = "FK_emdDoctors")
    private Integer FK_emdDoctors;

    @Column(name = "FK_emdDoctorsREQ")
    private Integer FK_emdDoctorsREQ;

    @Column(name = "FK_mscWarehouse")
    private Short FK_mscWarehouse;

    @Column(name = "FK_mscSections")
    private Short FK_mscSections;

    @Column(name = "FK_iwItemsREQ")
    private String FK_iwItemsREQ;

    @Column(name = "FK_iwItemsREN")
    private String FK_iwItemsREN;

    @Column(name = "FK_mscItemCategory")
    private Integer FK_mscItemCategory;

    @Column(name = "FK_mscPHICCategory")
    private Integer FK_mscPHICCategory;

    @Column(name = "FK_mscExamTypes")
    private Integer FK_mscExamTypes;

    @Column(name = "FK_psExamResultMstr")
    private Integer FK_psExamResultMstr;

    @Column(name = "registryclass")
    private String registryclass;

    @Column(name = "isallowdiscount")
    private Boolean isallowdiscount;

    @Column(name = "itemgroup")
    private String itemgroup;

    @Column(name = "barcodeid")
    private String barcodeid;

    @Column(name = "rxlineitem")
    private String rxlineitem;

    @Column(name = "isopenprice")
    private Boolean isopenprice;

    @Column(name = "minsaleprice")
    private BigDecimal minsaleprice;

    @Column(name = "maxsaleprice")
    private BigDecimal maxsaleprice;

    @Column(name = "updtcomp")
    private Boolean updtcomp;

    @Column(name = "examupdate")
    private Boolean examupdate;

    @Column(name = "rvuvalue")
    private BigDecimal rvuvalue;

    @Column(name = "printsection")
    private String printsection;

    @Column(name = "reqqty")
    private BigDecimal reqqty;

    @Column(name = "reqprice")
    private BigDecimal reqprice;

    @Column(name = "renqty")
    private BigDecimal renqty;

    @Column(name = "renprice")
    private BigDecimal renprice;

    @Column(name = "renflag")
    private Boolean renflag;

    @Column(name = "rendate")
    private Timestamp rendate;

    @Column(name = "adjqty")
    private BigDecimal adjqty;

    @Column(name = "deductable")
    private Boolean deductable;

    @Column(name = "medprice")
    private BigDecimal medprice;

    @Column(name = "gntrprice")
    private BigDecimal gntrprice;

    @Column(name = "rfsetup")
    private String rfsetup;

    @Column(name = "rfcomptype")
    private String rfcomptype;

    @Column(name = "rfbase")
    private BigDecimal rfbase;

    @Column(name = "rffee")
    private BigDecimal rffee;

    @Column(name = "scbaseprice")
    private BigDecimal scbaseprice;

    @Column(name = "statmark")
    private Boolean statmark;

    @Column(name = "statpercent")
    private BigDecimal statpercent;

    @Column(name = "statamount")
    private BigDecimal statamount;

    @Column(name = "purcprice")
    private BigDecimal purcprice;

    @Column(name = "unit")
    private String unit;

    @Column(name = "retqty")
    private BigDecimal retqty;

    @Column(name = "servqty")
    private BigDecimal servqty;

    @Column(name = "retkeyno")
    private Long retkeyno;

    @Column(name = "oprntype")
    private String oprntype;

    @Column(name = "withresult")
    private Boolean withresult;

    @Column(name = "epoflag")
    private Boolean epoflag;

    @Column(name = "epodate")
    private Timestamp epodate;

    @Column(name = "epouid")
    private Short epouid;

    @Column(name = "epomarkup")
    private BigDecimal epomarkup;

    @Column(name = "prevprice")
    private BigDecimal prevprice;

    @Column(name = "isallowrb")
    private Boolean isallowrb;

    @Column(name = "rbrate")
    private BigDecimal rbrate;

    @Column(name = "rbamount")
    private BigDecimal rbamount;

    @Column(name = "vatrate")
    private BigDecimal vatrate;

    @Column(name = "vatprice")
    private BigDecimal vatprice;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "cnamount")
    private BigDecimal cnamount;

    @Column(name = "adjamount")
    private BigDecimal adjamount;

    @Column(name = "phicamount")
    private BigDecimal phicamount;

    @Column(name = "gntramount")
    private BigDecimal gntramount;

    @Column(name = "oramount")
    private BigDecimal oramount;

    @Column(name = "excessmedpackqty")
    private BigDecimal excessmedpackqty;

    @Column(name = "iscomedpackage")
    private Boolean iscomedpackage;

    @Column(name = "isdxmedpackage")
    private Boolean isdxmedpackage;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "isvatapplied")
    private Boolean isvatapplied;

    @Column(name = "dosage")
    private BigDecimal dosage;

    @Column(name = "FK_emdTempFrequency")
    private Integer FK_emdTempFrequency;

    @Column(name = "FK_emdTempDurations")
    private Integer FK_emdTempDurations;

    @Column(name = "FK_emdTempUnitMeasure")
    private Integer FK_emdTempUnitMeasure;

    @Column(name = "frontenddisc")
    private BigDecimal frontenddisc;

    @Column(name = "renvatprice")
    private BigDecimal renvatprice;

    @Column(name = "rfeeposttype")
    private String rfeeposttype;

    @Column(name = "rffeepaidflag")
    private Boolean rffeepaidflag;

    @Column(name = "FK_TRXNO_faVPMstr")
    private Long FK_TRXNO_faVPMstr;

    @Column(name = "retvatprice")
    private BigDecimal retvatprice;

    @Column(name = "FK_mscICD10Items")
    private Integer FK_mscICD10Items;

    @Column(name = "FK_faVendors")
    private Integer FK_faVendors;

    @Column(name = "precaution")
    private String  precaution;

    @Column(name = "medinstruct")
    private String medinstruct;

    @Column(name = "ancillary")
    private Integer ancillary;

    @Column(name = "category")
    private String category;

    @Column(name = "consdcno")
    private Integer consdcno;

    @Column(name = "constitle")
    private String constitle;

    @Column(name = "indexno")
    private BigDecimal indexno;

    @Column(name = "itemclass")
    private String itemclass;

    @Column(name = "openprice")
    private Boolean openprice;

    @Column(name = "resultcateg")
    private String resultcateg;

    @Column(name = "resulttype")
    private Integer resulttype;

    @Column(name = "rfperc")
    private BigDecimal rfperc;

    @Column(name = "rfremitdate")
    private Timestamp rfremitdate;

    @Column(name = "rfremituid")
    private Short rfremituid;

    @Column(name = "techuid")
    private Short techuid;

    @Column(name = "withrf")
    private Boolean withrf;

    @Column(name = "primeclass")
    private String primeclass;

    @Column(name = "vendorcost")
    private BigDecimal vendorcost;

    @Column(name = "cptcode")
    private String cptcode;

    @Column(name = "cptsymbol")
    private String cptsymbol;

    @Column(name = "FK_mscCPTModifiers")
    private String FK_mscCPTModifiers;

    @Column(name = "cptprice")
    private BigDecimal cptprice;

    @Column(name = "FK_emdTempPrecautions")
    private Integer FK_emdTempPrecautions;

    @Column(name = "FK_mscUnitsDosage")
    private Integer FK_mscUnitsDosage;

    @Column(name = "FrequencyValue")
    private BigDecimal FrequencyValue;

    @Column(name = "DurationValue")
    private BigDecimal DurationValue;

    @Column(name = "isExclusiveVatApplied")
    private Boolean isExclusiveVatApplied;

    @Column(name = "FK_emdDoctorsItemPF")
    private Integer FK_emdDoctorsItemPF;

    @Column(name = "FK_faManufacturer")
    private String FK_faManufacturer;

    @Column(name = "barcodeidcustom")
    private String barcodeidcustom;

    @Column(name = "Datetoperform")
    private Timestamp Datetoperform;

    @Column(name = "recalculateamt")
    private BigDecimal recalculateamt;

    @Column(name = "drsharetype")
    private String drsharetype;

    @Column(name = "drsbase")
    private BigDecimal drsbase;

    @Column(name = "medpackqty")
    private BigDecimal medpackqty;

    @Column(name = "CNreqflag")
    private Boolean CNreqflag;

    @Column(name = "netRFdisc")
    private BigDecimal netRFdisc;

    @Column(name = "rfdiscount")
    private BigDecimal rfdiscount;

    @Column(name = "rebateRateReq")
    private BigDecimal rebateRateReq;

    @Column(name = "rebateRateAnnual")
    private BigDecimal rebateRateAnnual;

    @Column(name = "istagged_rebates")
    private Boolean istagged_rebates;

    @Column(name = "istagged_annualrebates")
    private Boolean istagged_annualrebates;

    @Column(name = "FK_TRXNO_faVPMstr_rebates")
    private Long FK_TRXNO_faVPMstr_rebates;

    @Column(name = "FK_TRXNO_faVPMstr_annualrebates")
    private Long FK_TRXNO_faVPMstr_annualrebates;

    @Column(name = "iscovered")
    private Boolean iscovered;

    @Column(name = "coveredamount")
    private BigDecimal coveredamount;

    @Column(name = "coverageno")
    private Integer coverageno;

    @Column(name = "isvalidated")
    private Boolean isvalidated;

    @Column(name = "issingletest")
    private Boolean issingletest;

    @Column(name = "isCNApproved")
    private Boolean isCNApproved;

    @Column(name = "FK_ASUApprovedCNBy")
    private Integer FK_ASUApprovedCNBy;

    @Column(name = "FK_iwItemAssets")
    private Integer FK_iwItemAssets;

    @Column(name = "isCommon")
    private Boolean isCommon;

    @Column(name = "FK_mscICD10Mstr")
    private String FK_mscICD10Mstr;

    @Column(name = "rebateRateQualifier")
    private String rebateRateQualifier;

    @Column(name = "rebateRate")
    private BigDecimal rebateRate;

    @Column(name = "isRebatePerPriceScheme")
    private boolean isRebatePerPriceScheme;

    @Column(name = "pfShare")
    private BigDecimal pfShare;
}

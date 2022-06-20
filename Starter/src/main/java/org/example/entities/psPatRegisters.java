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
@Table(name = "psPatRegisters")
public class psPatRegisters {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK_psPatRegisters")
    private Integer PK_psPatRegisters;

    @Column(name = "tstamp")
    private Byte[] tstamp;

    @Column(name = "ownerID")
    private String ownerID;

    @Column(name = "FK_mscBranches")
    private Short FK_mscBranches;

    @Column(name = "FK_emdPatients")
    private Integer FK_emdPatients;

    @Column(name = "FK_mscPriceGroups")
    private Integer FK_mscPriceGroups;

    @Column(name = "FK_mscPriceSchemes")
    private Integer FK_mscPriceSchemes;

    @Column(name = "FK_mscHospPlan")
    private String  FK_mscHospPlan;

    @Column(name = "FK_mscDiscounts")
    private Integer FK_mscDiscounts;

    @Column(name = "FK_mscServiceType")
    private Integer FK_mscServiceType;

    @Column(name = "FK_mscServiceType2")
    private Integer FK_mscServiceType2;

    @Column(name = "FK_mscHospCaseTypes")
    private Integer FK_mscHospCaseTypes;

    @Column(name = "FK_mscPHICMemberships")
    private Integer FK_mscPHICMemberships;

    @Column(name = "FK_mscHospTranTypes")
    private Integer FK_mscHospTranTypes;

    @Column(name = "FK_mscRegistryGroups")
    private String FK_mscRegistryGroups;

    @Column(name = "FK_mscDispositions")
    private Integer FK_mscDispositions;

    @Column(name = "FK_mscDeathTypes")
    private Integer FK_mscDeathTypes;

    @Column(name = "FK_psPatRegistersIPD")
    private Integer FK_psPatRegistersIPD;

    @Column(name = "FK_mscAdmResults")
    private Integer FK_mscAdmResults;

    @Column(name = "pattrantype")
    private String pattrantype;

    @Column(name = "patientcateg")
    private String patientcateg;

    @Column(name = "registrystatus")
    private String registrystatus;

    @Column(name = "registryclass")
    private String registryclass;

    @Column(name = "arrivedate")
    private Timestamp arrivedate;

    @Column(name = "FK_ASURegistry")
    private Integer FK_ASURegistry;

    @Column(name = "registryno")
    private Integer registryno;

    @Column(name = "registrydate")
    private Timestamp registrydate;

    @Column(name = "registrycounter")
    private Integer registrycounter;

    @Column(name = "FK_ASUDischarge")
    private Integer FK_ASUDischarge;

    @Column(name = "dischargeno")
    private Integer dischargeno;

    @Column(name = "dischdate")
    private Timestamp dischdate;

    @Column(name = "FK_ASUBill")
    private Integer FK_ASUBill;

    @Column(name = "billno")
    private Integer billno;

    @Column(name = "billdate")
    private Timestamp billdate;

    @Column(name = "billremarks")
    private String  billremarks;

    @Column(name = "FK_ASUmgh")
    private Integer FK_ASUmgh;

    @Column(name = "mghno")
    private Integer mghno;

    @Column(name = "mghdatetime")
    private Timestamp mghdatetime;

    @Column(name = "FK_ASUuntagmgh")
    private Integer FK_ASUuntagmgh;

    @Column(name = "untagmghdatetime")
    private Timestamp untagmghdatetime;

    @Column(name = "untagmghremarks")
    private String  untagmghremarks;

    @Column(name = "FK_ASUmghc")
    private Integer FK_ASUmghc;

    @Column(name = "mghcdatetime")
    private Timestamp mghcdatetime;

    @Column(name = "FK_ASUuntagmghc")
    private Integer FK_ASUuntagmghc;

    @Column(name = "untagmghcdatetime")
    private Timestamp untagmghcdatetime;

    @Column(name = "untagmghcremarks")
    private String untagmghcremarks;

    @Column(name = "FK_ASUPrintBill")
    private Integer FK_ASUPrintBill;

    @Column(name = "billprintdate")
    private Timestamp billprintdate;

    @Column(name = "billprintcounter")
    private Integer billprintcounter;

    @Column(name = "mrlocator")
    private String mrlocator;

    @Column(name = "patientno")
    private String patientno;

    @Column(name = "qualifiers")
    private String qualifiers;

    @Column(name = "ssclass")
    private String ssclass;

    @Column(name = "applyrf")
    private Boolean applyrf;

    @Column(name = "informname")
    private String informname;

    @Column(name = "informaddr")
    private String informaddr;

    @Column(name = "informrelation")
    private String informrelation;

    @Column(name = "rank")
    private String rank;

    @Column(name = "profitdate")
    private Timestamp profitdate;

    @Column(name = "nature")
    private String nature;

    @Column(name = "servicestatus")
    private Short servicestatus;

    @Column(name = "result")
    private Short result;

    @Column(name = "mcapply")
    private Boolean mcapply;

    @Column(name = "illnesstype")
    private String illnesstype;

    @Column(name = "ruvtype")
    private String ruvtype;

    @Column(name = "ruvvalue")
    private BigDecimal ruvvalue;

    @Column(name = "chrgapplied")
    private Boolean chrgapplied;

    @Column(name = "coapprove")
    private Boolean coapprove;

    @Column(name = "treatment")
    private String treatment;

    @Column(name = "sharemark")
    private Integer sharemark;

    @Column(name = "newbornstat")
    private String newbornstat;

    @Column(name = "chiefcomplaint")
    private String chiefcomplaint;

    @Column(name = "impression")
    private String impression;

    @Column(name = "dischdiagnosis")
    private String dischdiagnosis;

    @Column(name = "finaldiagcode")
    private String finaldiagcode;

    @Column(name = "finaldiagnosis")
    private String finaldiagnosis;

    @Column(name = "surgicalproc")
    private String surgicalproc;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "isHoldReg")
    private Boolean isHoldReg;

    @Column(name = "FK_ASUHold")
    private Integer FK_ASUHold;

    @Column(name = "holdremarks")
    private String holdremarks;

    @Column(name = "holddate")
    private Timestamp holddate;

    @Column(name = "isOfficialReg")
    private Boolean isOfficialReg;

    @Column(name = "isCriticallyIll")
    private Boolean isCriticallyIll;

    @Column(name = "isDeadOnArrival")
    private Boolean isDeadOnArrival;

    @Column(name = "isDiedIn48Hours")
    private Boolean isDiedIn48Hours;

    @Column(name = "isWithAutopsy")
    private Boolean isWithAutopsy;

    @Column(name = "isWithPhilHealth")
    private Boolean isWithPhilHealth;

    @Column(name = "FK_ASUCancel")
    private Integer FK_ASUCancel;

    @Column(name = "cancelflag")
    private Boolean cancelflag;

    @Column(name = "canceldate")
    private Timestamp canceldate;

    @Column(name = "cancelremarks")
    private String cancelremarks;

    @Column(name = "referredfrom")
    private String referredfrom;

    @Column(name = "isWithMedicalPackage")
    private Boolean isWithMedicalPackage;

    @Column(name = "custcolorcode")
    private String custcolorcode;

    @Column(name = "deathDate")
    private Timestamp deathDate;

    @Column(name = "age")
    private String age;

    @Column(name = "FK_mscReferringCenters")
    private String FK_mscReferringCenters;

    @Column(name = "clinicchiefcomplaints")
    private String clinicchiefcomplaints;

    @Column(name = "mrremarks")
    private String mrremarks;

    @Column(name = "VoucherNo")
    private Long VoucherNo;

    @Column(name = "FK_apptTrans")
    private Integer FK_apptTrans;

    @Column(name = "casetype")
    private String casetype;

    @Column(name = "disposition")
    private String  disposition;

    @Column(name = "FK_mscPHICClass")
    private String  FK_mscPHICClass;

    @Column(name = "subservicetype")
    private String  subservicetype;

    @Column(name = "taxinvoiceno")
    private String taxinvoiceno;

    @Column(name = "hospno")
    private String hospno;

    @Column(name = "preOperativeDx")
    private String preOperativeDx;

    @Column(name = "postOperativeDx")
    private String postOperativeDx;

    @Column(name = "pattagbarcodeid")
    private String pattagbarcodeid;

    @Column(name = "pattagbarcodestring")
    private String pattagbarcodestring;

    @Column(name = "barcodeimage")
    private Byte[] barcodeimage;

    @Column(name = "isHemodialysis")
    private Boolean isHemodialysis;

    @Column(name = "FK_psPatPrivilegeCard")
    private Integer FK_psPatPrivilegeCard;

    @Column(name = "FK_faCustomersDependent")
    private Integer FK_faCustomersDependent;

    @Column(name = "referredTo")
    private String  referredTo;

    @Column(name = "fk_mscTownCity")
    private Integer fk_mscTownCity;

    @Column(name = "FK_mscMedSocialService")
    private Integer FK_mscMedSocialService;

    @Column(name = "FK_mscPetBreed")
    private Integer FK_mscPetBreed;

    @Column(name = "referredFromHCI")
    private String  referredFromHCI;

    @Column(name = "referredFromHCIAddress")
    private String  referredFromHCIAddress;

    @Column(name = "referredFromHCICode")
    private String  referredFromHCICode;

    @Column(name = "referredToHCI")
    private String referredToHCI;

    @Column(name = "referredToHCIAddress")
    private String referredToHCIAddress;

    @Column(name = "referredToHCICode")
    private String referredToHCICode;

    @Column(name = "referralReason")
    private String referralReason;

    @Column(name = "isPeritoneal")
    private Boolean isPeritoneal;

    @Column(name = "isLINAC")
    private Boolean isLINAC;

    @Column(name = "isCOBALT")
    private Boolean isCOBALT;

    @Column(name = "isBloodTrans")
    private Boolean isBloodTrans;

    @Column(name = "isChemotherapy")
    private Boolean isChemotherapy;

    @Column(name = "isBrachytherapy")
    private Boolean isBrachytherapy;

    @Column(name = "isDebridement")
    private Boolean isDebridement;

    @Column(name = "PhicRefNo")
    private String PhicRefNo;

    @Column(name = "FK_mscBarangay")
    private Integer FK_mscBarangay;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "height1")
    private BigDecimal height1;

    @Column(name = "height2")
    private Short height2;

    @Column(name = "bmi")
    private String  bmi;

    @Column(name = "heightUnit")
    private String  heightUnit;

    @Column(name = "weightUnit")
    private String  weightUnit;

    @Column(name = "SecondDischDiagnosis")
    private String SecondDischDiagnosis;

    @Column(name = "height3")
    private BigDecimal height3;

    @Column(name = "isWithCreditLimit")
    private Boolean isWithCreditLimit;

    @Column(name = "creditLimit")
    private BigDecimal creditLimit;

    @Column(name = "DOLEEmpNo")
    private String DOLEEmpNo;

    @Column(name = "DOLERefNo")
    private String DOLERefNo;

    @Column(name = "DOLEAppStat")
    private String DOLEAppStat;

    @Column(name = "DisembarkationDate")
    private Timestamp DisembarkationDate;

    @Column(name = "RepatriationDate")
    private Timestamp RepatriationDate;

    @Column(name = "InitialConsultDate")
    private Timestamp InitialConsultDate;

    @Column(name = "FK_mscVessels")
    private Integer FK_mscVessels;

    @Column(name = "VesselDesc")
    private String VesselDesc;

    @Column(name = "Club")
    private String Club;

    @Column(name = "ManningAgent")
    private String ManningAgent;

    @Column(name = "Multiplier")
    private String Multiplier;

    @Column(name = "Principal")
    private String Principal;

    @Column(name = "fleet")
    private String fleet;

    @Column(name = "position")
    private String position;

    @Column(name = "educationAttainment")
    private String educationAttainment;

    @Column(name = "FK_mscPatientType")
    private Integer FK_mscPatientType;

    @Column(name = "DOLEisWorkRelated")
    private Boolean DOLEisWorkRelated;

    @Column(name = "DOLEisWithOutsideCons")
    private Boolean DOLEisWithOutsideCons;

    @Column(name = "EmbarkationDate")
    private Timestamp EmbarkationDate;

    @Column(name = "contractno")
    private String contractno;

    @Column(name = "company")
    private String company;

    @Column(name = "crewstatus")
    private String crewstatus;

    @Column(name = "crewsIDNo")
    private String  crewsIDNo;

    @Column(name = "repatNo")
    private String repatNo;
}

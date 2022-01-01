package com.sas.model.main;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name ="sas_form_checker_entry", schema ="public" )
public class FetchPMemberDataSet {
	
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @JsonProperty("sl")
	  @Column(name="sl")
	  @Id
	  private int sl;
	


	  @JsonProperty("rc_ration_card_no")
	  @Column(name="rc_ration_card_no")
	  private String rcRationCardNo;
	  
	  @JsonProperty("rc_ration_card_memberid")
	  @Column(name="rc_ration_card_memberid")
	  private String rcRationCardMemberid;
	  
	  @JsonProperty("rc_member_name_en")
	  @Column(name="rc_member_name_en")
	  private String rcMemberNameEn;
	  
 	  @JsonProperty("rc_member_name_en_markrevision")
	  @Column(name="rc_member_name_en_markrevision")
	  public String rcMemberNameEnMarkrevision;
	  
	  @JsonProperty("rc_member_name_ll")
	  @Column(name="rc_member_name_ll")
	  private String rcMemberNameLl;
	  
 	  @JsonProperty("rc_member_name_ll_markrevision")
	  @Column(name="rc_member_name_ll_markrevision")
	  public String rcMemberNameLlMarkrevision;
	  
	  @JsonProperty("rc_father_name")
	  @Column(name="rc_father_name")
	  private String rcFatherName;
	  
 	  @JsonProperty("rc_father_name_markrevision")
	  @Column(name="rc_father_name_markrevision")
	  public String rcFatherNameMarkrevision;
	  

	  @JsonProperty("rc_mother_name")
	  @Column(name="rc_mother_name")
	  private String rcMotherName;
	  
	  
 	  @JsonProperty("rc_mother_name_markrevision")
	  @Column(name="rc_mother_name_markrevision")
	  public String rcMotherNameMarkrevision;
	  

	  @JsonProperty("rc_member_dob")
	  @Column(name="rc_member_dob")
	  private String rcMemberDob;
	  
 	  @JsonProperty("rc_member_dob_markrevision")
	  @Column(name="rc_member_dob_markrevision")
	  public String rcMemberDobMarkrevision;

	  @JsonProperty("rc_mobile")
	  @Column(name="rc_mobile")
	  private String rcMobile;
	  
 	  @JsonProperty("rc_mobile_markrevision")
	  @Column(name="rc_mobile_markrevision")
	  public String rcMobileMarkrevision;
	  
	  
	  @JsonProperty("rc_uid")
	  @Column(name="rc_uid")
	  private String rcUid;
	  
	  @JsonProperty("rc_gender")
	  @Column(name="rc_gender")
	  private String rcGender;
	  
 	  @JsonProperty("rc_gender_markrevision")
	  @Column(name="rc_gender_markrevision")
	  public String rcGenderMarkrevision;
	  
	  
	  @JsonProperty("rc_caste")
	  @Column(name="rc_caste")
	  private String rcCaste;
	  
 	  @JsonProperty("rc_caste_markrevision")
	  @Column(name="rc_caste_markrevision")
	  public String rcCasteMarkrevision;
	  
	  @JsonProperty("rc_is_hof")
	  @Column(name="rc_is_hof")
	  private String rcIsHof;
	  
	  @JsonProperty("rc_lgd_district_code")
	  @Column(name="rc_lgd_district_code")
	  private String rcLgdDistrictCode;
	  
	  @JsonProperty("rc_lgd_district_name")
	  @Column(name="rc_lgd_district_name")
	  private String rcLgdDistrictName;
	  
	  @JsonProperty("rc_lgd_subdiv_code")
	  @Column(name="rc_lgd_subdiv_code")
	  private String rcLgdSubdivCode;
	  
	  @JsonProperty("rc_lgd_subdiv_name")
	  @Column(name="rc_lgd_subdiv_name")
	  private String rcLgdSubdivName;
	  
	  @JsonProperty("rc_lgd_block_code")
	  @Column(name="rc_lgd_block_code")
	  private String rcLgdBlockCode;
	  
	  @JsonProperty("rc_lgd_block_name")
	  @Column(name="rc_lgd_block_name")
	  private String rcLgdBlockName;
	  
	  @JsonProperty("rc_lgd_gp_code")
	  @Column(name="rc_lgd_gp_code")
	  private String rcLgdGpCode;
	  
	  @JsonProperty("rc_lgd_gp_name")
	  @Column(name="rc_lgd_gp_name")
	  private String rcLgdGpName;
	  
	  @JsonProperty("rc_landmark")
	  @Column(name="rc_landmark")
	  private String rcLandmark;
	  
	  @JsonProperty("aadhaar_uid")
	  @Column(name="aadhaar_uid")
	  private String aadhaarUid;
	  
	  @JsonProperty("aadhaar_member_name_en")
	  @Column(name="aadhaar_member_name_en")
	  private String aadhaarMemberNameEn;
	  
 	  @JsonProperty("aadhaar_member_name_en_markrevision")
	  @Column(name="aadhaar_member_name_en_markrevision")
	  public String aadhaarMemberNameEnMarkrevision;
	  
	  
	  @JsonProperty("aadhaar_member_name_ll")
	  @Column(name="aadhaar_member_name_ll")
	  private String aadhaarMemberNameLl;
	  
 	  @JsonProperty("aadhaar_member_name_ll_markrevision")
	  @Column(name="aadhaar_member_name_ll_markrevision")
	  public String aadhaarMemberNameLlMarkrevision;
	  
	  
	  @JsonProperty("aadhaar_father_name")
	  @Column(name="aadhaar_father_name")
	  private String aadhaarFatherName;
	  
 	  @JsonProperty("aadhaar_father_name_markrevision")
	  @Column(name="aadhaar_father_name_markrevision")
	  public String aadhaarFatherNameMarkrevision;
	  
	  
	  @JsonProperty("aadhaar_mother_name")
	  @Column(name="aadhaar_mother_name")
	  private String aadhaarMotherName;
	  
 	  @JsonProperty("aadhaar_mother_name_markrevision")
	  @Column(name="aadhaar_mother_name_markrevision")
	  public String aadhaarMotherNameMarkrevision;
	  
	  @JsonProperty("aadhaar_member_dob")
	  @Column(name="aadhaar_member_dob")
	  private String aadhaarMemberDob;
	  
 	  @JsonProperty("aadhaar_member_dob_markrevision")
	  @Column(name="aadhaar_member_dob_markrevision")
	  public String aadhaarMemberDobMarkrevision;
	  
	  
	  @JsonProperty("aadhaar_gender")
	  @Column(name="aadhaar_gender")
	  private String aadhaarGender;
	  
 	  @JsonProperty("aadhaar_gender_markrevision")
	  @Column(name="aadhaar_gender_markrevision")
	  public String aadhaarGenderMarkrevision;
	  

	  @JsonProperty("aadhaar_caste")
	  @Column(name="aadhaar_caste")
	  private String aadhaarCaste;
	  
 	  @JsonProperty("aadhaar_caste_markrevision")
	  @Column(name="aadhaar_caste_markrevision")
	  public String aadhaarCasteMarkrevision;
	  
	  
	  @JsonProperty("aadhaar_pin")
	  @Column(name="aadhaar_pin")
	  private String aadhaarPin;
	  
	  @JsonProperty("aadhaar_hibitation")
	  @Column(name="aadhaar_hibitation")
	  private String aadhaarHibitation;
	  
	  @JsonProperty("aadhaar_address")
	  @Column(name="aadhaar_address")
	  private String aadhaarAddress;
	  
	  @JsonProperty("final_member_name_en")
	  @Column(name="final_member_name_en")
	  private String finalMemberNameEn;
	  
	  @JsonProperty("final_member_name_ll")
	  @Column(name="final_member_name_ll")
	  private String finalMemberNameLl;
	  
	  @JsonProperty("final_father_name")
	  @Column(name="final_father_name")
	  private String finalFatherName;
	  
	  @JsonProperty("final_mother_name")
	  @Column(name="final_mother_name")
	  private String finalMotherName;
	  
	  @JsonProperty("final_member_dob")
	  @Column(name="final_member_dob")
	  private String finalMemberDob;
	  
	  @JsonProperty("final_mobile")
	  @Column(name="final_mobile")
	  private String finalMobile;
	  
	  @JsonProperty("final_email")
	  @Column(name="final_email")
	  private String finalEmail;
	  
	  @JsonProperty("final_gender")
	  @Column(name="final_gender")
	  private String finalGender;
	  
	  @JsonProperty("final_caste")
	  @Column(name="final_caste")
	  private String finalCaste;
	  
	  @JsonProperty("final_lgd_district_code")
	  @Column(name="final_lgd_district_code")
	  private String finalLgdDistrictCode;
	  
	  @JsonProperty("final_lgd_district_name")
	  @Column(name="final_lgd_district_name")
	  private String finalLgdDistrictName;
	  
	  @JsonProperty("final_lgd_subdiv_code")
	  @Column(name="final_lgd_subdiv_code")
	  private String finalLgdSubdivCode;
	  
	  @JsonProperty("final_lgd_subdiv_name")
	  @Column(name="final_lgd_subdiv_name")
	  private String finalLgdSubdivName;
	  
	  @JsonProperty("final_lgd_block_code")
	  @Column(name="final_lgd_block_code")
	  private String finalLgdBlockCode;
	  
	  @JsonProperty("final_lgd_block_name")
	  @Column(name="final_lgd_block_name")
	  private String finalLgdBlockName;
	  
	  @JsonProperty("final_lgd_gp_code")
	  @Column(name="final_lgd_gp_code")
	  private String finalLgdGpCode;
	  
	  @JsonProperty("final_lgd_gp_name")
	  @Column(name="final_lgd_gp_name")
	  private String finalLgdGpName;
	  
	  @JsonProperty("final_landmark")
	  @Column(name="final_landmark")
	  private String finalLandmark;
	  
	  @JsonProperty("final_policestation")
	  @Column(name="final_policestation")
	  private String finalPolicestation;
	  
	  @JsonProperty("final_Postoffice")
	  @Column(name="final_Postoffice")
	  private String finalPostoffice;
	  
	  @JsonProperty("fina_Pin")
	  @Column(name="final_Pin")
	  private String finalPin;
	  
	  @JsonProperty("final_Hibitation")
	  @Column(name="final_Hibitation")
	  private String finalHibitation;
	  
	  @JsonProperty("uploadby")
	  @Column(name="uploadby")
	  private String uploadby;
	  
	  @JsonProperty("approvedby")
	  @Column(name="approvedby")
	  private String approvedby;
	  
	  
	  @JsonProperty("uploaddatetime")
	  @Column(name="uploaddatetime")
	  private Timestamp uploaddatetime;
	  
	  @JsonProperty("approveddatetime")
	  @Column(name="approveddatetime")
	  private Timestamp approveddatetime;
	  
	  
	  
	  

    public FetchPMemberDataSet(int sl, String rcRationCardNo, String rcRationCardMemberid, String rcMemberNameEn,
			String rcMemberNameEnMarkrevision, String rcMemberNameLl, String rcMemberNameLlMarkrevision,
			String rcFatherName, String rcFatherNameMarkrevision, String rcMotherName, String rcMotherNameMarkrevision,
			String rcMemberDob, String rcMemberDobMarkrevision, String rcMobile, String rcMobileMarkrevision,
			String rcUid, String rcGender, String rcGenderMarkrevision, String rcCaste, String rcCasteMarkrevision,
			String rcIsHof, String rcLgdDistrictCode, String rcLgdDistrictName, String rcLgdSubdivCode,
			String rcLgdSubdivName, String rcLgdBlockCode, String rcLgdBlockName, String rcLgdGpCode,
			String rcLgdGpName, String rcLandmark, String aadhaarUid, String aadhaarMemberNameEn,
			String aadhaarMemberNameEnMarkrevision, String aadhaarMemberNameLl, String aadhaarMemberNameLlMarkrevision,
			String aadhaarFatherName, String aadhaarFatherNameMarkrevision, String aadhaarMotherName,
			String aadhaarMotherNameMarkrevision, String aadhaarMemberDob, String aadhaarMemberDobMarkrevision,
			String aadhaarGender, String aadhaarGenderMarkrevision, String aadhaarCaste,
			String aadhaarCasteMarkrevision, String aadhaarPin, String aadhaarHibitation, String aadhaarAddress,
			String finalMemberNameEn, String finalMemberNameLl, String finalFatherName, String finalMotherName,
			String finalMemberDob, String finalMobile, String finalEmail, String finalGender, String finalCaste,
			String finalLgdDistrictCode, String finalLgdDistrictName, String finalLgdSubdivCode,
			String finalLgdSubdivName, String finalLgdBlockCode, String finalLgdBlockName, String finalLgdGpCode,
			String finalLgdGpName, String finalLandmark, String finalPolicestation, String finalPostoffice,
			String finalPin, String finalHibitation, String uploadby, String approvedby, Timestamp uploaddatetime,
			Timestamp approveddatetime) {
		super();
		this.sl = sl;
		this.rcRationCardNo = rcRationCardNo;
		this.rcRationCardMemberid = rcRationCardMemberid;
		this.rcMemberNameEn = rcMemberNameEn;
		this.rcMemberNameEnMarkrevision = rcMemberNameEnMarkrevision;
		this.rcMemberNameLl = rcMemberNameLl;
		this.rcMemberNameLlMarkrevision = rcMemberNameLlMarkrevision;
		this.rcFatherName = rcFatherName;
		this.rcFatherNameMarkrevision = rcFatherNameMarkrevision;
		this.rcMotherName = rcMotherName;
		this.rcMotherNameMarkrevision = rcMotherNameMarkrevision;
		this.rcMemberDob = rcMemberDob;
		this.rcMemberDobMarkrevision = rcMemberDobMarkrevision;
		this.rcMobile = rcMobile;
		this.rcMobileMarkrevision = rcMobileMarkrevision;
		this.rcUid = rcUid;
		this.rcGender = rcGender;
		this.rcGenderMarkrevision = rcGenderMarkrevision;
		this.rcCaste = rcCaste;
		this.rcCasteMarkrevision = rcCasteMarkrevision;
		this.rcIsHof = rcIsHof;
		this.rcLgdDistrictCode = rcLgdDistrictCode;
		this.rcLgdDistrictName = rcLgdDistrictName;
		this.rcLgdSubdivCode = rcLgdSubdivCode;
		this.rcLgdSubdivName = rcLgdSubdivName;
		this.rcLgdBlockCode = rcLgdBlockCode;
		this.rcLgdBlockName = rcLgdBlockName;
		this.rcLgdGpCode = rcLgdGpCode;
		this.rcLgdGpName = rcLgdGpName;
		this.rcLandmark = rcLandmark;
		this.aadhaarUid = aadhaarUid;
		this.aadhaarMemberNameEn = aadhaarMemberNameEn;
		this.aadhaarMemberNameEnMarkrevision = aadhaarMemberNameEnMarkrevision;
		this.aadhaarMemberNameLl = aadhaarMemberNameLl;
		this.aadhaarMemberNameLlMarkrevision = aadhaarMemberNameLlMarkrevision;
		this.aadhaarFatherName = aadhaarFatherName;
		this.aadhaarFatherNameMarkrevision = aadhaarFatherNameMarkrevision;
		this.aadhaarMotherName = aadhaarMotherName;
		this.aadhaarMotherNameMarkrevision = aadhaarMotherNameMarkrevision;
		this.aadhaarMemberDob = aadhaarMemberDob;
		this.aadhaarMemberDobMarkrevision = aadhaarMemberDobMarkrevision;
		this.aadhaarGender = aadhaarGender;
		this.aadhaarGenderMarkrevision = aadhaarGenderMarkrevision;
		this.aadhaarCaste = aadhaarCaste;
		this.aadhaarCasteMarkrevision = aadhaarCasteMarkrevision;
		this.aadhaarPin = aadhaarPin;
		this.aadhaarHibitation = aadhaarHibitation;
		this.aadhaarAddress = aadhaarAddress;
		this.finalMemberNameEn = finalMemberNameEn;
		this.finalMemberNameLl = finalMemberNameLl;
		this.finalFatherName = finalFatherName;
		this.finalMotherName = finalMotherName;
		this.finalMemberDob = finalMemberDob;
		this.finalMobile = finalMobile;
		this.finalEmail = finalEmail;
		this.finalGender = finalGender;
		this.finalCaste = finalCaste;
		this.finalLgdDistrictCode = finalLgdDistrictCode;
		this.finalLgdDistrictName = finalLgdDistrictName;
		this.finalLgdSubdivCode = finalLgdSubdivCode;
		this.finalLgdSubdivName = finalLgdSubdivName;
		this.finalLgdBlockCode = finalLgdBlockCode;
		this.finalLgdBlockName = finalLgdBlockName;
		this.finalLgdGpCode = finalLgdGpCode;
		this.finalLgdGpName = finalLgdGpName;
		this.finalLandmark = finalLandmark;
		this.finalPolicestation = finalPolicestation;
		this.finalPostoffice = finalPostoffice;
		this.finalPin = finalPin;
		this.finalHibitation = finalHibitation;
		this.uploadby = uploadby;
		this.approvedby = approvedby;
		this.uploaddatetime = uploaddatetime;
		this.approveddatetime = approveddatetime;
	}

	public FetchPMemberDataSet() {}

	public int getSl() {
		return sl;
	}

	public void setSl(int sl) {
		this.sl = sl;
	}

	public String getRcRationCardNo() {
		return rcRationCardNo;
	}

	public void setRcRationCardNo(String rcRationCardNo) {
		this.rcRationCardNo = rcRationCardNo;
	}

	public String getRcRationCardMemberid() {
		return rcRationCardMemberid;
	}

	public void setRcRationCardMemberid(String rcRationCardMemberid) {
		this.rcRationCardMemberid = rcRationCardMemberid;
	}

	public String getRcMemberNameEn() {
		return rcMemberNameEn;
	}

	public void setRcMemberNameEn(String rcMemberNameEn) {
		this.rcMemberNameEn = rcMemberNameEn;
	}

	public String getRcMemberNameEnMarkrevision() {
		return rcMemberNameEnMarkrevision;
	}

	public void setRcMemberNameEnMarkrevision(String rcMemberNameEnMarkrevision) {
		this.rcMemberNameEnMarkrevision = rcMemberNameEnMarkrevision;
	}

	public String getRcMemberNameLl() {
		return rcMemberNameLl;
	}

	public void setRcMemberNameLl(String rcMemberNameLl) {
		this.rcMemberNameLl = rcMemberNameLl;
	}

	public String getRcMemberNameLlMarkrevision() {
		return rcMemberNameLlMarkrevision;
	}

	public void setRcMemberNameLlMarkrevision(String rcMemberNameLlMarkrevision) {
		this.rcMemberNameLlMarkrevision = rcMemberNameLlMarkrevision;
	}

	public String getRcFatherName() {
		return rcFatherName;
	}

	public void setRcFatherName(String rcFatherName) {
		this.rcFatherName = rcFatherName;
	}

	public String getRcFatherNameMarkrevision() {
		return rcFatherNameMarkrevision;
	}

	public void setRcFatherNameMarkrevision(String rcFatherNameMarkrevision) {
		this.rcFatherNameMarkrevision = rcFatherNameMarkrevision;
	}

	public String getRcMotherName() {
		return rcMotherName;
	}

	public void setRcMotherName(String rcMotherName) {
		this.rcMotherName = rcMotherName;
	}

	public String getRcMotherNameMarkrevision() {
		return rcMotherNameMarkrevision;
	}

	public void setRcMotherNameMarkrevision(String rcMotherNameMarkrevision) {
		this.rcMotherNameMarkrevision = rcMotherNameMarkrevision;
	}

	public String getRcMemberDob() {
		return rcMemberDob;
	}

	public void setRcMemberDob(String rcMemberDob) {
		this.rcMemberDob = rcMemberDob;
	}

	public String getRcMemberDobMarkrevision() {
		return rcMemberDobMarkrevision;
	}

	public void setRcMemberDobMarkrevision(String rcMemberDobMarkrevision) {
		this.rcMemberDobMarkrevision = rcMemberDobMarkrevision;
	}

	public String getRcMobile() {
		return rcMobile;
	}

	public void setRcMobile(String rcMobile) {
		this.rcMobile = rcMobile;
	}

	public String getRcMobileMarkrevision() {
		return rcMobileMarkrevision;
	}

	public void setRcMobileMarkrevision(String rcMobileMarkrevision) {
		this.rcMobileMarkrevision = rcMobileMarkrevision;
	}

	public String getRcUid() {
		return rcUid;
	}

	public void setRcUid(String rcUid) {
		this.rcUid = rcUid;
	}

	public String getRcGender() {
		return rcGender;
	}

	public void setRcGender(String rcGender) {
		this.rcGender = rcGender;
	}

	public String getRcGenderMarkrevision() {
		return rcGenderMarkrevision;
	}

	public void setRcGenderMarkrevision(String rcGenderMarkrevision) {
		this.rcGenderMarkrevision = rcGenderMarkrevision;
	}

	public String getRcCaste() {
		return rcCaste;
	}

	public void setRcCaste(String rcCaste) {
		this.rcCaste = rcCaste;
	}

	public String getRcCasteMarkrevision() {
		return rcCasteMarkrevision;
	}

	public void setRcCasteMarkrevision(String rcCasteMarkrevision) {
		this.rcCasteMarkrevision = rcCasteMarkrevision;
	}

	public String getRcIsHof() {
		return rcIsHof;
	}

	public void setRcIsHof(String rcIsHof) {
		this.rcIsHof = rcIsHof;
	}

	public String getRcLgdDistrictCode() {
		return rcLgdDistrictCode;
	}

	public void setRcLgdDistrictCode(String rcLgdDistrictCode) {
		this.rcLgdDistrictCode = rcLgdDistrictCode;
	}

	public String getRcLgdDistrictName() {
		return rcLgdDistrictName;
	}

	public void setRcLgdDistrictName(String rcLgdDistrictName) {
		this.rcLgdDistrictName = rcLgdDistrictName;
	}

	public String getRcLgdSubdivCode() {
		return rcLgdSubdivCode;
	}

	public void setRcLgdSubdivCode(String rcLgdSubdivCode) {
		this.rcLgdSubdivCode = rcLgdSubdivCode;
	}

	public String getRcLgdSubdivName() {
		return rcLgdSubdivName;
	}

	public void setRcLgdSubdivName(String rcLgdSubdivName) {
		this.rcLgdSubdivName = rcLgdSubdivName;
	}

	public String getRcLgdBlockCode() {
		return rcLgdBlockCode;
	}

	public void setRcLgdBlockCode(String rcLgdBlockCode) {
		this.rcLgdBlockCode = rcLgdBlockCode;
	}

	public String getRcLgdBlockName() {
		return rcLgdBlockName;
	}

	public void setRcLgdBlockName(String rcLgdBlockName) {
		this.rcLgdBlockName = rcLgdBlockName;
	}

	public String getRcLgdGpCode() {
		return rcLgdGpCode;
	}

	public void setRcLgdGpCode(String rcLgdGpCode) {
		this.rcLgdGpCode = rcLgdGpCode;
	}

	public String getRcLgdGpName() {
		return rcLgdGpName;
	}

	public void setRcLgdGpName(String rcLgdGpName) {
		this.rcLgdGpName = rcLgdGpName;
	}

	public String getRcLandmark() {
		return rcLandmark;
	}

	public void setRcLandmark(String rcLandmark) {
		this.rcLandmark = rcLandmark;
	}

	public String getAadhaarUid() {
		return aadhaarUid;
	}

	public void setAadhaarUid(String aadhaarUid) {
		this.aadhaarUid = aadhaarUid;
	}

	public String getAadhaarMemberNameEn() {
		return aadhaarMemberNameEn;
	}

	public void setAadhaarMemberNameEn(String aadhaarMemberNameEn) {
		this.aadhaarMemberNameEn = aadhaarMemberNameEn;
	}

	public String getAadhaarMemberNameEnMarkrevision() {
		return aadhaarMemberNameEnMarkrevision;
	}

	public void setAadhaarMemberNameEnMarkrevision(String aadhaarMemberNameEnMarkrevision) {
		this.aadhaarMemberNameEnMarkrevision = aadhaarMemberNameEnMarkrevision;
	}

	public String getAadhaarMemberNameLl() {
		return aadhaarMemberNameLl;
	}

	public void setAadhaarMemberNameLl(String aadhaarMemberNameLl) {
		this.aadhaarMemberNameLl = aadhaarMemberNameLl;
	}

	public String getAadhaarMemberNameLlMarkrevision() {
		return aadhaarMemberNameLlMarkrevision;
	}

	public void setAadhaarMemberNameLlMarkrevision(String aadhaarMemberNameLlMarkrevision) {
		this.aadhaarMemberNameLlMarkrevision = aadhaarMemberNameLlMarkrevision;
	}

	public String getAadhaarFatherName() {
		return aadhaarFatherName;
	}

	public void setAadhaarFatherName(String aadhaarFatherName) {
		this.aadhaarFatherName = aadhaarFatherName;
	}

	public String getAadhaarFatherNameMarkrevision() {
		return aadhaarFatherNameMarkrevision;
	}

	public void setAadhaarFatherNameMarkrevision(String aadhaarFatherNameMarkrevision) {
		this.aadhaarFatherNameMarkrevision = aadhaarFatherNameMarkrevision;
	}

	public String getAadhaarMotherName() {
		return aadhaarMotherName;
	}

	public void setAadhaarMotherName(String aadhaarMotherName) {
		this.aadhaarMotherName = aadhaarMotherName;
	}

	public String getAadhaarMotherNameMarkrevision() {
		return aadhaarMotherNameMarkrevision;
	}

	public void setAadhaarMotherNameMarkrevision(String aadhaarMotherNameMarkrevision) {
		this.aadhaarMotherNameMarkrevision = aadhaarMotherNameMarkrevision;
	}

	public String getAadhaarMemberDob() {
		return aadhaarMemberDob;
	}

	public void setAadhaarMemberDob(String aadhaarMemberDob) {
		this.aadhaarMemberDob = aadhaarMemberDob;
	}

	public String getAadhaarMemberDobMarkrevision() {
		return aadhaarMemberDobMarkrevision;
	}

	public void setAadhaarMemberDobMarkrevision(String aadhaarMemberDobMarkrevision) {
		this.aadhaarMemberDobMarkrevision = aadhaarMemberDobMarkrevision;
	}

	public String getAadhaarGender() {
		return aadhaarGender;
	}

	public void setAadhaarGender(String aadhaarGender) {
		this.aadhaarGender = aadhaarGender;
	}

	public String getAadhaarGenderMarkrevision() {
		return aadhaarGenderMarkrevision;
	}

	public void setAadhaarGenderMarkrevision(String aadhaarGenderMarkrevision) {
		this.aadhaarGenderMarkrevision = aadhaarGenderMarkrevision;
	}

	public String getAadhaarCaste() {
		return aadhaarCaste;
	}

	public void setAadhaarCaste(String aadhaarCaste) {
		this.aadhaarCaste = aadhaarCaste;
	}

	public String getAadhaarCasteMarkrevision() {
		return aadhaarCasteMarkrevision;
	}

	public void setAadhaarCasteMarkrevision(String aadhaarCasteMarkrevision) {
		this.aadhaarCasteMarkrevision = aadhaarCasteMarkrevision;
	}

	public String getAadhaarPin() {
		return aadhaarPin;
	}

	public void setAadhaarPin(String aadhaarPin) {
		this.aadhaarPin = aadhaarPin;
	}

	public String getAadhaarHibitation() {
		return aadhaarHibitation;
	}

	public void setAadhaarHibitation(String aadhaarHibitation) {
		this.aadhaarHibitation = aadhaarHibitation;
	}

	public String getAadhaarAddress() {
		return aadhaarAddress;
	}

	public void setAadhaarAddress(String aadhaarAddress) {
		this.aadhaarAddress = aadhaarAddress;
	}

	public String getFinalMemberNameEn() {
		return finalMemberNameEn;
	}

	public void setFinalMemberNameEn(String finalMemberNameEn) {
		this.finalMemberNameEn = finalMemberNameEn;
	}

	public String getFinalMemberNameLl() {
		return finalMemberNameLl;
	}

	public void setFinalMemberNameLl(String finalMemberNameLl) {
		this.finalMemberNameLl = finalMemberNameLl;
	}

	public String getFinalFatherName() {
		return finalFatherName;
	}

	public void setFinalFatherName(String finalFatherName) {
		this.finalFatherName = finalFatherName;
	}

	public String getFinalMotherName() {
		return finalMotherName;
	}

	public void setFinalMotherName(String finalMotherName) {
		this.finalMotherName = finalMotherName;
	}

	public String getFinalMemberDob() {
		return finalMemberDob;
	}

	public void setFinalMemberDob(String finalMemberDob) {
		this.finalMemberDob = finalMemberDob;
	}

	public String getFinalMobile() {
		return finalMobile;
	}

	public void setFinalMobile(String finalMobile) {
		this.finalMobile = finalMobile;
	}

	public String getFinalEmail() {
		return finalEmail;
	}

	public void setFinalEmail(String finalEmail) {
		this.finalEmail = finalEmail;
	}

	public String getFinalGender() {
		return finalGender;
	}

	public void setFinalGender(String finalGender) {
		this.finalGender = finalGender;
	}

	public String getFinalCaste() {
		return finalCaste;
	}

	public void setFinalCaste(String finalCaste) {
		this.finalCaste = finalCaste;
	}

	public String getFinalLgdDistrictCode() {
		return finalLgdDistrictCode;
	}

	public void setFinalLgdDistrictCode(String finalLgdDistrictCode) {
		this.finalLgdDistrictCode = finalLgdDistrictCode;
	}

	public String getFinalLgdDistrictName() {
		return finalLgdDistrictName;
	}

	public void setFinalLgdDistrictName(String finalLgdDistrictName) {
		this.finalLgdDistrictName = finalLgdDistrictName;
	}

	public String getFinalLgdSubdivCode() {
		return finalLgdSubdivCode;
	}

	public void setFinalLgdSubdivCode(String finalLgdSubdivCode) {
		this.finalLgdSubdivCode = finalLgdSubdivCode;
	}

	public String getFinalLgdSubdivName() {
		return finalLgdSubdivName;
	}

	public void setFinalLgdSubdivName(String finalLgdSubdivName) {
		this.finalLgdSubdivName = finalLgdSubdivName;
	}

	public String getFinalLgdBlockCode() {
		return finalLgdBlockCode;
	}

	public void setFinalLgdBlockCode(String finalLgdBlockCode) {
		this.finalLgdBlockCode = finalLgdBlockCode;
	}

	public String getFinalLgdBlockName() {
		return finalLgdBlockName;
	}

	public void setFinalLgdBlockName(String finalLgdBlockName) {
		this.finalLgdBlockName = finalLgdBlockName;
	}

	public String getFinalLgdGpCode() {
		return finalLgdGpCode;
	}

	public void setFinalLgdGpCode(String finalLgdGpCode) {
		this.finalLgdGpCode = finalLgdGpCode;
	}

	public String getFinalLgdGpName() {
		return finalLgdGpName;
	}

	public void setFinalLgdGpName(String finalLgdGpName) {
		this.finalLgdGpName = finalLgdGpName;
	}

	public String getFinalLandmark() {
		return finalLandmark;
	}

	public void setFinalLandmark(String finalLandmark) {
		this.finalLandmark = finalLandmark;
	}

	public String getFinalPolicestation() {
		return finalPolicestation;
	}

	public void setFinalPolicestation(String finalPolicestation) {
		this.finalPolicestation = finalPolicestation;
	}

	public String getFinalPostoffice() {
		return finalPostoffice;
	}

	public void setFinalPostoffice(String finalPostoffice) {
		this.finalPostoffice = finalPostoffice;
	}

	public String getFinalPin() {
		return finalPin;
	}

	public void setFinalPin(String finalPin) {
		this.finalPin = finalPin;
	}

	public String getFinalHibitation() {
		return finalHibitation;
	}

	public void setFinalHibitation(String finalHibitation) {
		this.finalHibitation = finalHibitation;
	}

	public String getUploadby() {
		return uploadby;
	}

	public void setUploadby(String uploadby) {
		this.uploadby = uploadby;
	}

	public String getApprovedby() {
		return approvedby;
	}

	public void setApprovedby(String approvedby) {
		this.approvedby = approvedby;
	}

	public Timestamp getUploaddatetime() {
		return uploaddatetime;
	}

	public void setUploaddatetime(Timestamp uploaddatetime) {
		this.uploaddatetime = uploaddatetime;
	}

	public Timestamp getApproveddatetime() {
		return approveddatetime;
	}

	public void setApproveddatetime(Timestamp approveddatetime) {
		this.approveddatetime = approveddatetime;
	}

	

}

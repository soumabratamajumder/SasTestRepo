package com.sas.rc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name="rc_member")
public class RCdetailModel implements Serializable{
	
	  @Id
	  //@GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="rowno")
	  private int rowno;
	  @Column(name="sl")
	  private int sl;
	  @Column(name="ration_card_number")
	  private String ration_card_no;
	  @Column(name="ration_card_memberid")
	  private String ration_card_memberid;
	  @Column(name="member_name_en")
	  private String member_name_en;
	  @Column(name="member_name_ll")
	  private String member_name_ll;
	  @Column(name="father_name")
	  private String father_name;
	  @Column(name="father_name_ll")
	  private String father_name_ll;
	  @Column(name="father_memberid")
	  private String father_memberid;
	  @Column(name="mother_name")
	  private String mother_name;
	  @Column(name="mother_name_ll")
	  private String mother_name_ll;
	  @Column(name="mother_memberid")
	  private String mother_memberid;
	  @Column(name="member_dob")
	  private String member_dob;
	  @Column(name="mobile_number")
	  private String mobile;
	  @Column(name="gender")
	  private String gender;
	  @Column(name="caste")
	  private String caste;
	  @Column(name="relationship_hof")
	  private String relationshipHof;
	  @Column(name="status")
	  private String status;
	  @Column(name="lgd_district_code")
	  private String lgd_district_code;
	  @Column(name="lgd_subdiv_code")
	  private String lgd_subdiv_code;
	  @Column(name="lgd_block_code")
	  private String lgd_block_code;
	  @Column(name="lgd_gp_code")
	  private String lgd_gp_code;
	  @Column(name="lgd_district_name")
	  private String lgd_district_name;
	  @Column(name="lgd_subdiv_name")
	  private String lgd_subdiv_name;
	  @Column(name="lgd_block_name")
	  private String lgd_block_name;
	  @Column(name="lgd_gp_name")
	  private String lgd_gp_name;
	  @Column(name="hof_member_id")
	  private String hofMemberid;
	  @Column(name="landmark")
	  private String landmark;
	  @Column(name="hof_member")
	  private String hof;
	  @Column(name="uid")
	    private String uid;
	  
	  
      public RCdetailModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getRowno() {
		return rowno;
	}


	public void setRowno(int rowno) {
		this.rowno = rowno;
	}


	public int getSl() {
		return sl;
	}


	public void setSl(int sl) {
		this.sl = sl;
	}


	public String getRation_card_no() {
		return ration_card_no;
	}


	public void setRation_card_no(String ration_card_no) {
		this.ration_card_no = ration_card_no;
	}


	public String getRation_card_memberid() {
		return ration_card_memberid;
	}


	public void setRation_card_memberid(String ration_card_memberid) {
		this.ration_card_memberid = ration_card_memberid;
	}


	public String getMember_name_en() {
		return member_name_en;
	}


	public void setMember_name_en(String member_name_en) {
		this.member_name_en = member_name_en;
	}


	public String getMember_name_ll() {
		return member_name_ll;
	}


	public void setMember_name_ll(String member_name_ll) {
		this.member_name_ll = member_name_ll;
	}


	public String getFather_name() {
		return father_name;
	}


	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}


	public String getFather_name_ll() {
		return father_name_ll;
	}


	public void setFather_name_ll(String father_name_ll) {
		this.father_name_ll = father_name_ll;
	}


	public String getFather_memberid() {
		return father_memberid;
	}


	public void setFather_memberid(String father_memberid) {
		this.father_memberid = father_memberid;
	}


	public String getMother_name() {
		return mother_name;
	}


	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}


	public String getMother_name_ll() {
		return mother_name_ll;
	}


	public void setMother_name_ll(String mother_name_ll) {
		this.mother_name_ll = mother_name_ll;
	}


	public String getMother_memberid() {
		return mother_memberid;
	}


	public void setMother_memberid(String mother_memberid) {
		this.mother_memberid = mother_memberid;
	}


	public String getMember_dob() {
		return member_dob;
	}


	public void setMember_dob(String member_dob) {
		this.member_dob = member_dob;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCaste() {
		return caste;
	}


	public void setCaste(String caste) {
		this.caste = caste;
	}


	public String getRelationshipHof() {
		return relationshipHof;
	}


	public void setRelationshipHof(String relationshipHof) {
		this.relationshipHof = relationshipHof;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getLgd_district_code() {
		return lgd_district_code;
	}


	public void setLgd_district_code(String lgd_district_code) {
		this.lgd_district_code = lgd_district_code;
	}


	public String getLgd_subdiv_code() {
		return lgd_subdiv_code;
	}


	public void setLgd_subdiv_code(String lgd_subdiv_code) {
		this.lgd_subdiv_code = lgd_subdiv_code;
	}


	public String getLgd_block_code() {
		return lgd_block_code;
	}


	public void setLgd_block_code(String lgd_block_code) {
		this.lgd_block_code = lgd_block_code;
	}


	public String getLgd_gp_code() {
		return lgd_gp_code;
	}


	public void setLgd_gp_code(String lgd_gp_code) {
		this.lgd_gp_code = lgd_gp_code;
	}


	public String getLgd_district_name() {
		return lgd_district_name;
	}


	public void setLgd_district_name(String lgd_district_name) {
		this.lgd_district_name = lgd_district_name;
	}


	public String getLgd_subdiv_name() {
		return lgd_subdiv_name;
	}


	public void setLgd_subdiv_name(String lgd_subdiv_name) {
		this.lgd_subdiv_name = lgd_subdiv_name;
	}


	public String getLgd_block_name() {
		return lgd_block_name;
	}


	public void setLgd_block_name(String lgd_block_name) {
		this.lgd_block_name = lgd_block_name;
	}


	public String getLgd_gp_name() {
		return lgd_gp_name;
	}


	public void setLgd_gp_name(String lgd_gp_name) {
		this.lgd_gp_name = lgd_gp_name;
	}


	public String getHofMemberid() {
		return hofMemberid;
	}


	public void setHofMemberid(String hofMemberid) {
		this.hofMemberid = hofMemberid;
	}


	public String getLandmark() {
		return landmark;
	}


	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}


	public String getHof() {
		return hof;
	}


	public void setHof(String hof) {
		this.hof = hof;
	}


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	


	     
  	


		  
	
	
	

	
	  
	
}

package com.sas.model.main;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

//@NoArgsConstructor
@Entity
@Table(name ="sas_form_checker_entry", schema ="public" )
public class pendingDataSet {
	
	  @Id
	  @Column(name="sl")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int sl;
	  
	  
	  
	  public int getSl() {
		return sl;
	   }


	public void setSl(int sl) {
		this.sl = sl;
	    }

	@JsonProperty("rc_ration_card_no")
	  @Column(name="rc_ration_card_no")
	  private String rcRationCardNo;
	  
	  @JsonProperty("rc_ration_card_memberid")
	  @Column(name="rc_ration_card_memberid")
	  private String rcRationCardMemberid;
	  
	  @JsonProperty("rc_is_hof")
	  @Column(name="rc_is_hof")
	  private String rcIsHof;
	  
	  @JsonProperty("final_member_name_en")
	  @Column(name="final_member_name_en")
	  private String finalMemberNameEn;
	  
	  
	  @JsonProperty("uploaddatetime")
	  @Column(name="uploaddatetime")
	  private Timestamp uploaddatetime;

	  
	  public pendingDataSet() {}
	  
	  
	public pendingDataSet( String rcRationCardNo, String rcRationCardMemberid, String rcIsHof,
			String finalMemberNameEn, Timestamp uploaddatetime) {
		super();
		
		this.rcRationCardNo = rcRationCardNo;
		this.rcRationCardMemberid = rcRationCardMemberid;
		this.rcIsHof = rcIsHof;
		this.finalMemberNameEn = finalMemberNameEn;
		this.uploaddatetime = uploaddatetime;
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

	public String getRcIsHof() {
		return rcIsHof;
	}

	public void setRcIsHof(String rcIsHof) {
		this.rcIsHof = rcIsHof;
	}

	public String getFinalMemberNameEn() {
		return finalMemberNameEn;
	}

	public void setFinalMemberNameEn(String finalMemberNameEn) {
		this.finalMemberNameEn = finalMemberNameEn;
	}

	public Timestamp getUploaddatetime() {
		return uploaddatetime;
	}

	public void setUploaddatetime(Timestamp uploaddatetime) {
		this.uploaddatetime = uploaddatetime;
	}

	public pendingDataSet(int sl) {
		super();
		this.sl = sl;
	}
	  

	  
	}

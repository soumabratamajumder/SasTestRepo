package com.sas.model.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="sas_form_checker_entry", schema ="public")
public class ApprovedStatus {
	
	  @Id
	  @JsonProperty("rc_ration_card_memberid")
	  @Column(name="rc_ration_card_memberid")
	  private String rcRationCardMemberid;
	  
	  @JsonProperty("status")
	  @Column(name="status")
	  private Character Status; 
	  

	
	  
	public ApprovedStatus() {}; 
	  
	public ApprovedStatus( String rcRationCardMemberid, Character status) {
		super();
		this.rcRationCardMemberid = rcRationCardMemberid;
		Status = status;
	}


	public String getRcRationCardMemberid() {
		return rcRationCardMemberid;
	}

	public void setRcRationCardMemberid(String rcRationCardMemberid) {
		this.rcRationCardMemberid = rcRationCardMemberid;
	}

	public Character getStatus() {
		return Status;
	}

	public void setStatus(Character status) {
		Status = status;
	}
	

}

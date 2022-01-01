package com.sas.model.lgd;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name="master_dist_sd_block_bac_gp")
public class GpModel implements Serializable{
	
	  @Id
	  //@GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="lgd_district_code")
	  private String id;
	  @Column(name="esubidha_district_code")
	  private String esubidha_district_code;
	  @Column(name="district_name")
	  private String district_name;
	  
	  
      public GpModel() {
		super();
		// TODO Auto-generated constructor stub
	}
      
  	

	public String getEsubidha_district_code() {
		return esubidha_district_code;
	}


	public void setEsubidha_district_code(String esubidha_district_code) {
		this.esubidha_district_code = esubidha_district_code;
	}


	public String getDistrict_name() {
		return district_name;
	}


	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	@Override
	public String toString() {
		return "DistrictModel [id=" + id + ", esubidha_district_code=" + esubidha_district_code + ", district_name="
				+ district_name + "]";
	}



		  
	
	
	

	
	  
	
}

package com.sas.model.lgd;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="tbl_subdivision")

public class SubdivisionModel implements Serializable{
	
	  @Id
	  //@GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="sl")
	  private String id;
	  @Column(name="lgd_district_code")
	  private String district_code;
	  @Column(name="lgd_subdivision_code")
	  private String subdivision_code;
	  @Column(name="subdivision_name")
	  private String subdivision_name;
	
	  
	  
		public SubdivisionModel() {
		super();
		// TODO Auto-generated constructor stub
	}

		public SubdivisionModel(String district_code, String subdivision_code, String subdivision_name) {
			super();
			this.district_code = district_code;
			this.subdivision_code = subdivision_code;
			this.subdivision_name = subdivision_name;
		}
		  
	  public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDistrict_code() {
		return district_code;
	}


	public void setDistrict_code(String district_code) {
		this.district_code = district_code;
	}


	public String getSubdivision_code() {
		return subdivision_code;
	}


	public void setSubdivision_code(String subdivision_code) {
		this.subdivision_code = subdivision_code;
	}


	public String getSubdivision_name() {
		return subdivision_name;
	}


	public void setSubdivision_name(String subdivision_name) {
		this.subdivision_name = subdivision_name;
	}

	@Override
	public String toString() {
		return "SubdivisionModel [id=" + id + ", district_code=" + district_code + ", subdivision_code="
				+ subdivision_code + ", subdivision_name=" + subdivision_name + "]";
	}



     
	
	
	

	
	  
	
}

package com.sas.model.lgd;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name="mas_police_station")
public class PolicestationModel implements Serializable{
	
	  @Id
	  //@GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="sl_no")
	  private Integer sl;
	  @Column(name="police_station_name")
	  private String police_station_name;
	 
	  
	  
      public PolicestationModel() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getSl() {
		return sl;
	}



	public void setSl(Integer sl) {
		this.sl = sl;
	}



	public String getPolice_station_name() {
		return police_station_name;
	}



	public void setPolice_station_name(String police_station_name) {
		this.police_station_name = police_station_name;
	}



	@Override
	public String toString() {
		return "PolicestationModel [sl=" + sl + ", police_station_name=" + police_station_name + "]";
	}
   


		  
	
	
	

	
	  
	
}

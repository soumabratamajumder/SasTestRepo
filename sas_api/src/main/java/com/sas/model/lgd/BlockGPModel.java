package com.sas.model.lgd;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="master_dist_sd_block_bac_gp")

public class BlockGPModel implements Serializable{
	
	  @Id
	  //@GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="gp_vc_ward_code")
	  private String gpvcwardcode;
	  @Column(name="gp_vc_ward_name")
	  private String gpvcward_name;
	  @Column(name="subdiv_code")
	  private Integer subdivcode;
	  @Column(name="block_code")
	  private Integer blockcode;
	  @Column(name="block_name")
	  private String blockname;
	  
	
	  
	  
		public BlockGPModel() {
		super();
		// TODO Auto-generated constructor stub
	}




		public String getGpvcwardcode() {
			return gpvcwardcode;
		}




		public void setGpvcwardcode(String gpvcwardcode) {
			this.gpvcwardcode = gpvcwardcode;
		}




		public String getGpvcward_name() {
			return gpvcward_name;
		}




		public void setGpvcward_name(String gpvcward_name) {
			this.gpvcward_name = gpvcward_name;
		}




		public Integer getSubdivcode() {
			return subdivcode;
		}




		public void setSubdivcode(Integer subdivcode) {
			this.subdivcode = subdivcode;
		}




		public Integer getBlockcode() {
			return blockcode;
		}




		public void setBlockcode(Integer blockcode) {
			this.blockcode = blockcode;
		}




		public String getBlockname() {
			return blockname;
		}




		public void setBlockname(String blockname) {
			this.blockname = blockname;
		}




		@Override
		public String toString() {
			return "BlockGPModel [gpvcwardcode=" + gpvcwardcode + ", gpvcward_name=" + gpvcward_name + ", subdivcode="
					+ subdivcode + ", blockcode=" + blockcode + ", blockname=" + blockname + "]";
		}


	

     
	
	
	

	
	  
	
}

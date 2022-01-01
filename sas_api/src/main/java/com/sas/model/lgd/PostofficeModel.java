package com.sas.model.lgd;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name="mas_post_office")
public class PostofficeModel implements Serializable{
	
	  @Id
	  //@GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="sl")
	  private Integer id;
	  @Column(name="pin")
	  private String pin;
	  @Column(name="post_office")
	  private String postoffice;
	  
	  
      public PostofficeModel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	public String getPostoffice() {
		return postoffice;
	}


	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
	}


	@Override
	public String toString() {
		return "PostofficeModel [id=" + id + ", pin=" + pin + ", postoffice=" + postoffice + "]";
	}
      
  	


		  
	
	
	

	
	  
	
}

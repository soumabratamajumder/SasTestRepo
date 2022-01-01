package com.sas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sas.model.main.pendingDataSet;
import com.sas.services.main.DataServices;

@RestController
public class PendingDataController {
	
	@Autowired
	private DataServices dataServices;	
	
	@GetMapping("/pendingData")
	public List<pendingDataSet> getPendingData(){
		return this.dataServices.getPendingData();
	}
	
	@PostMapping("/pendingData")
	public List<pendingDataSet> saveFinalData(@RequestBody List<pendingDataSet> finalData){
		return this.dataServices.saveFinalData(finalData);
	}

}

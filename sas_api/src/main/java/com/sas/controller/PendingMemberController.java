package com.sas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sas.model.main.FetchPMemberDataSet;
import com.sas.services.main.PMemberServices;

@RestController
public class PendingMemberController {
	
	@Autowired
	private PMemberServices pMemberServices;
	
	
	@GetMapping("/pendingMember/{mem}")
	public List<FetchPMemberDataSet> getPMemberData(@PathVariable String mem ){
		return this.pMemberServices.getPMember(mem);
	}

	@PostMapping("/pendingMember/{mem}")
	public List<FetchPMemberDataSet> savePMemberData(@RequestBody List<FetchPMemberDataSet> mem){
		return this.pMemberServices.savePMemberData(mem);
	}
}

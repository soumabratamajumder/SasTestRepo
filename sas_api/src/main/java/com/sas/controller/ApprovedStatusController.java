package com.sas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sas.services.main.ApprovedMemServices;

@RestController
public class ApprovedStatusController {
	
	@Autowired
	private ApprovedMemServices approvedMemServices;
	
	@PostMapping("/updateStatus/{rcRationCardMemberid}")
    public void updateStatus(@PathVariable("rcRationCardMemberid") String rcRationCardMemberid) {
    	
    	
    	approvedMemServices.updateStatus(rcRationCardMemberid);
		
	}

}

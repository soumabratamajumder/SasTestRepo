package com.sas.services.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.repositories.main.ApprovedStatusRepository;
@Service
public class ApprovedMemServicesImp implements ApprovedMemServices {
	
	@Autowired
	ApprovedStatusRepository approvedStatusRepository;
	
	public void updateStatus(String rcRationCardMemberid) {
		approvedStatusRepository.setUpdateStatus('1',rcRationCardMemberid);
	}


}

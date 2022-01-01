package com.sas.rc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.rc.model.RCdetailModel;
import com.sas.rc.repositories.RcRepository;



@Service
public class GetRcServiceImp implements GetRcService {

	@Autowired
	private  RcRepository rcRepository;
	

	@Override
	public List<RCdetailModel> getRcDetails(String rc) {
		List<RCdetailModel> g = rcRepository.fetchRcRecord(rc);
		return g;
	}
	@Override
	public List<RCdetailModel> getRcDetails() {
		return rcRepository.fetchRcRecord();
		
	}
	
	
	
	

}

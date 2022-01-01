package com.sas.services.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.model.main.FetchPMemberDataSet;
import com.sas.repositories.main.PMemberRepo;

@Service
public class PMemberServicesImp implements PMemberServices {
	
	@Autowired
	private PMemberRepo pMemberRepo;
	
 
	@Override
	public List<FetchPMemberDataSet> getPMember() {
		// TODO Auto-generated method stub
		return pMemberRepo.fetchPMember();
	}
	
	
	
	@Override
	public List<FetchPMemberDataSet> getPMember(String mem) {
		List<FetchPMemberDataSet> m = pMemberRepo.fetchPMember(mem);
		return m;
	}
	
	@Override
	public List<FetchPMemberDataSet> savePMemberData(List<FetchPMemberDataSet> mem){
		List<FetchPMemberDataSet> m = pMemberRepo.saveAll(mem);
		return m;
	}




}

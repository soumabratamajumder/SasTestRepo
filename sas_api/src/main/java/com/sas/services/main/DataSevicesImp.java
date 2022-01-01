package com.sas.services.main;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.model.main.pendingDataSet;
import com.sas.repositories.main.DataRepository;

@Service
public class DataSevicesImp implements DataServices {
	
	@Autowired
	private DataRepository dataRepository;
	
	@Override
	public List<pendingDataSet> getPendingData(){
		
		return this.dataRepository.fetchPendingData();
	}

	@Override
	public List<pendingDataSet> saveFinalData(List<pendingDataSet> finalData) {
		// TODO Auto-generated method stub
		return this.dataRepository.saveAll(finalData);
	}

}

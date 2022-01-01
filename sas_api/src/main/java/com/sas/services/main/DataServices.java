package com.sas.services.main;

import java.util.List;

import com.sas.model.main.pendingDataSet;
import com.sas.repositories.main.DataRepository;


public interface DataServices {
	
	public List<pendingDataSet> getPendingData();

	public List<pendingDataSet> saveFinalData(List<pendingDataSet> finalData);
}

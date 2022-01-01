package com.sas.services.main;

import java.util.List;

import com.sas.model.main.FetchPMemberDataSet;

public interface PMemberServices {
	
    List<FetchPMemberDataSet> getPMember();

	List<FetchPMemberDataSet> getPMember(String mem);

	List<FetchPMemberDataSet> savePMemberData(List<FetchPMemberDataSet> mem);

	

}

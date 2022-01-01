package com.sas.rc.service;

import java.util.List;

import com.sas.rc.model.RCdetailModel;

public interface GetRcService {

	List<RCdetailModel> getRcDetails(String rc);
	List<RCdetailModel> getRcDetails();

	

}

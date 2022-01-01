package com.sas.services.lgd;

import java.util.List;

import com.sas.model.lgd.SubdivisionModel;

public interface SubdivisionService {
	
	public List<SubdivisionModel> getSubdivision(String districtcode);

}

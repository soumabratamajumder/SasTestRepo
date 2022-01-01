package com.sas.services.lgd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.model.lgd.SubdivisionModel;
import com.sas.repositories.lgd.SubdivisionRepository;

@Service
public class SubdivisionServiceImp implements SubdivisionService {

	@Autowired
	private  SubdivisionRepository subdivisionRepository;
	
	@Override
	public List<SubdivisionModel> getSubdivision(String districtcode) {
		return subdivisionRepository.fetchSubDistrict(districtcode);
	}

}

package com.sas.services.lgd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.model.lgd.DistrictModel;
import com.sas.repositories.lgd.DistrictRepository;

@Service
public class DistrictServiceImp implements DistrictService {
	@Autowired
	private  DistrictRepository districtRepository;

	@Override
	public List<DistrictModel> getDistricts() {
		
	return districtRepository.fetchDistrict();
	}

}

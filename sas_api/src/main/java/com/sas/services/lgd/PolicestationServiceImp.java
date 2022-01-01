package com.sas.services.lgd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.model.lgd.PolicestationModel;
import com.sas.repositories.lgd.PolicestationRepository;

@Service
public class PolicestationServiceImp implements PolicestationService {

	@Autowired
	private  PolicestationRepository policestationRepository;

	@Override
	public List<PolicestationModel> getPolicestationbyDist(String distcode) {
		return policestationRepository.fetchPolicestation(distcode);
	}

	
	
	

}

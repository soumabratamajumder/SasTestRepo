package com.sas.services.lgd;

import java.util.List;

import com.sas.model.lgd.PolicestationModel;

public interface PolicestationService {

	List<PolicestationModel> getPolicestationbyDist(String distcode);

	

}

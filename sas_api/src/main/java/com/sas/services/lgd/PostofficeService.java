package com.sas.services.lgd;

import java.util.List;

import com.sas.model.lgd.PolicestationModel;
import com.sas.model.lgd.PostofficeModel;

public interface PostofficeService {

	List<PostofficeModel> getPostofficebySubdiv(String subdiv);

	

}

package com.sas.services.lgd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.model.lgd.PolicestationModel;
import com.sas.model.lgd.PostofficeModel;
import com.sas.repositories.lgd.PolicestationRepository;
import com.sas.repositories.lgd.PostofficeRepository;

@Service
public class PostofficeServiceImp implements PostofficeService {

	@Autowired
	private  PostofficeRepository PostofficeRepository;

	@Override
	public List<PostofficeModel> getPostofficebySubdiv(String subdivcode) {
		return PostofficeRepository.fetchPostoffice(subdivcode);
	}

	
	
	

}

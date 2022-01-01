package com.sas.services.lgd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.model.lgd.BlockGPModel;
import com.sas.repositories.lgd.BlockGPRepository;

@Service
public class BlockGPServiceImp implements BlockGPService {

	@Autowired
	private  BlockGPRepository blockGPRepository;

	@Override
	public List<BlockGPModel> getBlockbysubdiv(int subdivcode) {
		// TODO Auto-generated method stub
		return blockGPRepository.fetchSubDistrict(subdivcode);
	}

	@Override
	public List<BlockGPModel> getGpByBlock(int blockcode) {
		return blockGPRepository.fetchGP(blockcode);
	}
	
	

}

package com.sas.services.lgd;

import java.util.List;

import com.sas.model.lgd.BlockGPModel;

public interface BlockGPService {

	List<BlockGPModel> getBlockbysubdiv(int subdivcode);

	List<BlockGPModel> getGpByBlock(int blockcode);

}

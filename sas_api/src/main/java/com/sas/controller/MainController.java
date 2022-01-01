package com.sas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sas.model.lgd.BlockGPModel;
import com.sas.model.lgd.DistrictModel;
import com.sas.model.lgd.PolicestationModel;
import com.sas.model.lgd.PostofficeModel;
import com.sas.model.lgd.SubdivisionModel;

import com.sas.rc.model.RCdetailModel;
import com.sas.rc.service.GetRcService;
import com.sas.services.lgd.BlockGPService;
import com.sas.services.lgd.DistrictService;
import com.sas.services.lgd.PolicestationService;
import com.sas.services.lgd.PostofficeService;
import com.sas.services.lgd.SubdivisionService;
import com.sas.services.main.DataServices;

@RestController
public class MainController {

	@Autowired
	private SubdivisionService subdivisionService1;	
	@Autowired
	private DistrictService districtService;
	@Autowired
	private BlockGPService blockService;
	@Autowired
	private PolicestationService policestationService;
	@Autowired
	private PostofficeService postofficeService;
	@Autowired
	private GetRcService getRcService;
	
	@GetMapping("/district")
	public List<DistrictModel> getAllSchemegroup() {
		
		return this.districtService.getDistricts();
		
	}
	@GetMapping("/subdivision/{districtcode}")
	public List<SubdivisionModel> getSubdivByDist(@PathVariable String districtcode) {
		
		return this.subdivisionService1.getSubdivision(districtcode);
	}
	@GetMapping("/block/{subdivcode}")
	public List<BlockGPModel> getBlockbySubdiv(@PathVariable int subdivcode) {
		
		return this.blockService.getBlockbysubdiv(subdivcode);
	}
	@GetMapping("/gp/{blockcode}")
	public List<BlockGPModel> getGp(@PathVariable int blockcode) {
		
		return this.blockService.getGpByBlock(blockcode);
	}
	@GetMapping("/policestation/{districtcode}")
	public List<PolicestationModel> getPolicetation(@PathVariable String districtcode) {
		
		return this.policestationService.getPolicestationbyDist(districtcode);
	}
	@GetMapping("/postoffice/{subdivcode}")
	public List<PostofficeModel> getPostoffcie(@PathVariable String subdivcode) {
		
		return this.postofficeService.getPostofficebySubdiv(subdivcode);
	}
	@GetMapping("/fetchrcdetails/{rc}")
	public List<RCdetailModel> getRc(@PathVariable String rc) {
		
		return this.getRcService.getRcDetails(rc);
	}
	
}

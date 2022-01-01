package com.sas.repositories.lgd;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sas.model.lgd.BlockGPModel;


@Repository
public interface BlockGPRepository extends JpaRepository<BlockGPModel, String> {

	@Query(value="SELECT DISTINCT on (block_code)   block_code, block_name,  gp_vc_ward_code, gp_vc_ward_name,subdiv_code FROM lgd.master_dist_sd_block_bac_gp WHERE subdiv_code=?1", nativeQuery=true )
    List<BlockGPModel> fetchSubDistrict(int id);

	@Query(value="SELECT DISTINCT gp_vc_ward_code, gp_vc_ward_name, block_code, block_name, subdiv_code FROM lgd.master_dist_sd_block_bac_gp WHERE block_code=?1 ORDER BY gp_vc_ward_name", nativeQuery=true )
     List<BlockGPModel> fetchGP(int blockcode);
}

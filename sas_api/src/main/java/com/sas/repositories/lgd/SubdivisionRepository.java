package com.sas.repositories.lgd;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sas.model.lgd.SubdivisionModel;


@Repository
public interface SubdivisionRepository extends CrudRepository<SubdivisionModel, String>{
	@Query(value="SELECT * FROM lgd.tbl_subdivision where lgd_district_code=?1", nativeQuery=true )
    List<SubdivisionModel> fetchSubDistrict(String id);
	

}

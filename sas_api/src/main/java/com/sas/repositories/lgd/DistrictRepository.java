package com.sas.repositories.lgd;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sas.model.lgd.DistrictModel;


@Repository
public interface DistrictRepository extends JpaRepository<DistrictModel, String>{
	@Query(value="SELECT * FROM lgd.tbl_district", nativeQuery=true )
    List<DistrictModel> fetchDistrict();

}

package com.sas.repositories.lgd;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sas.model.lgd.BlockGPModel;
import com.sas.model.lgd.PolicestationModel;


@Repository
public interface PolicestationRepository extends JpaRepository<PolicestationModel, Integer> {

	@Query(value="SELECT DISTINCT sl_no, police_station_name FROM lgd.mas_police_station WHERE district_lgd_code=?1 ORDER BY police_station_name", nativeQuery=true )
    List<PolicestationModel> fetchPolicestation(String id);


}

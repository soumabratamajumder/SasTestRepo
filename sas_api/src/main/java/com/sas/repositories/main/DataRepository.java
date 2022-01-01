package com.sas.repositories.main;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sas.model.main.pendingDataSet;
import com.sas.repositories.main.DataRepository;


@Repository
public interface DataRepository extends JpaRepository<pendingDataSet, Integer> {
	@Modifying
	@Transactional
	@Query(value="SELECT * from public.get_pending_data()", nativeQuery=true )
	List<pendingDataSet> fetchPendingData();
	
	
	

}

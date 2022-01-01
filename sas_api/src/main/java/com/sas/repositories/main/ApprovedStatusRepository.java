package com.sas.repositories.main;

import java.lang.annotation.Native;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.sas.model.main.ApprovedStatus;

public interface ApprovedStatusRepository extends JpaRepository<ApprovedStatus,String>{

	
	@Modifying
	@Transactional
	@Query(value = "update sas_form_checker_entry  set status = :status where  rc_ration_card_memberid= :rc_ration_card_memberid", nativeQuery = true)	
	void setUpdateStatus (@Param("status") Character Status, @Param("rc_ration_card_memberid") String rcRationCardMemberid);
	
	
}

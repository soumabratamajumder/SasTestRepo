package com.sas.rc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.sas.rc.model.RCdetailModel;


@Repository
public interface RcRepository extends JpaRepository<RCdetailModel, Integer> {

	@Query(value="SELECT * from rc_live.get_member_details_by_rcid(?1)", nativeQuery=true )
    List<RCdetailModel> fetchRcRecord(String id);
	
	@Query(value="SELECT row_number() over (ORDER BY rcmem.fullname) as rowno,rcmem.sl, rcmem.ration_card_number, rcmem.ration_card_memberid , rcmem.fullname as member_name_en, rcmem.fullname_ll as member_name_ll, \r\n"
			+ "rcmem.father_name, rcmem.father_name_ll, \r\n"
			+ "rcmem.father_memberid, rcmem.mother_name, rcmem.mother_name_ll, rcmem.mother_memberid,\r\n"
			+ " rcmem.member_dob, rcmem.mobile_number, rcmem.gender, rcmem.caste, rcmem.relationship_hof, rcmem.status ,\r\n"
			+ " family.lgd_district_code, family.lgd_subdiv_code, family.lgd_block_code, family.lgd_gp_code,\r\n"
			+ " family.lgd_district_name, family.lgd_subdiv_name, family.lgd_block_name, family.lgd_gp_name,\r\n"
			+ " family.hof_member_id, family.landmark,\r\n"
			+ " CASE WHEN (family.hof_member_id = rcmem.ration_card_memberid )  THEN 'Y' else 'N' end as  hof_member,\r\n"
			+ " aadhaar.enc_uid as uid\r\n"
			+ "FROM rc_live.rc_member rcmem LEFT JOIN rc_live.rc_family family \r\n"
			+ " ON family.ration_card_number = rcmem.ration_card_number\r\n"
			+ "	 LEFT JOIN rc_live.rc_member_uid aadhaar \r\n"
			+ "    ON aadhaar.ration_card_memberid = rcmem.ration_card_memberid    \r\n"
			+ "	where rcmem.ration_card_number = '161000980246' and rcmem.status = '1'  order by rcmem.fullname", nativeQuery=true )
    List<RCdetailModel> fetchRcRecord();

	
}

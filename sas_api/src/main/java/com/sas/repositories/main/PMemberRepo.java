package com.sas.repositories.main;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sas.model.main.FetchPMemberDataSet;

@Repository
public interface PMemberRepo extends JpaRepository<FetchPMemberDataSet, Integer> {
	
	@Transactional
	@Modifying
	@Query(value = "SELECT * from public.get_pending_member(?1)", nativeQuery =true)
	List<FetchPMemberDataSet> fetchPMember(String Id);

	@Transactional
	@Modifying
	@Query(value ="SELECT  a.sl, a.rc_ration_card_no, a.rc_ration_card_memberid, a.rc_member_name_en, a.rc_member_name_ll, a.rc_father_name, a.rc_mother_name, a.rc_member_dob, a.rc_mobile, a.rc_uid, a.rc_gender, a.rc_caste, a.rc_is_hof, a.rc_lgd_district_code, a.rc_lgd_district_name, a.rc_lgd_subdiv_code, a.rc_lgd_subdiv_name, a.rc_lgd_block_code, a.rc_lgd_block_name, a.rc_lgd_gp_code, a.rc_lgd_gp_name, a.rc_landmark, a.aadhaar_uid, a.aadhaar_member_name_en, a.aadhaar_member_name_ll, a.aadhaar_father_name, a.aadhaar_mother_name, a.aadhaar_member_dob, a.aadhaar_gender, a.aadhaar_caste, a.aadhaar_pin, a.aadhaar_hibitation, a.aadhaar_address, a.final_member_name_en, a.final_member_name_ll, a.final_father_name, a.final_mother_name, a.final_member_dob, a.final_mobile, a.final_email, a.final_gender, a.final_caste, a.final_lgd_district_code, a.final_lgd_district_name, a.final_lgd_subdiv_code, a.final_lgd_subdiv_name, a.final_lgd_block_code, a.final_lgd_block_name, a.final_lgd_gp_code, a.final_lgd_gp_name, a.final_landmark, a.final_policestation, a.final_Postoffice, a.final_Pin , a.final_Hibitation, a.uploadby, a.approvedby, a.uploaddatetime, a.approveddatetime\n"
			+ "	FROM public.sas_form_checker_entry a\n"
			+ " \n"
			+ "	WHERE a.rc_ration_card_memberid = rc_memberid;\n"
			+ ""
			, nativeQuery = true)
	List<FetchPMemberDataSet> fetchPMember();
	

}

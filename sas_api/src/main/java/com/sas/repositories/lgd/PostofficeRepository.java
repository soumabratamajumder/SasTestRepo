package com.sas.repositories.lgd;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sas.model.lgd.BlockGPModel;
import com.sas.model.lgd.PostofficeModel;


@Repository
public interface PostofficeRepository extends JpaRepository<PostofficeModel, Integer> {

	@Query(value="SELECT DISTINCT sl||'#'||pin as pin,sl, post_office FROM lgd.mas_post_office WHERE subdiv_lgd_code=?1 ORDER BY post_office", nativeQuery=true )
    List<PostofficeModel> fetchPostoffice(String id);

	
}

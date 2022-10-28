package com.attservices.attservices.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.attservices.attservices.model.address;

public interface addressRepository extends JpaRepository<address, Integer> {

	Optional<address> findByZip(long zip);
	
	/*@Query(value="select * from address_table at2 where address_line1 like %:valueTocheck%",nativeQuery = true)
	List<address> findByAddLineContains(@Param("valueTocheck") String valueTocheck);*/
	
	@Query("select a from address a where a.addLine1 LIKE %?1%")
	List<address> findByAddLineContains(String valueTocheck);
	
	@Modifying
	@Transactional
	@Query("UPDATE address a SET a.addLin2=?1 where a.addLine1 LIKE %?2%")
	int saveAddressContains(String newAdd,String checkCharSeq);
	
	



}

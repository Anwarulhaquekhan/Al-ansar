package com.ansar.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ansar.org.domain.Donor;

@Repository
public interface DonorRepo extends JpaRepository<Donor, Long>{

	@Query(value= "SELECT *  FROM DONOR d WHERE d.amount = 'amount'", nativeQuery=true )
	List<Donor> getAllByAmount(Double amount);

	List<Donor> findAllByOrderByUpdatedDateDesc();

}

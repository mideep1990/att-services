package com.attservices.attservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attservices.attservices.model.address;

public interface addressRepository extends JpaRepository<address, Integer> {

	Optional<address> findByZip(long zip);

}

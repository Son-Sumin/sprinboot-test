package com.bitacademy.cocktail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.bitacademy.cocktail.domain.Signature;

public interface SignatureRepository extends JpaRepository<Signature, Long> {

	Signature findByNo(Long no);

	void deleteByNo(Long no);
	
	@Modifying
	@Query(value="update signature as s set s.hit = s.hit + 1 where s.no = :no", nativeQuery = true)
	void updateHit(Long no);

}
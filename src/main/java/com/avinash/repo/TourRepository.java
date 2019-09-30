package com.avinash.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avinash.domain.Tour;

public interface TourRepository extends PagingAndSortingRepository<Tour,Integer>{
	Page<Tour> findByTourPackageCode(@Param("code")String code,Pageable pageable);

	    
}

package com.avinash.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.avinash.domain.Tour;
import com.avinash.domain.TourPackage;

@RepositoryRestResource(collectionResourceRel="packages",path="packages")
public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
 TourPackage findByName(String name);
 
 @Override
	@RestResource(exported=false)
	 <S extends TourPackage> S save(S entity);

	@Override
	@RestResource(exported=false)
	 <S extends TourPackage> Iterable<S> saveAll(Iterable<S> entities) ;

	

	@RestResource(exported=false)
	void deleteByCode(String code);

	@Override
	@RestResource(exported=false)
	 void delete(TourPackage entity);

	@Override
	@RestResource(exported=false)
	 void deleteAll(Iterable<? extends TourPackage> entities);


}

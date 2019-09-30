package com.avinash.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avinash.domain.Difficulty;
import com.avinash.domain.Region;
import com.avinash.domain.Tour;
import com.avinash.domain.TourPackage;
import com.avinash.repo.TourPackageRepository;
import com.avinash.repo.TourRepository;

@Service
public class TourService {

	
	private TourRepository tourRepository;
	private TourPackageRepository tourPackageRepository;
	
	@Autowired
	public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
		this.tourRepository = tourRepository;
		this.tourPackageRepository = tourPackageRepository;
	}
	
	public Tour createTour(String title,String description,String blurb,Integer price,
			String duration,String bullets,String keywords,
			String tourPackageName,Difficulty difficulty,Region region) {
			TourPackage tourPackageOpt = (tourPackageRepository.findByName(tourPackageName));	
			if(tourPackageOpt!=null)
				return tourRepository.save(new Tour(title, description,blurb,price,duration,bullets,keywords,tourPackageOpt,difficulty,region));
			else 
			{
				throw new RuntimeException("No Tour exitst "+tourPackageName);
				//System.err.println("No Tour exitst "+tourPackageName);
				//return null;
			}	
	}
	
	public Iterable<Tour> lookup(){
		return tourRepository.findAll();
	}
	
	public long total() {
		return tourRepository.count();
	}
	
	
}

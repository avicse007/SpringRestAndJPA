package com.avinash;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.avinash.domain.Difficulty;
import com.avinash.domain.Region;
import com.avinash.services.TourPackageService;
import com.avinash.services.TourService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class ExploreCaliApplication implements CommandLineRunner{

	@Autowired
	TourService tourService;
	
	@Autowired
	TourPackageService tourPackageService;
	
	public static void main(String[] args) {
		SpringApplication.run(ExploreCaliApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		tourPackageService.createTourPackage("BC", "Backpack Cal");
		tourPackageService.createTourPackage("CC", "California Calm");
		tourPackageService.createTourPackage("CH", "California Hot springs");
		tourPackageService.createTourPackage("CY", "Cycle California");
		tourPackageService.createTourPackage("DS", "From Desert to Sea");
		tourPackageService.createTourPackage("KC", "Kids California");
		tourPackageService.createTourPackage("NW", "Nature Watch");
		tourPackageService.createTourPackage("SC", "Snowboard Cali");
		tourPackageService.createTourPackage("TC", "Taste of California");
		System.out.println("Number of tours "+tourPackageService.total());
		tourPackageService.lookup().forEach(tourPackageService->System.out.println(tourPackageService));
		TourFromFile.importTours().forEach(t->tourService.createTour(t.title, t.description, t.blurb, Integer.parseInt(t.price), t.length, t.bullets, t.keywords, t.packageType, Difficulty.valueOf(t.difficulty), Region.valueOf(t.region)));
		System.out.println("==========================After reading from JSON============================");
		tourService.lookup().forEach(tourService->System.out.println(tourService.getTitle()+" Package "+tourService.getTourPackage()));
		System.out.println("Number of tours "+tourService.total());
	}
	
	static class TourFromFile{
		public String keywords;
		private String packageType,title,description,blurb,price,length,bullets,
		keyword,difficulty,region;
		
		static List<TourFromFile> importTours()throws IOException{
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD,
					JsonAutoDetect.Visibility.ANY).
					readValue(TourFromFile.class.
							getResourceAsStream("/ExploreCalifornia.json"),
							new TypeReference<List<TourFromFile>>() {});
		}
	}

}

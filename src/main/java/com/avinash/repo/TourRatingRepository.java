package com.avinash.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.avinash.domain.TourRating;
import com.avinash.domain.TourRatingPK;

@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPK> {

    /**
     * Lookup all the TourRatings for a tour.
     *
     * @param tourId is the tour Identifier
     * @return a List of any found TourRatings
     */
    List<TourRating> findByPkTourId(Integer tourId);

    /**
     * Lookup a page of TourRatings for a tour.
     *
     * @param tourId tourId is the tour Identifier
     * @param pageable details for the desired page
     * @return a Page of any found TourRatings
     */
    Page<TourRating> findByPkTourId(Integer tourId, Pageable pageable);

    /**
     * Lookup a TourRating by the TourId and Customer Id
     * @param tourId
     * @param customerId
     * @return TourRating if found, null otherwise.
     */
    TourRating findByPkTourIdAndPkCustomerId(Integer tourId, Integer customerId);
}
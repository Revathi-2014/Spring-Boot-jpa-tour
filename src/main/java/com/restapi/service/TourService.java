package com.restapi.service;

import com.restapi.dto.TourDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Itinerary;
import com.restapi.model.Tour;
import com.restapi.model.TourCategory;
import com.restapi.repository.CategoryRepository;
import com.restapi.repository.ItineraryRepository;
import com.restapi.repository.TourRepository;
import com.restapi.request.TourRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TourService {
    @Autowired
    private TourDto tourDto;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private ItineraryRepository itineraryRepository;

    public List<Tour> findAll(){
        return tourRepository.findAll();
    }

    @Transactional
    public List<Tour> createTour(TourRequest tourRequest){
        Tour tour = tourDto.mapToTour(tourRequest);
        TourCategory category = categoryRepository.findById(tourRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                        "CategoryId", tourRequest.getCategoryId()));
        tour.setCategory(category);
        tour=tourRepository.save(tour);
        System.out.println(tour.getId());
        for (Itinerary itinerary: tourRequest.getItineraries()){
            itinerary.setTour(tour);
            itineraryRepository.save(itinerary);
        }
        return findAll();
    }

    @Transactional
    public List<Tour> updateTour(TourRequest tourRequest){
        Tour tour = tourDto.mapToTour(tourRequest);
        TourCategory category = categoryRepository.findById(tourRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                        "CategoryId", tourRequest.getCategoryId()));
        tour.setCategory(category);
        tourRepository.save(tour);
        for (Itinerary itinerary: tourRequest.getItineraries()){
            itinerary.setTour(tour);
            itineraryRepository.save(itinerary);
        }
        return findAll();
    }

    public List<Tour> deleteById(Integer id){
        tourRepository.deleteById(Long.valueOf(id));
        return findAll();
    }
}

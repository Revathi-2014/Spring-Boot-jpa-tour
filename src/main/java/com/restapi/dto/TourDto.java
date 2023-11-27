package com.restapi.dto;

import com.restapi.model.Tour;
import com.restapi.model.TourCategory;
import com.restapi.request.TourRequest;
import com.restapi.response.TourResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TourDto {

    public Tour mapToTour(TourRequest tourRequest){
        Tour tour = new Tour();
        if (tourRequest.getId() != null) {
            tour.setId(tourRequest.getId());
        }
        tour.setTourName(tourRequest.getTourName());
        tour.setTourPhoto(tourRequest.getTourPhoto());
        tour.setDays(tourRequest.getDays());
        tour.setTourDescription(tourRequest.getTourDescription());
        tour.setTotalSeats(tourRequest.getTotalSeats());
        tour.setDestination(tourRequest.getCategory());
        tour.setPrice(tourRequest.getPrice());
        tour.setDepartureDate(tourRequest.getDepartureDate());
        tour.setItineraries(tourRequest.getItineraries());
        return tour;
    }

    public List<TourResponse> mapToTourResponse(List<Tour> tourList){
        List<TourResponse> tourResponseList = new ArrayList<>();
        for (Tour tour : tourList) {
            System.out.println(tour.getTourName());
            TourResponse tourResponse = new TourResponse();
            tourResponse.setId(tour.getId());
            tourResponse.setTourName(tour.getTourName());
            tourResponse.setTourPhoto(tour.getTourPhoto());
            tourResponse.setCategory(tour.getDestination());
            tourResponse.setPrice(tour.getPrice());
            tourResponse.setCategoryId(tour.getCategory().getId());
            tourResponse.setDays(tour.getDays());
            tourResponse.setDepartureDate(tour.getDepartureDate());
            tourResponse.setTotalSeats(tour.getTotalSeats());
            tourResponse.setItineraryList(tour.getItineraries());
            tourResponseList.add(tourResponse);

        }

        return tourResponseList;
    }

    public TourResponse mapToTourId(Tour tour){
        TourResponse tourResponse = new TourResponse();
        if (tour.getId() != null) {
            tourResponse.setId(tour.getId());
        }
        tourResponse.setTourName(tour.getTourName());
        tourResponse.setCategory(tour.getDestination());
        tourResponse.setPrice(tour.getPrice());
        tourResponse.setTourPhoto(tour.getTourPhoto());
        tourResponse.setTourDescription(tour.getTourDescription());
        tourResponse.setDays(tour.getDays());
        tourResponse.setDepartureDate(tour.getDepartureDate());
        tourResponse.setTotalSeats(tour.getTotalSeats());
        tourResponse.setItineraryList(tour.getItineraries());
        return tourResponse;
    }
}

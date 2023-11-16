package com.restapi.dto;

import com.restapi.model.Itinerary;
import com.restapi.model.Tour;
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
        tour.setTotalSeats(tourRequest.getTotalSeats());
        tour.setBalanceSeats(tourRequest.getBalanceSeats());
        tour.setDestination(tourRequest.getDestination());
//        tour.setDepartureDate(tourRequest.getDepartureDate());
        tour.setDepartureLocation(tourRequest.getDepartureLocation());
        tour.setItineraries(tourRequest.getItineraries());
        return tour;
    }
}

package com.restapi.dto;

import com.restapi.model.Itinerary;
import com.restapi.request.CategoryRequest;
import com.restapi.request.ItineraryRequest;
import com.restapi.response.ItineraryResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItineraryDto {
    public ItineraryResponse mapToItineraryResponse(List<Itinerary> itineraryList){
        ItineraryResponse itineraryResponse= new ItineraryResponse();
        ArrayList<ItineraryRequest> itineraryRequests = new ArrayList<>();
        for(Itinerary itinerary:itineraryList){
            itineraryRequests.add(new ItineraryRequest(itinerary.getId(),itinerary.getMorning(),
                    itinerary.getBreakfast(),itinerary.getAfternoon(),itinerary.getLunch(),
                    itinerary.getNight(), itinerary.getDinner(),itinerary.getHotel(),itinerary.getDay()));
        }
        itineraryResponse.setItineraryList(itineraryRequests);
        return itineraryResponse;
    }

}

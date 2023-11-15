package com.restapi.response;

import com.restapi.model.Itinerary;
import com.restapi.request.ItineraryRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItineraryResponse {
    private List<ItineraryRequest> itineraryList;
}

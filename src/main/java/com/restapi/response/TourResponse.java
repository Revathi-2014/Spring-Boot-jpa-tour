package com.restapi.response;

import com.restapi.model.Itinerary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TourResponse {
    private Long id;
    private String tourName;
    private byte[] tourPhoto;
    private String category;
    private Long categoryId;
    private Long price;
    private String tourDescription;
    private Integer days;
    private Integer totalSeats;
    private LocalDate departureDate;
    private List<Itinerary> itineraryList;

    public TourResponse(){

    }
}

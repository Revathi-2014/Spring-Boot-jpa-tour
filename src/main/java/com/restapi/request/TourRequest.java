package com.restapi.request;

import com.restapi.model.Itinerary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourRequest {
    @NotEmpty
    private Long id;

    @NotEmpty
    private Long categoryId;

    @NotEmpty
    @Size(min = 2, message = "Tour Name should have at least 2 characters")
    private String tourName;

    @NotEmpty
    private byte[] tourPhoto;


    private String destination;


    private Integer totalSeats;


    private Integer balanceSeats;


    private String departureLocation;

//    @NotEmpty
//    private LocalDate departureDate;
    
    private Integer days;

    @NotEmpty
    private List<Itinerary> itineraries = new ArrayList<>();
}

package com.restapi.request;

import com.restapi.model.Itinerary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TourRequest {

    private Long id;
    private Long categoryId;
    @NotEmpty
    @Size(min = 2, message = "Tour Name should have at least 2 characters")
    private String tourName;
    private String tourDescription;
    private byte[] tourPhoto;
    private Long price;
    private String category;
    private Integer totalSeats;
    private LocalDate departureDate;
    private Integer days;
    private List<Itinerary> itineraries = new ArrayList<>();
}

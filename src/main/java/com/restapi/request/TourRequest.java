package com.restapi.request;

import com.restapi.model.Itinerary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
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
    private String tourName;

    @NotEmpty
    private byte[] tourPhoto;

    @NotEmpty
    private String destination;

    @NotEmpty
    private Integer totalSeats;

    @NotEmpty
    private Integer balanceSeats;

    @NotEmpty
    private String departureLocation;

//    @NotEmpty
//    private LocalDate departureDate;

    @NotEmpty
    private Integer days;

    @NotEmpty
    private List<Itinerary> itineraries = new ArrayList<>();
}

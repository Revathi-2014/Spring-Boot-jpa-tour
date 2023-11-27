package com.restapi.response;

import com.restapi.model.Itinerary;
import com.restapi.model.Tour;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@ToString
public class BookingResponse {
    private Long id;
    private String tour;
    private Integer days;
    private Long userId;
    private LocalDate departureDate;
    private String name;
    private String username;
    private Long phoneNumber;
    private String bookingStatus;
    private Long price;
    private LocalDateTime createdAt;

}

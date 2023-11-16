package com.restapi.response;

import com.restapi.model.Tour;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class BookingResponse {
    private Long id;
    private String tour;
    private Long userId;
    private String name;
    private String username;
    private Long phoneNumber;
    private String bookingStatus;
}

package com.restapi.dto;

import com.restapi.model.Booking;
import com.restapi.response.BookingResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class BookingDto {
    public List<BookingResponse> mapToBookingResponse(List<Booking> bookingList){
        List<BookingResponse> bookingResponseList = new ArrayList<>();

        for (Booking booking : bookingList) {
            BookingResponse bookingResponse = new BookingResponse();
            bookingResponse.setId(booking.getId());
            bookingResponse.setUserId(booking.getAppUser().getId());
            bookingResponse.setName(booking.getAppUser().getName());
            bookingResponse.setDays(booking.getTour().getDays());
            bookingResponse.setDepartureDate(booking.getTour().getDepartureDate());
            bookingResponse.setUsername(booking.getAppUser().getUsername());
            bookingResponse.setPrice(booking.getTour().getPrice());
            bookingResponse.setBookingStatus(booking.getBookingStatus().getStatus());
            bookingResponse.setPhoneNumber(booking.getAppUser().getPhoneNumber());
            bookingResponse.setTour(booking.getTour().getTourName());
            bookingResponse.setCreatedAt(booking.getCreatedAt());
            bookingResponseList.add(bookingResponse);
        }
        return bookingResponseList;
    }
}

package com.restapi.service;

import com.restapi.dto.BookingDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.AppUser;
import com.restapi.model.Booking;
import com.restapi.model.BookingStatus;
import com.restapi.model.Tour;
import com.restapi.repository.BookingRepository;
import com.restapi.repository.BookingStatusRepository;
import com.restapi.repository.TourRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.BookingRequest;
import com.restapi.response.BookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingDto bookingDto;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingStatusRepository bookingStatusRepository;

    @Autowired
    private TourRepository tourRepository;



    public List<BookingResponse> bookTour(BookingRequest bookingRequest){
        AppUser appUser = userRepository.findById(bookingRequest.getUser_id())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId", bookingRequest.getUser_id()));

       Tour tour = tourRepository.findById(bookingRequest.getTour_id())
                .orElseThrow(() ->
                        new ResourceNotFoundException("addressId", "addressId", bookingRequest.getTour_id()));

        BookingStatus bookingStatus = bookingStatusRepository.findById(1L)
                .orElseThrow(() ->
                        new ResourceNotFoundException("orderStatusId", "orderStatusId", 1));



        Booking booking=new Booking();
        booking.setAppUser(appUser);
        booking.setTour(tour);
        booking.setBookingStatus(bookingStatus);
        booking.setCount(bookingRequest.getCount());

        bookingRepository.save(booking);

        return getUsersBooking(bookingRequest.getUser_id());
    }

    public List<BookingResponse> getUsersBooking(Long userId){
        List<Booking> bookingList = bookingRepository.findUserBooking(userId)
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId", userId));
        return bookingDto.mapToBookingResponse(bookingList);
    }
}

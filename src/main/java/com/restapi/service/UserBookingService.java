package com.restapi.service;

import com.restapi.dto.UserDetailsDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.AppUser;
import com.restapi.model.UserDetails;
import com.restapi.repository.BookingRepository;
import com.restapi.repository.UserBookingRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.UserBookingRequest;
import com.restapi.response.UserBookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserBookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserBookingRepository userBookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsDto userDetailsDto;

    public UserBookingResponse findAll() {
        List<UserDetails> userDetailsList = userBookingRepository.findAll();
        return userDetailsDto.mapToUserDetailsResponse(userDetailsList);
    }

    @Transactional
    public UserBookingResponse create(UserBookingRequest userBookingRequest){
        UserDetails userDetails = userDetailsDto.mapToUserDetails(userBookingRequest);
        AppUser appUser = userRepository.findById(userBookingRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId",
                        userBookingRequest.getUserId()));
        userDetails.setAppUser(appUser);
        userBookingRepository.save(userDetails);
        return findAll();
    }

    public UserBookingResponse update(UserBookingRequest userBookingRequest){
        UserDetails userDetails = userDetailsDto.mapToUserDetails(userBookingRequest);
        AppUser appUser = userRepository.findById(userBookingRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId",
                        userBookingRequest.getUserId()));
        userDetails.setAppUser(appUser);
        userBookingRepository.save(userDetails);
        return findAll();
    }

    public UserBookingResponse deleteById(Long id){
        userBookingRepository.deleteById(id);
        return findAll();
    }
}

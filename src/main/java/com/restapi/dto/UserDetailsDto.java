package com.restapi.dto;

import com.restapi.model.UserDetails;
import com.restapi.request.UserBookingRequest;
import com.restapi.response.UserBookingResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDetailsDto {
    public UserBookingResponse mapToUserDetailsResponse(List<UserDetails> userDetailsList){
        return new UserBookingResponse(userDetailsList);
    }

    public UserDetails mapToUserDetails(UserBookingRequest userBookingRequest){
        UserDetails userDetails = new UserDetails();
        if (userBookingRequest.getId() != null) {
            userDetails.setId(userBookingRequest.getId());
        }
        userDetails.setUserName(userBookingRequest.getUserName());
        userDetails.setPhoneNumber(userBookingRequest.getPhoneNumber());
        userDetails.setEmail(userBookingRequest.getEmail());
//        userDetails.setCount(userDetailsRequest.getCount());
        userDetails.setDate(userBookingRequest.getDate());
        return userDetails;
    }
}

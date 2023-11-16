package com.restapi.controller;

import com.restapi.model.AppUser;
import com.restapi.model.Role;
import com.restapi.request.UserBookingRequest;
import com.restapi.response.UserBookingResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.UserBookingService;
import com.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@RolesAllowed(Role.USER)
public class UserController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private UserService userService;

    @Autowired
    private UserBookingService userBookingService;

    @GetMapping("/{userId}")
    public ResponseEntity<APIResponse> getUserDetails(@PathVariable Integer userId) {
        AppUser appUser = userService.findUserById(Long.valueOf(userId));
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(appUser);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("/userDetails")
    public ResponseEntity<APIResponse> createUserDetail(@Valid  @RequestBody
                                                        UserBookingRequest userBookingRequest) {
        UserBookingResponse userBookingResponse = userBookingService.create(userBookingRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(userBookingResponse.getUserDetailsList());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PutMapping("/userDetails")
    public ResponseEntity<APIResponse> updateUserDetail(@Valid @RequestBody
                                                        UserBookingRequest userBookingRequest) {
        UserBookingResponse userBookingResponse = userBookingService.update(userBookingRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(userBookingResponse.getUserDetailsList());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/userDetails/{id}")
    public ResponseEntity<APIResponse> deleteUserDetail(@PathVariable Integer id) {
        UserBookingResponse userBookingResponse = userBookingService
                .deleteById(Long.valueOf(id));
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(userBookingResponse.getUserDetailsList());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}

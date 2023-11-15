package com.restapi.controller;

import com.restapi.model.Role;
import com.restapi.request.HistoryRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/history")
@RolesAllowed(Role.USER)
public class BookingController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/{userId}")
    public ResponseEntity<APIResponse> getUsersHistory(@PathVariable Long userId) {
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookingService.findUserHistory(userId));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse> bookTour(@RequestBody HistoryRequest historyRequest) {
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookingService.bookTour(historyRequest));
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}

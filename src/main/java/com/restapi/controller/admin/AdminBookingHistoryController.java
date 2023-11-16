package com.restapi.controller.admin;

import com.restapi.model.BookingStatus;
import com.restapi.model.Role;
import com.restapi.request.BookingStatusRequest;
import com.restapi.response.BookingResponse;
import com.restapi.response.CategoryResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/admin/history")
@RolesAllowed(Role.ADMIN)
public class AdminBookingHistoryController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/{userId}")
    public ResponseEntity<APIResponse> getUserBooking(@PathVariable Long userId) {
        List<BookingResponse> bookingResponseList=bookingService.getUsersBooking(userId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookingResponseList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllOrders() {
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookingService.getAllBookings());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/status/all")
    public ResponseEntity<APIResponse> getAllStatus() {
        List<BookingStatus> bookingStatusList = bookingService.getAllBookingStatus();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookingStatusList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @PutMapping("/status")
    public ResponseEntity<APIResponse> updateBookingStatus(
            @RequestBody BookingStatusRequest bookingStatusRequest) {
        List<BookingResponse> bookingResponseList = bookingService
                .updateBookingStatus(bookingStatusRequest.getBookingId(),
                        bookingStatusRequest.getStatusId());
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookingResponseList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}

package com.restapi.controller;

import com.restapi.model.Role;
import com.restapi.model.Tour;
import com.restapi.response.common.APIResponse;
import com.restapi.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/tour")
@RolesAllowed(Role.USER)
public class TourController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private TourService tourService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllBooks() {
        List<Tour> tourList = tourService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(tourList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}

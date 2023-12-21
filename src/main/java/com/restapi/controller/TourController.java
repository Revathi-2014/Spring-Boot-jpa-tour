package com.restapi.controller;

import com.restapi.model.Role;
import com.restapi.model.Tour;
import com.restapi.response.CategoryResponse;
import com.restapi.response.TourResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<APIResponse> getAllTours(){
        List<TourResponse> tourList =  tourService.findAllTour();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(tourList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<APIResponse> getTourByCategoryId(@PathVariable Long categoryId){
        List<TourResponse> tourResponseList = tourService.getTourByCategoryId(categoryId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(tourResponseList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @GetMapping("/{tourId}")
    public ResponseEntity<APIResponse> getTourByTourId(@PathVariable Long tourId){
        TourResponse tourResponse = tourService.getTourByTourId(tourId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(tourResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}

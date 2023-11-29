package com.restapi.controller.admin;

import com.restapi.model.Role;
import com.restapi.model.Tour;
import com.restapi.request.TourRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.StorageService;
import com.restapi.service.TourService;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin/tour")
@RolesAllowed(Role.ADMIN)
public class AdminTourController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private TourService tourService;

    @Autowired
    private StorageService storageService;
    private String file;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllTour(){
        List<Tour> tourList = tourService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(tourList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    //    @PostMapping
//    public ResponseEntity<APIResponse> createTour(@Valid @RequestBody
//                                                  TourRequest tourRequest) {
//        List<Tour> tourList = tourService.createTour(tourRequest);
//        apiResponse.setStatus(HttpStatus.OK.value());
//        apiResponse.setData(tourList);
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<APIResponse> createTour(@RequestParam("itineraries") String itineraries,
                                                  @RequestParam("departureDate") String departureDate,
                                                  @RequestParam("id") Long id,
                                                  @RequestParam("price") Long price,
                                                  @RequestParam("tourDescription") String tourDescription,
                                                  @RequestParam("destination") String destination,
                                                  @RequestParam("tourName") String tourName,
                                                  @RequestParam("totalSeats") Integer totalSeats,
                                                  @RequestParam("categoryId") Long categoryId,
                                                  @RequestParam("days") Integer days,
                                                  @RequestParam("tourPhoto") MultipartFile tourPhoto
    ) throws IOException, ParseException, org.json.simple.parser.ParseException{

        String file = storageService.storeFile(tourPhoto);
        TourRequest tourRequest = new TourRequest();
        tourRequest.setId(id);
        System.out.println(id);
        tourRequest.setTourDescription(tourDescription);
        System.out.println(tourDescription);
        tourRequest.setTourName(tourName);
        System.out.println(tourName);
        tourRequest.setTourPhoto(file);
        System.out.println(file);
        tourRequest.setDays(days);
        System.out.println(days);
        tourRequest.setCategoryId(categoryId);
        System.out.println(categoryId);
        tourRequest.setDestination(destination);
        System.out.println(destination);
        tourRequest.setDepartureDate(departureDate);
        System.out.println(departureDate);
        tourRequest.setTotalSeats(totalSeats);
        System.out.println(totalSeats);
        tourRequest.setItineraries(itineraries);
        System.out.println(itineraries);
        tourRequest.setPrice(price);
        System.out.println(price);


        List<Tour> tourList = tourService.createTour(tourRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(tourList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
//
//    @PutMapping
//    public ResponseEntity<APIResponse> updateTour(@Valid @RequestBody
//                                                  TourRequest tourRequest){
//        List<Tour> tourList = tourService.updateTour(tourRequest);
//        apiResponse.setStatus(HttpStatus.OK.value());
//        apiResponse.setData(tourList);
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteTour(@PathVariable Integer id){
        List<Tour> tourList = tourService.deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(tourList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id) throws IOException{

        File file = tourService.getFile(id);

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}

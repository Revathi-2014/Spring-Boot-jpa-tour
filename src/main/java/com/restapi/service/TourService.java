package com.restapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.dto.TourDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Itinerary;
import com.restapi.model.Tour;
import com.restapi.model.TourCategory;
import com.restapi.repository.CategoryRepository;
import com.restapi.repository.ItineraryRepository;
import com.restapi.repository.TourRepository;
import com.restapi.request.TourRequest;
import com.restapi.response.TourResponse;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TourService {
    @Autowired
    private TourDto tourDto;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private ItineraryRepository itineraryRepository;

    @Autowired
    private StorageService storageService;

    public List<Tour> findAll(){
        return tourRepository.findAll();
    }

    @Transactional
    public List<Tour> createTour(TourRequest tourRequest) throws ParseException, JsonProcessingException{
        Tour tour = tourDto.mapToTour(tourRequest);
        TourCategory category = categoryRepository.findById(tourRequest.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
                        "CategoryId", tourRequest.getCategoryId()));
        tour.setCategory(category);
        tour = tourRepository.save(tour);
        String jsonString = tourRequest.getItineraries();
        Object jsonObject = JSONValue.parse(jsonString);
        System.out.println(jsonObject);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);
        List<Itinerary> itineraryList = new ArrayList<>();

        if (jsonNode.isArray()) {
//            JsonNode itinerariesNode = jsonNode.get("itineraries");
            for (JsonNode itineraryNode : jsonNode) {
                Itinerary itinerary = new Itinerary();
                itinerary.setTour(tour);
                itinerary.setAfternoon(itineraryNode.get("afternoon").toString());
                itinerary.setDay(itineraryNode.get("day").toString());
                itinerary.setBreakfast(itineraryNode.get("breakfast").asBoolean());
                itinerary.setHotel(itineraryNode.get("hotel").toString());
                itinerary.setLunch(itineraryNode.get("lunch").asBoolean());
                itinerary.setDinner(itineraryNode.get("dinner").asBoolean());
                itinerary.setMorning(itineraryNode.get("morning").toString());
                itinerary.setNight(itineraryNode.get("night").toString());
                itineraryList.add(itinerary);

            }
        }
        itineraryRepository.saveAll(itineraryList);
        return findAll();
    }

//    @Transactional
//    public List<Tour> updateTour(TourRequest tourRequest){
//        Tour tour = tourDto.mapToTour(tourRequest);
//        TourCategory category = categoryRepository.findById(tourRequest.getCategoryId())
//                .orElseThrow(() -> new ResourceNotFoundException("CategoryId",
//                        "CategoryId", tourRequest.getCategoryId()));
//        tour.setCategory(category);
//        tourRepository.save(tour);
//        for (Itinerary itinerary: tourRequest.getItineraries()){
//            itinerary.setTour(tour);
//            itineraryRepository.save(itinerary);
//        }
//        return findAll();
//    }

    public List<Tour> deleteById(Integer id){
        tourRepository.deleteById(Long.valueOf(id));
        return findAll();
    }


    public List<TourResponse> getTourByCategoryId(Long categoryId){

        List<Tour> tourList = tourRepository.findByCategoryId(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("categoryId", "categoryId", categoryId));
        return tourDto.mapToTourResponse(tourList);

    }

    public TourResponse getTourByTourId(Long id){
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("tourId", "tourId", id));
        return tourDto.mapToTourId(tour);
    }


    public List<TourResponse> findAllTour(){
        List<Tour> tourList = tourRepository.findAll();
        return tourDto.mapToTourResponse(tourList);
    }

    public File getFile(Long id){
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id", "id", id));

        Resource resource = storageService.loadFileAsResource(tour.getTourPhoto());

        try {
            return resource.getFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

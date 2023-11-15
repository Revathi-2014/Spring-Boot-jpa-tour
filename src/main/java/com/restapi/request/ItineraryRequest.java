package com.restapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ItineraryRequest {
    private Long id;

    private String day;

    private String morning;
    private Boolean breakfast;

    private String afternoon;
    private Boolean lunch;

    private String night;
    private Boolean dinner;

    private String hotel;


    public ItineraryRequest(Long id, String morning, Boolean breakfast, String afternoon, Boolean lunch, String night, Boolean dinner, String hotel, String day){

    }
}

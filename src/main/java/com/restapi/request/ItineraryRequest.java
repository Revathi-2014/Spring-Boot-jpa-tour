package com.restapi.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItineraryRequest {
    @NotEmpty
    private Long id;

    @NotEmpty
    private String day;
    @NotEmpty
    private String morning;
    @NotEmpty
    private Boolean breakfast;

    @NotEmpty
    private String afternoon;
    @NotEmpty
    private Boolean lunch;
    @NotEmpty
    private String night;
    @NotEmpty
    private Boolean dinner;
    @NotEmpty
    private String hotel;


    public ItineraryRequest(Long id, String morning, Boolean breakfast, String afternoon, Boolean lunch, String night, Boolean dinner, String hotel, String day){

    }
}

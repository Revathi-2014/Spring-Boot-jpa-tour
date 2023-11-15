package com.restapi.response;

import com.restapi.model.Tour;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TourResponse {
    private List<Tour> tourList;
}

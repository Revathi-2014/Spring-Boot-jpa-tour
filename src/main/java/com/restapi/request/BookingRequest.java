package com.restapi.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingRequest {

    private Long user_id;
    private Long tour_id;
    private Integer count;

}

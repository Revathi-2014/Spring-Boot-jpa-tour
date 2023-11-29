package com.restapi.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingRequest {

    @NotEmpty
    private Long user_id;
    @NotEmpty
    private Long tour_id;
    @NotEmpty
    private Integer count;


}

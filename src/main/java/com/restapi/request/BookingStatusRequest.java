package com.restapi.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingStatusRequest {
    @NotEmpty
    private Long bookingId;
    @NotEmpty
    private Long statusId;
}

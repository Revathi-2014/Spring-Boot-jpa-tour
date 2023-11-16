package com.restapi.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingStatusRequest {
    private Long bookingId;
    private Long statusId;
}

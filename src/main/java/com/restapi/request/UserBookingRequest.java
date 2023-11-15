package com.restapi.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserBookingRequest {
    private Long id;

    private Long userId;

    private String userName;

    private Long phoneNumber;

    private String email;

    private Date date;

    private Integer count;
}

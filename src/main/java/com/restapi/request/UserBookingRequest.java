package com.restapi.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
public class UserBookingRequest {
    @NotEmpty
    private Long id;
    @NotEmpty
    private Long userId;
    @NotEmpty
    private String userName;
    @NotEmpty
    private Long phoneNumber;
    @NotEmpty
    private String email;
    @NotEmpty
    private Date date;
    @NotEmpty
    private Integer count;
}

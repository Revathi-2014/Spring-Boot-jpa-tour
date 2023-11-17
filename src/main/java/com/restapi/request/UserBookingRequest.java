package com.restapi.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class UserBookingRequest {
    @NotEmpty
    private Long id;
    @NotEmpty
    private Long userId;
    @NotEmpty
    @Size(min = 2, message = "Username should have at least 2 characters")
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

package com.restapi.response;

import com.restapi.request.RegisterRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RegisterResponse {
    List<RegisterRequest> registerRequestList;
}

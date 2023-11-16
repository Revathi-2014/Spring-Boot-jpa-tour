package com.restapi.controller.admin;

import com.restapi.model.Role;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/admin/history ")
@RolesAllowed(Role.ADMIN)
public class AdminBookingHistoryController {
}

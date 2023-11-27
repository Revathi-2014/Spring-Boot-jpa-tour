package com.restapi.controller;

import com.restapi.model.Role;
import com.restapi.model.TourCategory;
import com.restapi.response.CategoryResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@RolesAllowed(Role.USER)
public class TourCategoryController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllCategory() {
        CategoryResponse categoryResponse =  categoryService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(categoryResponse);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}

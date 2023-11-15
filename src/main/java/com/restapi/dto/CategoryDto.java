package com.restapi.dto;

import com.restapi.model.TourCategory;
import com.restapi.request.CategoryRequest;
import com.restapi.response.CategoryResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDto {
    public CategoryResponse mapToCategoryResponse(List<TourCategory> categories){
        CategoryResponse categoryResponse = new CategoryResponse();

        ArrayList<CategoryRequest> categoryRequests = new ArrayList<>();
        for (TourCategory category : categories) {
            categoryRequests.add(new CategoryRequest(category.getId(), category.getCategoryName(),category.getCategoryPhoto()));
        }

        categoryResponse.setCategories(categoryRequests);
        return categoryResponse;
    }

    public TourCategory mapToCategory(CategoryRequest categoryRequest){
        TourCategory category = new TourCategory();
        if (categoryRequest.getId() != null) {
            category.setId(categoryRequest.getId());
        }
        category.setCategoryName(categoryRequest.getCategoryName());
        category.setCategoryPhoto(categoryRequest.getCategoryPhoto());
        return category;
    }
}

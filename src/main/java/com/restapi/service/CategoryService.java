package com.restapi.service;

import com.restapi.dto.CategoryDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.TourCategory;
import com.restapi.repository.CategoryRepository;
import com.restapi.request.CategoryRequest;
import com.restapi.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryDto categoryDto;

    @Autowired
    private StorageService storageService;

    public CategoryResponse findAll() {
        List<TourCategory> categories = categoryRepository.findAll();
        return categoryDto.mapToCategoryResponse(categories);
    }

    public CategoryResponse create(CategoryRequest categoryRequest){
        TourCategory category = categoryDto.mapToCategory(categoryRequest);
        categoryRepository.save(category);
        return findAll();
    }

    public CategoryResponse update(CategoryRequest categoryRequest){
        TourCategory category = categoryDto.mapToCategory(categoryRequest);
        categoryRepository.save(category);
        return findAll();
    }

    public CategoryResponse deleteById(Integer id){
        categoryRepository.deleteById(Long.valueOf(id));
        return findAll();
    }

    public File getFile(Long id) throws IOException{
        TourCategory tourCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id", "id", id));

        Resource resource = storageService.loadFileAsResource(tourCategory.getCategoryPhoto());

        return resource.getFile();
    }
}

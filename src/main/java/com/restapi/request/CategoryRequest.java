package com.restapi.request;

import com.restapi.model.Tour;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryRequest {


    private Long id;

    @NotEmpty
    @Size(min = 2, message = "Category should have at least 2 characters")
    private String categoryName;


    private byte[] categoryPhoto;

}


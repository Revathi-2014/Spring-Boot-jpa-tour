package com.restapi.request;

import com.restapi.model.Tour;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryRequest {

    @NotEmpty
    private Long id;

    @NotEmpty
    private String categoryName;

    @NotEmpty
    private byte[] categoryPhoto;

}


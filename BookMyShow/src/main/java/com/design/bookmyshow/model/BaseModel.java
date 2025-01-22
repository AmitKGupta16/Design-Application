package com.design.bookmyshow.model;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
    @Id
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}


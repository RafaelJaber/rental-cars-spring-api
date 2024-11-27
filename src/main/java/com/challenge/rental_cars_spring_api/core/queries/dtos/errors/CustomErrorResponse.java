package com.challenge.rental_cars_spring_api.core.queries.dtos.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorResponse {

    private LocalDateTime timestamp;
    private Integer httpStatus;
    private String httpError;
    private String error;
    private String path;
}

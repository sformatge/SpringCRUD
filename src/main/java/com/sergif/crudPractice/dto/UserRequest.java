package com.sergif.crudPractice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRequest {

    private String name;
    private Integer age;
}

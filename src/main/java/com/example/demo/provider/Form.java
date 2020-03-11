package com.example.demo.provider;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class Form {
    @NotBlank(message = "Must have at least one item in list")
    @Pattern(regexp = "^(-?\\d+(,-?\\d+)*)?$", message = "Must be in valid format, eg: '1,2,3'")
    private String list;

    @NotBlank(message = "Must have one non-blank integer")
    @Pattern(regexp = "^-?\\d+$", message = "Must be a valid integer")
    private String total;
}
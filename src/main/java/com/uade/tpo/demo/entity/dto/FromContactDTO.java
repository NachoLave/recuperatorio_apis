package com.uade.tpo.demo.entity.dto;

import java.util.List;

import lombok.Data;
@Data
public class FromContactDTO{
    private String name;
    private String problem;
    private List<String> photos;
    private String description;
}
package com.uade.tpo.demo.entity.dto;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class FromContactDTO{
    private String name;
    private String problem;
    private List<MultipartFile> photos = new LinkedList<>();
    private String description;
}
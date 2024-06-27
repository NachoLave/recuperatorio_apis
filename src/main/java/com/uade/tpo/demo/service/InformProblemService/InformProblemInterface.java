package com.uade.tpo.demo.service.InformProblemService;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.uade.tpo.demo.entity.dto.InformProblemDTO;

public interface InformProblemInterface {
    void guardarinforme(InformProblemDTO informProblemDTO,List<MultipartFile> imagenes);
}


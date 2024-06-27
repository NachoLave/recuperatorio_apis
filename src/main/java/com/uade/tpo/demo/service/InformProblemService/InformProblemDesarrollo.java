package com.uade.tpo.demo.service.InformProblemService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.uade.tpo.demo.entity.InformProblemEntity;
import com.uade.tpo.demo.entity.dto.InformProblemDTO;
import com.uade.tpo.demo.repository.cloudinary.CloudinaryRepository;
import com.uade.tpo.demo.repository.db.InformProblemRepository;




@Service
public class InformProblemDesarrollo implements InformProblemInterface{
    @Autowired
    private InformProblemRepository informProblemRepository;
    @Autowired
    private CloudinaryRepository repository;
    @Override
    public void guardarinforme(InformProblemDTO informProblemDTO, List<MultipartFile> imagenes) {
        List<String> photourl = imagenes.stream()
                .map(img -> repository.savePhoto(img.getName(), img))
                .toList();

        InformProblemEntity informproblem = new InformProblemEntity();
        informproblem.setNombreApellido(informProblemDTO.getNombreApellido());
        informproblem.setProblematica(informProblemDTO.getProblematica());
        informproblem.setFotos(photourl);
        informproblem.setDescripcionProblema(informProblemDTO.getDescripcionProblema());

        informProblemRepository.save(informproblem);
    }
    


    
}
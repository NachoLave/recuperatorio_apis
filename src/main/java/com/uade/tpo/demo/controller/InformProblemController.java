package com.uade.tpo.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;


import com.uade.tpo.demo.entity.dto.InformProblemDTO;
import com.uade.tpo.demo.service.InformProblemService.InformProblemInterface;


@RestController
@RequestMapping("/informar_problema")
public class InformProblemController {
    private final InformProblemInterface informProblemService;

    @Autowired
    public InformProblemController(InformProblemInterface informContactService){
        this.informProblemService = informContactService;
    }

    @PostMapping(value = "/submit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> guardarInforme(@RequestPart("Imagenes") List<MultipartFile> Imagenes,
                                                @RequestPart String NombreYApellido,
                                                @RequestPart String Problema,
                                                @RequestPart String Description) {

        InformProblemDTO informe = InformProblemDTO.builder()
                .nombreApellido(NombreYApellido)
                .problematica(Problema)
                .descripcionProblema(Description)
                .build();

        try {

            //for(MultipartFile foto: fotos){
            //  String url = GuardarFoto(foto);

            //informProblemDTO.getFotos().add(url);}
            informProblemService.guardarinforme(informe, Imagenes);
            return ResponseEntity.ok("Informe registrado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }   
}

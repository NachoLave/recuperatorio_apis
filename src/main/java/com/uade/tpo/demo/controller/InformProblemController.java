package com.uade.tpo.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import com.uade.tpo.demo.entity.dto.InformProblemDTO;
import com.uade.tpo.demo.service.InformProblemService.InformProblemInterface;


@RestController
@RequestMapping("/informar_problema")
public class InformProblemController {
    private final InformProblemInterface InformProblemService;

    @Autowired
    public InformProblemController(InformProblemInterface informContactService){
        this.InformProblemService = informContactService;
    }

    @PostMapping(value="/Informe_de_problema",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    
public ResponseEntity<String> guardarInforme(@ModelAttribute InformProblemDTO informProblemDTO,  @RequestPart("fotos") ArrayList<MultipartFile> fotos) {
    
        try{

            //for(MultipartFile foto: fotos){
              //  String url = GuardarFoto(foto);
                
                //informProblemDTO.getFotos().add(url);}
            InformProblemService.guardarContacto(informProblemDTO);
            return ResponseEntity.ok("Informe registrado exitosamente");
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }


        
        
    }
    
    private String GuardarFoto(MultipartFile foto){
        String NombreArchivo = foto.getOriginalFilename();
        String path = System.getProperty("user.home") + "/imagenes/" + NombreArchivo;
        try{
            foto.transferTo(new File(path));
            return path;
        }catch(IOException e){
            e.printStackTrace();
            return null;

        }
    }
    
}

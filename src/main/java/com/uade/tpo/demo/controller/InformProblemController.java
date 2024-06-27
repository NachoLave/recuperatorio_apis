package com.uade.tpo.demo.controller;

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

    @PostMapping(value = "/Informe_de_problema", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> guardarInforme(@RequestPart("images") List<MultipartFile> imagenes,
                                                @RequestPart String name,
                                                @RequestPart String problem,
                                                @RequestPart String description) {

        InformProblemDTO pepe = InformProblemDTO.builder()
                .nombreApellido(name)
                .descripcionProblema(description)
                .problematica(problem).build();

        try {

            //for(MultipartFile foto: fotos){
            //  String url = GuardarFoto(foto);

            //informProblemDTO.getFotos().add(url);}
            informProblemService.guardarContacto(pepe, imagenes);
            return ResponseEntity.ok("Informe registrado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }   
}

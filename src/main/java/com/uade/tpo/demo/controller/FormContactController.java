package com.uade.tpo.demo.controller;

import java.net.URI;
import java.util.HashMap;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uade.tpo.demo.entity.FormContactEntity;
import com.uade.tpo.demo.entity.ProductoEntity;
import com.uade.tpo.demo.entity.dto.FromContactDTO;
import com.uade.tpo.demo.entity.dto.ProductDTO;
import com.uade.tpo.demo.service.contactFormService.IContactFormService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RestController
public class FormContactController {
    
    @Autowired
    private IContactFormService contactFormService;

    @PostMapping("/Submit")
    public ResponseEntity submit (@RequestBody HashMap<String,String> formContactDTO) throws Exception {
        log.info(formContactDTO.toString());
        //FormContactEntity result = contactFormService.saveContactForm(formContactDTO);
        
        //return ResponseEntity.ok(result);
        return ResponseEntity.ok(formContactDTO);
    }
}

package com.uade.tpo.demo.service.contactFormService;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.uade.tpo.demo.entity.FormContactEntity;
import com.uade.tpo.demo.entity.dto.FromContactDTO;
import com.uade.tpo.demo.repository.db.IContactForm;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class ContactFormService implements IContactFormService{
     @Autowired
    private IContactForm contactFormRepository;

    @Override
    public FormContactEntity saveContactForm( FromContactDTO contactForm) {
        List<String> photosUrl = null;
        if (!contactForm.getPhotos().isEmpty()){
            photosUrl = contactForm.getPhotos().stream().map(this::ConfigPhotosUrls).collect(Collectors.toList());

        }
        
        FormContactEntity formContact = FormContactEntity.builder()
        .descripcion(contactForm.getDescription())
        .name(contactForm.getName())
        .photos(photosUrl)
        .problem(contactForm.getProblem())
        .build();
        
        contactFormRepository.save(formContact);
        
        return formContact;
    }

    private String ConfigPhotosUrls(MultipartFile photo){
        return "http://example.com/photos/" + photo.getOriginalFilename();
    }
}

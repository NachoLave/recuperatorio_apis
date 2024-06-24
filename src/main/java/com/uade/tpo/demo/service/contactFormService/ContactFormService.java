package com.uade.tpo.demo.service.contactFormService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public FormContactEntity saveContactForm(FromContactDTO contactForm) {
        
        
        FormContactEntity formContact = FormContactEntity.builder()
        .descripcion(contactForm.getDescription())
        .name(contactForm.getName())
        .photos(contactForm.getPhotos())
        .problem(contactForm.getProblem())
        .build();
        log.info(formContact.toString());
        contactFormRepository.save(formContact);
        

        return formContact;
    }
}

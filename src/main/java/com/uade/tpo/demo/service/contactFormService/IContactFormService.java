package com.uade.tpo.demo.service.contactFormService;
import com.uade.tpo.demo.entity.FormContactEntity;
import com.uade.tpo.demo.entity.dto.FromContactDTO;


public interface IContactFormService{
    FormContactEntity saveContactForm( FromContactDTO contactForm);
}

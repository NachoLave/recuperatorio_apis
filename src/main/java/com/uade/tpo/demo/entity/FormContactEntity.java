package com.uade.tpo.demo.entity;
import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class FormContactEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String problem;
    
    @ElementColletction
    private List<String> photos;

    private String descripcion;
}
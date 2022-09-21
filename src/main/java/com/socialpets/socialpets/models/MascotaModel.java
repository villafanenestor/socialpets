package com.socialpets.socialpets.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pets")
@NoArgsConstructor @AllArgsConstructor @Data
public class MascotaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Tipo")
    private String type;
    private String raza;
    private String peso;
    // Relacion con la tabal de obsevacion mascotas
    private String observaciones;
    @Enumerated()
    private GenderEnum genderEnum;
    private String ubicacion;
    private String foto;

}

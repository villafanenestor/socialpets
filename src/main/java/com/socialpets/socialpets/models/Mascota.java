package com.socialpets.socialpets.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pets")
@NoArgsConstructor @AllArgsConstructor @Data
public class Mascota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipo;
    private String peso;
    private String nombre;
    private String observaciones;
    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private GenderEnum genderEnum;
    private String foto;
    private boolean adoptada= false;

    public boolean getAdoptcion(){
        return this.adoptada;
    }
}

package com.socialpets.socialpets.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table( name = "app_users")
@Getter
@Setter
@Builder()
public class User implements Serializable {

    @Id()
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(name = "name", nullable = false, unique = true)
    // @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Column(name = "email", nullable = false, unique = true)
    // @Email(message = "El Email no es valido")
    @NotBlank(message = "El Email es obligatorio")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8)
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Role rol;

  
}

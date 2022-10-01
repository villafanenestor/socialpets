package com.socialpets.socialpets.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.socialpets.socialpets.models.enums.AdopcionStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Data
@Table(name = "adoptions")
public class Adopcion implements Serializable {
    
    @Id()
    private Long id;


    
    private AdopcionStatus adopcionStatus = AdopcionStatus.EN_ESTUDIO;


    
    
    @Temporal(TemporalType.DATE)
    private Date fechaAprobacion;
    
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;
}

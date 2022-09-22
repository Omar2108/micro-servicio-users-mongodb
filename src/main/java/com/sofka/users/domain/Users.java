
package com.sofka.users.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa la colleccion users en la base de datos
 * @author Omar Rodriguez Chamorro
 * @version 1.0.0 21/09/2022 <omar.rodriguez2108@hotmail.com>
 */

@Document("Users")
@Data
public class Users {
    
    //representa el id en la coleccion usuarios
    @Id
    private String id;
    
    //representa el nombre en la coleccion usuarios
    private String name;
    
    //representa el apellido en la coleccion usuarios
    private String surName;
    
    //representa el tipo de documento en la coleccion usuarios
    private String documentType;
    
    //representa el numero de documento en la coleccion usuario
    private String document;
    
    //representa el email en la coleccion usuarios
    private String email;
    
    //representa la direccion de residencia en la coleccion usuarios
    private String address;
    
    //representa la ciudad de residencia en la coleccion usuarios
    private String city;
    
    //representa el nivel del usuario en la coleccion usuarios
    private String level;
    
    //representa el estado del usuario en la coleccion usuarios
    private Long state;// 1 = activo,  0 = inactivo
    
}

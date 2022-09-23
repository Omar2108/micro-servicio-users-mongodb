
package com.sofka.users.domain;

/**
   Bean para manejo de respuestas 
 * @author Omar Rodriguez Chamorro
 * @version 1.0.0 21/09/2022 <omar.rodriguez2108@hotmail.com>
 */
public class Respuesta {
    
    //Para el manejo de respuesta 
    private String respuesta;
    
    //para el manejo de errores
    private String error;

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
    
    
    
}

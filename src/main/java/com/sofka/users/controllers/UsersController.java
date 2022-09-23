
package com.sofka.users.controllers;

import com.sofka.users.domain.Respuesta;
import com.sofka.users.domain.Users;
import com.sofka.users.service.UsersService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * contiene el control de entrada y salido de datos de la api
 * @author Omar Rodriguez Chamorro
 * @version 1.0.0 21/09/2022 <omar.rodriguez2108@hotmail.com>
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.PATCH})
public class UsersController {
    
    @Autowired//para inyectar UsersService
    private UsersService usersService;
    
    @GetMapping(path = "/")
    public String index(){
       
        return "BIENVENIDOS A LA API REST, CON SPRING BOOT Y MONGODB ATLAS "+"ENDPOINT: "+"\n"
                +"CONSULTAR TODOS LOS USUARIOS: https://api-crud-nodejs.herokuapp.com/v1/users , METODO GET"+"\n"
                +"CREAR UN USUARIO: https://api-crud-nodejs.herokuapp.com/v1/user , METODO POST"+"\n"
                +"ACTUALIZAR UN USUARIO: https://api-crud-nodejs.herokuapp.com/v1/user/{id} , METODO PUT"+"\n"
                +"CONSULTAR USUARIO: https://api-crud-nodejs.herokuapp.com/v1/user/{id} , METODO GET"+"\n"
                +"ELIMINAR UN USUARIO: https://api-crud-nodejs.herokuapp.com/v1/user/{id} , METODO DELETE";
    }
    
    /**
     * Path para consultar todos los usuarios almacenados en la base de datos
     * @return 
     */
    @GetMapping(path = "/v1/users")
    public List<Users> listarUsuario() {

        var users = usersService.list();
        return users;
    }
    
    /**
     * Path para crear un nuevo usuario
     * @param user
     * @return 
     */
    @PostMapping(path = "/v1/user")
    public @ResponseBody Respuesta agregarUsuario(@RequestBody Users user) {
        
        Respuesta respuesta = new Respuesta();
        
        if ("".equals(user.getName())) {
            
            respuesta.setError("El nombre no puede ser nulo");
        }else if("".equals(user.getSurName())){
            
            respuesta.setError("El apellido no puede ser nulo");
        } else if("".equals(user.getDocumentType())){
            
            respuesta.setError("El tipo de documento no puede ser nulo");
        } else if("".equals(user.getDocument())){
            
            respuesta.setError("El documento no puede ser nulo");
        }else if("".equals(user.getEmail())){
            
            respuesta.setError("El email no puede ser nulo");
        }else if("".equals(user.getAddress())){
            
            respuesta.setError("La direccion no puede ser nulo");
        }else if("".equals(user.getCity())){
            
            respuesta.setError("La ciudad no puede ser nulo");
        }else if("".equals(user.getLevel())){
            
            respuesta.setError("El nivel no puede ser nulo");
        }else if(user.getState()==null){
            
            respuesta.setError("El estado no puede ser nulo");
        }else {
            usersService.save(user);
            respuesta.setRespuesta("¡Usuario creado exitosamente!");
        }
        
        return respuesta;
    }
    
    /**
     * Path para consultar la informacion de un usuario en especifico
     * @param id
     * @return 
     */
    @GetMapping(path = "/v1/user/{id}")
    public Optional<Users> consultarUsuario(@PathVariable("id") String id) {
        var user = usersService.findUser(id);
        return user;
    }
    
    /**
     * Path para actualizar la informacion de un usuario por su id
     * @param user
     * @param id
     * @return 
     */
    @PutMapping(path = "/v1/user/{id}")
    public ResponseEntity<Users> actualizarUsuario(@RequestBody Users user, @PathVariable("id") String id) {
        
        usersService.update(id, user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    /**
     * Path para eliminar un usuario por su id
     * @param user
     * @return 
     */
    @DeleteMapping(path = "/v1/user/{id}")
    public @ResponseBody String eliminarUsuario(Users user) {
        
        String respuesta = usersService.delete(user);
        
        return respuesta;
    }
}

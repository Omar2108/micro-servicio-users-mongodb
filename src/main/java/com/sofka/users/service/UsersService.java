package com.sofka.users.service;

import com.sofka.users.domain.Respuesta;
import com.sofka.users.domain.Users;
import com.sofka.users.repository.UsersRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Contiene el servicio que se implementara en el controlador
 *
 * @author Omar Rodriguez Chamorro
 * @version 1.0.0 21/09/2022 <omar.rodriguez2108@hotmail.com>
 */
@Service
@Component
public class UsersService implements IUsersService {

    @Autowired//para inyectar UserRepository
    private UsersRepository usersRepository;

    /**
     * Retorna una lista de usuarios registrados en la coleccion users
     *
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<Users> list() {

        try {
            return usersRepository.findAll();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

    /**
     * crea un nuevo usuario en la coleccion users
     *
     * @param user
     * @return
     */
    @Override
    @Transactional
    public Users save(Users user) {

        try {
            return usersRepository.save(user);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    /**
     * Actualiza los datos de un usuario por su id
     *
     * @param id
     * @param user
     * @return
     */
    @Override
    @Transactional
    public Respuesta update(String id, Users user) {

        try {

            //instancio el objeto de tipo respuesta
            Respuesta respuesta = new Respuesta();

            //se consulta si el usuario ingresado por el cliente en la base de datos
            Optional<Users> resul = usersRepository.findById(id);

            //se valida si el usuario existe 
            if (resul.isPresent()) {

                user.setId(id);
                user.setName(user.getName());
                user.setSurName(user.getSurName());
                user.setDocumentType(user.getDocumentType());
                user.setDocument(user.getDocument());
                user.setEmail(user.getEmail());
                user.setAddress(user.getAddress());
                user.setCity(user.getCity());
                user.setLevel(user.getLevel());
                user.setState(user.getState());
                usersRepository.save(user);
                respuesta.setRespuesta("¡Usuario actualizado exitosamente!");
                return respuesta;

            } else {
                respuesta.setError("El usuario que desea actualizar no existe");
                return respuesta;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    /**
     * Elimina un usuario por medio de su id
     *
     * @param user
     * @return
     */
    @Transactional
    @Override
    public Respuesta delete(Users user) {

        try {

            Respuesta respuesta = new Respuesta();

            Optional<Users> result = usersRepository.findById(user.getId());

            if (result.isPresent()) {

                usersRepository.delete(user);
                respuesta.setRespuesta("¡El usuario fue eliminado!");
                return respuesta;

            } else {
                respuesta.setError("¡Error: El usuario que intenta eliminar no existe!");
                return respuesta;
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return null;

    }

    /**
     * Retorna un usuario por su id
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<Users> findUser(String id) {

        return usersRepository.findById(id);

    }

}

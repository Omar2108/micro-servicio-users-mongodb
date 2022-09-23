
package com.sofka.users.service;

import com.sofka.users.domain.Users;
import java.util.List;
import java.util.Optional;

/**
  Representa los metodos minimos que deben implementarse en la clase UsersService
 * @author Omar Rodriguez Chamorro
 * @version 1.0.0 21/09/2022 <omar.rodriguez2108@hotmail.com>
 */
public interface IUsersService {
    
    public List<Users> list();
    
    public Users save(Users user);
    
    public Users update(String id, Users user);
    
    public String delete(Users user);
    
    public Optional<Users> findUser(String id);
    
}

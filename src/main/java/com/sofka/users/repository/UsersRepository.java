
package com.sofka.users.repository;

import com.sofka.users.domain.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Representa los metodos minimos que deben implementarse
 * @author Omar Rodriguez Chamorro
 * @version 1.0.0 21/09/2022 <omar.rodriguez2108@hotmail.com>
 */
public interface UsersRepository extends MongoRepository<Users, String>  {
    
}

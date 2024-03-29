package br.edu.ufabc.ufabc_runner_ws.data;

import br.edu.ufabc.ufabc_runner_ws.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User, String> {
    User findById(String id);
}

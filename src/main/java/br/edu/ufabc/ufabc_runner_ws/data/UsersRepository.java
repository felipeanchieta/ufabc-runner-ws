package br.edu.ufabc.ufabc_runner_ws.data;

import br.edu.ufabc.ufabc_runner_ws.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UsersRepository extends MongoRepository<User, String> {
    public User findById(String id);

    public List<User> findAll();
}

package br.edu.ufabc.data;

import br.edu.ufabc.models.User;
import org.springframework.stereotype.Component;

/**
 * Created by fcosta on 11/11/16.
 */
@Component
public class UsersDAO {

    public UsersDAO() {

    }

    public User getUserInformation(String id) {
        return new User();
    }
}

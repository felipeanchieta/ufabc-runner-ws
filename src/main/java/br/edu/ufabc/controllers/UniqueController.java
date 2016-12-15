package br.edu.ufabc.controllers;

import br.edu.ufabc.data.UsersRepository;
import br.edu.ufabc.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fcosta on 11/11/16.
 */
@RestController
public class UniqueController {

    private final UsersRepository usersRepository;

    @Autowired
    public UniqueController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getInfo")
    public User getUserInformation(@RequestParam(value = "id") String id) {
        return usersRepository.findById(id);
    }

}

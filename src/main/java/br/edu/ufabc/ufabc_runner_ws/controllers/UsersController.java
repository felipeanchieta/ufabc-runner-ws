package br.edu.ufabc.ufabc_runner_ws.controllers;

import br.edu.ufabc.ufabc_runner_ws.data.UsersRepository;
import br.edu.ufabc.ufabc_runner_ws.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public User getUser(@PathVariable(value = "id") String id) {
        return usersRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}/score")
    public long getUserScore(@PathVariable(value = "id") String id) {
        return usersRepository.findById(id).getScore();
    }


}

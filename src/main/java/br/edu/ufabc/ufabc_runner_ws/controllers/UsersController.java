package br.edu.ufabc.ufabc_runner_ws.controllers;

import br.edu.ufabc.ufabc_runner_ws.data.UsersRepository;
import br.edu.ufabc.ufabc_runner_ws.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * Updates the score of a user previously in the database
     *
     * @param id    the Facebook ID of the user
     * @param score the score that will update the current
     * @return the new score (long)
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/{facebookId}")
    public long updateScore(@PathVariable(value = "facebookId") String id, @RequestParam(value = "score") long score) {
        User user = usersRepository.findById(id);
        if (score > user.getScore()) {
            user.setScore(score);
            usersRepository.save(user);
        }
        return usersRepository.findById(id).getScore();
    }

    /**
     * Gets the score of a user previously in the database
     *
     * @param id the Facebook ID of the user
     * @return the user's current score
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{facebookId}")
    public long getUserScore(@PathVariable(value = "facebookId") String id) {
        return usersRepository.findById(id).getScore();
    }

    /**
     * Inserts a user
     *
     * @param id the Facebook ID of the new user (String)
     */
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void insertUser(@RequestParam(value = "facebookId") String id) {
        usersRepository.insert(new User(id));
    }

    /**
     * Deletes a user
     *
     * @param id the Facebook ID of the user
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/")
    public void deleteUser(@RequestParam(value = "facebookId") String id) {
        usersRepository.delete(id);
    }
}

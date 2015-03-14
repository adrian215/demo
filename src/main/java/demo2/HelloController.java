package demo2;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Adrian on 2015-03-14.
 */
@RestController
@RequestMapping("/")
public class HelloController {
    private final UserDAO userDAO;

    @Autowired
    public HelloController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(method = GET)
    public List<User> getAll()
    {
        System.out.println("GET");
        return userDAO.findAll();
    }

    @RequestMapping(method = POST)
    public void addUser(@RequestParam String name, @RequestParam String password)
    {
        System.out.println("add " + name);
        User user = new User(name, password);
        user.setInstruments(Lists.newArrayList(new Instrument("flet", 10), new Instrument("saksofon", 200)));
        userDAO.save(user);
    }
}

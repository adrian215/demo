package demo2;

import com.google.common.collect.Lists;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static demo2.UserSpecyfication.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Adrian on 2015-03-14.
 */
@RestController
@RequestMapping("/")
public class HelloController {
    private final UserDAO userDAO;
    private final EntityManager entityManager;
    private final InstrumentDAO instrumentDAO;

    @Autowired
    public HelloController(UserDAO userDAO, EntityManager entityManager, InstrumentDAO instrumentDAO) {
        this.userDAO = userDAO;
        this.entityManager = entityManager;
        this.instrumentDAO = instrumentDAO;
    }

    @RequestMapping(method = GET)
    @Modifying
    @Transactional
    public List<User> getAll()
    {
        System.out.println("GET");
//        List<User> users = userDAO.findAll();
        JPAQuery query = new JPAQuery(entityManager);
        QUser user = new QUser("jan");
        Iterable<User> users = (userDAO.findAll(userWithInstrumentCosGraterThan(100)));
        
        List<User> userList = Lists.newArrayList(users);
        return userList;
    }

    @RequestMapping("hello-world")
    public String sayHello(){
        JPAQuery query = new JPAQuery(entityManager);
        QUser user = new QUser("jan");
        List<User> users = query.from(user).where(user.name.length().goe(4)).list(user);
        User selected = users.get(0);
        selected.getInstruments().get(0).setName("aaa");
        userDAO.save(selected);
        return "hello world";
    }

    @RequestMapping(method = POST)
    public void addUser(@RequestParam String name, @RequestParam String password)
    {
        User user = new User(name, password);
        System.out.println("add " + user);
        user.setInstruments(Lists.newArrayList(new Instrument("flety", 10), new Instrument("saksofon", 200)));
        userDAO.save(user);
    }
}

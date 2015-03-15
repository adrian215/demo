package demo2;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
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
    private final EntityManager entityManager;

    @Autowired
    public HelloController(UserDAO userDAO, EntityManager entityManager) {
        this.userDAO = userDAO;
        this.entityManager = entityManager;
    }

    @RequestMapping(method = GET)
    public List<User> getAll()
    {
        System.out.println("GET");
        JPAQuery query = new JPAQuery(entityManager);
        QUser user = QUser.user;
        QInstrument instrument = QInstrument.instrument;
//        return query.from(instrument, user).where(user.name.startsWithIgnoreCase("d"), instrument.cost.eq(200)).limit(1).list(instrument);
        return userDAO.findAll();
        //aa
    }

    @RequestMapping("hello-world")
    public String sayHello(){
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

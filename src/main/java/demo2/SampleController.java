package demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by Adrian on 2015-03-23.
 */
@Controller
@RequestMapping("th")
public class SampleController {
    private final UserDAO userDAO;

    @Autowired
    public SampleController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(method = GET)
    public ModelAndView hello(Model model){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("users", userDAO.findAll());
        return mv;
    }
}

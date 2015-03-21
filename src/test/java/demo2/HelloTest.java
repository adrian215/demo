package demo2;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Objects;

import static org.mockito.Mockito.verify;

/**
 * Created by Adrian on 2015-03-14.
 */
@RunWith(MockitoJUnitRunner.class)
public class HelloTest {

    @Mock
    private UserDAO userDAO;

    @Test
    public void helloTest(){
        Mockito.when(userDAO.findAll()).thenReturn(Lists.newArrayList(new User("name", "password")));
        System.out.printf("aaa");
        System.out.println(userDAO.findAll());
        verify(userDAO).findAll();

    }

    @Test
    public void testAnother(){

    }
}

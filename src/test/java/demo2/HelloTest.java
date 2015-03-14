package demo2;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by Adrian on 2015-03-14.
 */
public class HelloTest {

    private UserDAO userDAO = Mockito.mock(UserDAO.class);

    @Test
    public void helloTest(){
        Mockito.when(userDAO.findAll()).thenReturn(null);
        System.out.printf("aaa");
        System.out.println(userDAO.findAll());

    }
}

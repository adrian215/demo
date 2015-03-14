package demo2;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Adrian on 2015-03-14.
 */
public interface UserDAO extends JpaRepository<User, String>{
}

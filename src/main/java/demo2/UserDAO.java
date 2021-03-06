package demo2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Adrian on 2015-03-14.
 */
public interface UserDAO extends JpaRepository<User, String>, QueryDslPredicateExecutor<User>{

    @Transactional
    @Modifying
    @Query("delete from demo2.User")
    void clear();
}

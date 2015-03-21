package demo2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Adrian on 2015-03-16.
 */
@Repository
public interface InstrumentDAO extends JpaRepository<Instrument, String> {
    @Transactional
    @Modifying
    @Query("delete from demo2.Instrument")
    void clear();
}

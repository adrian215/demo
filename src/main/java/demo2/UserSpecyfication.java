package demo2;

import com.mysema.query.types.Predicate;

/**
 * Created by Adrian on 2015-03-21.
 */
public class UserSpecyfication {
    public static Predicate userWithInstrumentCosGraterThan(int cost)
    {
        QUser user = QUser.user;
        return user.instruments.any().cost.goe(cost);
    }
}

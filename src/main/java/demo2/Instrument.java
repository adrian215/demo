package demo2;

import com.google.common.base.MoreObjects;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

/**
 * Created by Adrian on 2015-03-14.
 */
@Entity
public class Instrument{
    @Id
    @GeneratedValue
    private String id;
    @ManyToOne
    @JoinColumn(name = "user_name")
    private User user;
    private String name;
    private int cost;

    public Instrument() {
    }

    public Instrument(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

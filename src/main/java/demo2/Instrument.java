package demo2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Adrian on 2015-03-14.
 */
@Entity
public class Instrument {
    @Id
    @GeneratedValue
    private String id;
    private String name;
    private int cost;

    public Instrument() {
    }

    public Instrument(String name, int cost) {
        this.name = name;
        this.cost = cost;
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
}

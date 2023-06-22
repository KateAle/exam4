package ru.itmo.ex4;
import jakarta.persistence.*;
import lombok.Getter;
import ru.itmo.database.jpa.entity.Unique;

import java.util.ArrayList;

@Getter

@Entity
@Table(name = "tb_climbers")

public class Climber extends Unique {
    @Column(nullable = false, length = 200)
    private final String name;

    @Column(nullable = false, length = 200)
    private final String address;

    @ManyToMany (mappedBy = "climber_id", cascade = CascadeType.ALL)
    private ArrayList<Group> groups;
    @ManyToOne
    @JoinColumn(name = "mountain_id", nullable = false)
    private Mountain mountain;

    public Climber(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

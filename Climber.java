package ru.itmo.ex4;
import jakarta.persistence.*;
import lombok.Getter;


import java.util.ArrayList;

@Getter

@Entity
@Table(name = "tb_climbers")

public class Climber {
    @Id

    @Column(nullable = false, length = 200)
    private final String name;
    @Column(nullable = false, length = 200)
    private final String address;
    @ManyToMany (mappedBy = "climbers", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private ArrayList<Group> groups;
    @ManyToMany (mappedBy = "climbers", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private ArrayList<Mountain> mountains;

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

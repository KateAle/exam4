package ru.itmo.ex4;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@Entity
@Table(name = "tb_mountains", indexes = @Index(columnList ="name", unique = true))

public class Mountain {
   @Id
    @Column(nullable = false, length = 200)
    public String name;
    @Column(nullable = false, length = 200)
    private String address;
    @Column(nullable = false)
    private final double height;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "mountains_climbers",
            joinColumns = @JoinColumn(name = "mountain_id"),
            inverseJoinColumns = @JoinColumn(name = "climber_id", referencedColumnName = "name"))
    private ArrayList<Climber> climbers;



    @OneToMany(mappedBy = "mountain")
    private ArrayList<Group> groups;


    public Mountain(String name, String address, double height) {
        if (name == null || name.length() < 4) {
            throw new IllegalArgumentException("mount не менее 4 символов");
        }
        if (address == null || address.length() < 4) {
            throw new IllegalArgumentException("address не менее 4 символов");
        }
        if (height == 0 || height < 100) {
            throw new IllegalArgumentException("height не менее 100");
        }
        this.name = name;
        this.address = address;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getHeight() {
        return height;
    }
}

/* @ManyToMany(mappedBy = "mountain_id")
    private ArrayList<Group> groups;*/
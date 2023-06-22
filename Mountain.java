package ru.itmo.ex4;
import jakarta.persistence.*;
import lombok.Getter;
import ru.itmo.database.jpa.entity.Unique;

import java.util.ArrayList;

@Getter
@Entity
@Table(name = "tb_mountains", indexes = @Index(columnList ="name", unique = true))

public class Mountain extends Unique {
    @Column(nullable = false, length = 200)
    public final String name;
    @Column(nullable = false, length = 200)
    private final String address;
    @Column(nullable = false)
    private final double height;
    @OneToMany
    private ArrayList<Climber> climbers;
    @OneToMany
    private Group group;

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
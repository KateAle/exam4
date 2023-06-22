package ru.itmo.ex4;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
@Getter
@Entity
@Table(name = "tb_groups")
public class Group{
   @Id
//    @Column(name="u_id")
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long u_id;

    @Column(nullable = false)
    private LocalDate dateStart;
    @Column(nullable = false)
    private LocalDate dateEnd;
    @Column(nullable = false)
    private boolean open;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "mountain", nullable = false)
    private Mountain mountain;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "groups_climbers",
           joinColumns = @JoinColumn(name = "group_id"),
           inverseJoinColumns = @JoinColumn(name = "climber_id", referencedColumnName = "name"))
    private ArrayList<Climber> climbers;


    public Mountain getMount() {
        return mountain;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public Group(Mountain mountain, String start, String end, boolean open) {
        if (mountain == null) {
            throw new IllegalArgumentException("Exception: mount");
        }
        this.mountain = mountain;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dateStart = LocalDate.parse(start);
        dateEnd = LocalDate.parse(end);
    }



}

/* @ManyToMany
    @JoinTable(name = "groups_mountains",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "mountain_id"))
    private ArrayList<Mountain> mountain;*/





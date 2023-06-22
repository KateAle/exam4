package ru.itmo.ex4;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Getter;
import ru.itmo.database.jpa.entity.Unique;

import java.util.ArrayList;
@Getter
@Entity
@Table(name = "tb_groups")
public class Group extends Unique {

    @Column(nullable = false)
    private LocalDate dateStart;
    @Column(nullable = false)
    private LocalDate dateEnd;
    @Column(nullable = false)
    private boolean open;
    @ManyToOne
    private Mountain mountain;

    @ManyToMany
    @JoinTable(name = "groups_climbers",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "climber_id"))
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



    public Group(Mountain mountain, String start, String end) {
        if (mountain == null) {
            throw new IllegalArgumentException("Exception: mount");
        }
        this.mountain = mountain;
        climbers = new ArrayList<>(3);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dateStart = LocalDate.parse(start);
        dateEnd = LocalDate.parse(end);

    }


}







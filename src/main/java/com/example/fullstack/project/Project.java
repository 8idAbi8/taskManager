package com.example.fullstack.project;

import com.example.fullstack.user.User;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

/**
 * Created by idlirabilaliaj on 06/10/23.
 * Github: https://github.com/8idAbi8
 */
@Entity
@Table(
        name = "projects",
        uniqueConstraints = {   // prevent users from defining duplicate projects
                @UniqueConstraint(columnNames = {"name", "user_id"})
        }
)
public class Project extends PanacheEntity {

    @Column(nullable = false)
    public String name;

    /* ManyToOne: many Projects can have one user, one user can have many projects. */
    @ManyToOne(optional = false)
    public User user;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    public ZonedDateTime created;

    @Version
    public int version;
}

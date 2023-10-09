package com.example.fullstack.task;

import com.example.fullstack.project.Project;
import com.example.fullstack.user.User;
import jakarta.persistence.*;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Created by idlirabilaliaj on 06/10/23.
 * Github: https://github.com/8idAbi8
 */
@Entity
@Table(name = "tasks")
public class Task extends PanacheEntity {

    @Column(nullable = false)
    public String title;

    @Column(length = 1000)
    public String description;

    /*optionalfield to sort and prioritize tasks */
    public Integer priority;

    /* The optional attribute is a property of the @ManyToOne annotation that specifies whether the association is optional or required.
       When optional is set to false, it means that the association is required, and the foreign key column in the database representing this relationship cannot have null values.
       In other words, the associated entity must always exist. */
    @ManyToOne(optional = false)
    public User user;        // the user that owns this task

    /* optional field; users ca use it to group tasks by project*/
    @ManyToOne
    public Project project;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    public LocalDateTime created;

    /* Once users consider a task as complete, they can use the task manager app to set this field whith a timestamp.
    * If the field is null, the task is considered to be incomplete.*/
    public ZonedDateTime complete;

    @Version
    public int version;

}

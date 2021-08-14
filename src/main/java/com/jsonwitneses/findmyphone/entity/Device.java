package com.jsonwitneses.findmyphone.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToMany
    @JsonBackReference
    private Set<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public List<Metric> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }

    @OneToMany(
            mappedBy = "device",
            cascade = {CascadeType.ALL}
    )
    private List<Metric> metrics;

    public Device() {
    }

    public Device(Long id, String name, Set<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

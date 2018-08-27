package com.github.nilankamanoj.system.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Position {
    private int id;
    private String name;
    private byte isOpen;
    private Collection<Job> jobsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "is_open")
    public byte getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(byte isOpen) {
        this.isOpen = isOpen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return id == position.id &&
                isOpen == position.isOpen &&
                Objects.equals(name, position.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, isOpen);
    }

    @OneToMany(mappedBy = "positionByPositionId")
    public Collection<Job> getJobsById() {
        return jobsById;
    }

    public void setJobsById(Collection<Job> jobsById) {
        this.jobsById = jobsById;
    }
}

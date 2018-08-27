package com.github.nilankamanoj.system.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class User {
    private int id;
    private String email;
    private String name;
    private String position;
    private Collection<Pannel> pannelsById;
    private Collection<State> statesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(email, user.email) &&
                Objects.equals(name, user.name) &&
                Objects.equals(position, user.position);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, name, position);
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Pannel> getPannelsById() {
        return pannelsById;
    }

    public void setPannelsById(Collection<Pannel> pannelsById) {
        this.pannelsById = pannelsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<State> getStatesById() {
        return statesById;
    }

    public void setStatesById(Collection<State> statesById) {
        this.statesById = statesById;
    }
}

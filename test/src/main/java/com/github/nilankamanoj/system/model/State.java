package com.github.nilankamanoj.system.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class State {
    private int id;
    private String stateName;
    private String comment;
    private byte isActive;
    private Timestamp transitionTime;
    private Collection<Department> departmentsById;
    private Application applicationByApplicationId;
    private User userByUserId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "state_name")
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "is_active")
    public byte getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "transition_time")
    public Timestamp getTransitionTime() {
        return transitionTime;
    }

    public void setTransitionTime(Timestamp transitionTime) {
        this.transitionTime = transitionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return id == state.id &&
                isActive == state.isActive &&
                Objects.equals(stateName, state.stateName) &&
                Objects.equals(comment, state.comment) &&
                Objects.equals(transitionTime, state.transitionTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, stateName, comment, isActive, transitionTime);
    }

    @OneToMany(mappedBy = "stateByStateId")
    public Collection<Department> getDepartmentsById() {
        return departmentsById;
    }

    public void setDepartmentsById(Collection<Department> departmentsById) {
        this.departmentsById = departmentsById;
    }

    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "id", nullable = false)
    public Application getApplicationByApplicationId() {
        return applicationByApplicationId;
    }

    public void setApplicationByApplicationId(Application applicationByApplicationId) {
        this.applicationByApplicationId = applicationByApplicationId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}

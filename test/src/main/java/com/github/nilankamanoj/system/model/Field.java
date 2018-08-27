package com.github.nilankamanoj.system.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Field {
    private int id;
    private String name;
    private String description;
    private Collection<Feedback> feedbacksById;
    private Collection<ProfileField> profileFieldsById;

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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return id == field.id &&
                Objects.equals(name, field.name) &&
                Objects.equals(description, field.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description);
    }

    @OneToMany(mappedBy = "fieldByFieldId")
    public Collection<Feedback> getFeedbacksById() {
        return feedbacksById;
    }

    public void setFeedbacksById(Collection<Feedback> feedbacksById) {
        this.feedbacksById = feedbacksById;
    }

    @OneToMany(mappedBy = "fieldByFieldId")
    public Collection<ProfileField> getProfileFieldsById() {
        return profileFieldsById;
    }

    public void setProfileFieldsById(Collection<ProfileField> profileFieldsById) {
        this.profileFieldsById = profileFieldsById;
    }
}

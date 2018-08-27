package com.github.nilankamanoj.system.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Profile {
    private int id;
    private String name;
    private String description;
    private Collection<InterviewForm> interviewFormsById;
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
        Profile profile = (Profile) o;
        return id == profile.id &&
                Objects.equals(name, profile.name) &&
                Objects.equals(description, profile.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description);
    }

    @OneToMany(mappedBy = "profileByProfileId")
    public Collection<InterviewForm> getInterviewFormsById() {
        return interviewFormsById;
    }

    public void setInterviewFormsById(Collection<InterviewForm> interviewFormsById) {
        this.interviewFormsById = interviewFormsById;
    }

    @OneToMany(mappedBy = "profileByProfileId")
    public Collection<ProfileField> getProfileFieldsById() {
        return profileFieldsById;
    }

    public void setProfileFieldsById(Collection<ProfileField> profileFieldsById) {
        this.profileFieldsById = profileFieldsById;
    }
}

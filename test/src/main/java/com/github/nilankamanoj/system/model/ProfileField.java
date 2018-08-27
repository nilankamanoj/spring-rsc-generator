package com.github.nilankamanoj.system.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "profile_field", schema = "cv_manager", catalog = "")
public class ProfileField {
    private int id;
    private Profile profileByProfileId;
    private Field fieldByFieldId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileField that = (ProfileField) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = false)
    public Profile getProfileByProfileId() {
        return profileByProfileId;
    }

    public void setProfileByProfileId(Profile profileByProfileId) {
        this.profileByProfileId = profileByProfileId;
    }

    @ManyToOne
    @JoinColumn(name = "field_id", referencedColumnName = "id", nullable = false)
    public Field getFieldByFieldId() {
        return fieldByFieldId;
    }

    public void setFieldByFieldId(Field fieldByFieldId) {
        this.fieldByFieldId = fieldByFieldId;
    }
}

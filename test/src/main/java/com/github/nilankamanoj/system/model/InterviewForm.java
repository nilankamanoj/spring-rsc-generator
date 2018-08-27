package com.github.nilankamanoj.system.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "interview_form", schema = "cv_manager", catalog = "")
public class InterviewForm {
    private int id;
    private Schedule scheduleByScheduleId;
    private Profile profileByProfileId;

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
        InterviewForm that = (InterviewForm) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "id", nullable = false)
    public Schedule getScheduleByScheduleId() {
        return scheduleByScheduleId;
    }

    public void setScheduleByScheduleId(Schedule scheduleByScheduleId) {
        this.scheduleByScheduleId = scheduleByScheduleId;
    }

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id", nullable = false)
    public Profile getProfileByProfileId() {
        return profileByProfileId;
    }

    public void setProfileByProfileId(Profile profileByProfileId) {
        this.profileByProfileId = profileByProfileId;
    }
}

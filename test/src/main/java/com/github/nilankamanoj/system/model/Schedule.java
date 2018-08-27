package com.github.nilankamanoj.system.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Schedule {
    private int id;
    private String venue;
    private Timestamp time;
    private int description;
    private String finalRating;
    private Collection<Feedback> feedbacksById;
    private Collection<InterviewForm> interviewFormsById;
    private Collection<Pannel> pannelsById;
    private Application applicationByApplicationId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "venue")
    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "description")
    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    @Basic
    @Column(name = "final_rating")
    public String getFinalRating() {
        return finalRating;
    }

    public void setFinalRating(String finalRating) {
        this.finalRating = finalRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return id == schedule.id &&
                description == schedule.description &&
                Objects.equals(venue, schedule.venue) &&
                Objects.equals(time, schedule.time) &&
                Objects.equals(finalRating, schedule.finalRating);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, venue, time, description, finalRating);
    }

    @OneToMany(mappedBy = "scheduleByScheduleId")
    public Collection<Feedback> getFeedbacksById() {
        return feedbacksById;
    }

    public void setFeedbacksById(Collection<Feedback> feedbacksById) {
        this.feedbacksById = feedbacksById;
    }

    @OneToMany(mappedBy = "scheduleByScheduleId")
    public Collection<InterviewForm> getInterviewFormsById() {
        return interviewFormsById;
    }

    public void setInterviewFormsById(Collection<InterviewForm> interviewFormsById) {
        this.interviewFormsById = interviewFormsById;
    }

    @OneToMany(mappedBy = "scheduleByScheduleId")
    public Collection<Pannel> getPannelsById() {
        return pannelsById;
    }

    public void setPannelsById(Collection<Pannel> pannelsById) {
        this.pannelsById = pannelsById;
    }

    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "id", nullable = false)
    public Application getApplicationByApplicationId() {
        return applicationByApplicationId;
    }

    public void setApplicationByApplicationId(Application applicationByApplicationId) {
        this.applicationByApplicationId = applicationByApplicationId;
    }
}

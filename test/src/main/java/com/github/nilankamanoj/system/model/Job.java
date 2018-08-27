package com.github.nilankamanoj.system.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Job {
    private int id;
    private Collection<Application> applicationsById;
    private JobDescription jobDescriptionByJobDescriptionId;
    private Position positionByPositionId;

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
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @OneToMany(mappedBy = "jobByJobId")
    public Collection<Application> getApplicationsById() {
        return applicationsById;
    }

    public void setApplicationsById(Collection<Application> applicationsById) {
        this.applicationsById = applicationsById;
    }

    @ManyToOne
    @JoinColumn(name = "job_description_id", referencedColumnName = "id", nullable = false)
    public JobDescription getJobDescriptionByJobDescriptionId() {
        return jobDescriptionByJobDescriptionId;
    }

    public void setJobDescriptionByJobDescriptionId(JobDescription jobDescriptionByJobDescriptionId) {
        this.jobDescriptionByJobDescriptionId = jobDescriptionByJobDescriptionId;
    }

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id", nullable = false)
    public Position getPositionByPositionId() {
        return positionByPositionId;
    }

    public void setPositionByPositionId(Position positionByPositionId) {
        this.positionByPositionId = positionByPositionId;
    }
}

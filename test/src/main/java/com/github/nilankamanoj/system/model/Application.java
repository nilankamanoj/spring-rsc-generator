package com.github.nilankamanoj.system.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Application {
    private int id;
    private String name;
    private String nic;
    private String institute;
    private String source;
    private String gender;
    private String lastCompany;
    private String email;
    private String contactNumber;
    private String fileName;
    private Timestamp createdTime;
    private Job jobByJobId;
    private Collection<Schedule> schedulesById;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "nic")
    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Basic
    @Column(name = "institute")
    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    @Basic
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "last_company")
    public String getLastCompany() {
        return lastCompany;
    }

    public void setLastCompany(String lastCompany) {
        this.lastCompany = lastCompany;
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
    @Column(name = "contact_number")
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Basic
    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "created_time")
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(nic, that.nic) &&
                Objects.equals(institute, that.institute) &&
                Objects.equals(source, that.source) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(lastCompany, that.lastCompany) &&
                Objects.equals(email, that.email) &&
                Objects.equals(contactNumber, that.contactNumber) &&
                Objects.equals(fileName, that.fileName) &&
                Objects.equals(createdTime, that.createdTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, nic, institute, source, gender, lastCompany, email, contactNumber, fileName, createdTime);
    }

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "id", nullable = false)
    public Job getJobByJobId() {
        return jobByJobId;
    }

    public void setJobByJobId(Job jobByJobId) {
        this.jobByJobId = jobByJobId;
    }

    @OneToMany(mappedBy = "applicationByApplicationId")
    public Collection<Schedule> getSchedulesById() {
        return schedulesById;
    }

    public void setSchedulesById(Collection<Schedule> schedulesById) {
        this.schedulesById = schedulesById;
    }

    @OneToMany(mappedBy = "applicationByApplicationId")
    public Collection<State> getStatesById() {
        return statesById;
    }

    public void setStatesById(Collection<State> statesById) {
        this.statesById = statesById;
    }
}

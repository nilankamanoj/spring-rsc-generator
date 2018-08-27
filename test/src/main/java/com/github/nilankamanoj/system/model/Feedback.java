package com.github.nilankamanoj.system.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Feedback {
    private int id;
    private String value;
    private String comment;
    private Schedule scheduleByScheduleId;
    private Field fieldByFieldId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return id == feedback.id &&
                Objects.equals(value, feedback.value) &&
                Objects.equals(comment, feedback.comment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, value, comment);
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
    @JoinColumn(name = "field_id", referencedColumnName = "id", nullable = false)
    public Field getFieldByFieldId() {
        return fieldByFieldId;
    }

    public void setFieldByFieldId(Field fieldByFieldId) {
        this.fieldByFieldId = fieldByFieldId;
    }
}

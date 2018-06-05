package com.spring.fpt.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "attendance_slots", schema = "spring_assignment_advanced", catalog = "")
public class AttendanceSlotsEntity {
    private int id;
    private String classId;
    private int slotId;
    private String subjectCode;
    private Timestamp createDate;
    private boolean status;
    private Collection<AttendanceDetailsEntity> attendanceDetailsById;
    private ClassesEntity classesByClassId;
    private TimeslotsEntity timeslotsBySlotId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "class_id", nullable = false, length = 50, insertable=false, updatable=false)
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "slot_id", nullable = false, insertable=false, updatable=false)
    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    @Basic
    @Column(name = "subject_code", nullable = false, length = 50)
    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceSlotsEntity that = (AttendanceSlotsEntity) o;
        return id == that.id &&
                slotId == that.slotId &&
                status == that.status &&
                Objects.equals(classId, that.classId) &&
                Objects.equals(subjectCode, that.subjectCode) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, classId, slotId, subjectCode, createDate, status);
    }

    @OneToMany(mappedBy = "attendanceSlotsByIdTimeSlot")
    public Collection<AttendanceDetailsEntity> getAttendanceDetailsById() {
        return attendanceDetailsById;
    }

    public void setAttendanceDetailsById(Collection<AttendanceDetailsEntity> attendanceDetailsById) {
        this.attendanceDetailsById = attendanceDetailsById;
    }

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id", nullable = false)
    public ClassesEntity getClassesByClassId() {
        return classesByClassId;
    }

    public void setClassesByClassId(ClassesEntity classesByClassId) {
        this.classesByClassId = classesByClassId;
    }

    @ManyToOne
    @JoinColumn(name = "slot_id", referencedColumnName = "slot_id", nullable = false)
    public TimeslotsEntity getTimeslotsBySlotId() {
        return timeslotsBySlotId;
    }

    public void setTimeslotsBySlotId(TimeslotsEntity timeslotsBySlotId) {
        this.timeslotsBySlotId = timeslotsBySlotId;
    }
}

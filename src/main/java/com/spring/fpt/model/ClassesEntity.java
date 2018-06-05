package com.spring.fpt.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "classes", schema = "spring_assignment_advanced", catalog = "")
public class ClassesEntity {
    private String classId;
    private Timestamp createDate;
    private boolean classStatus;
    private Collection<AttendanceSlotsEntity> attendanceSlotsByClassId;
    private Collection<StudentClassEntity> studentClassesByClassId;

    @Id
    @Column(name = "class_id", nullable = false, length = 50, insertable=false, updatable=false)
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "create_date", nullable = false)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "class_status", nullable = false)
    public boolean isClassStatus() {
        return classStatus;
    }

    public void setClassStatus(boolean classStatus) {
        this.classStatus = classStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassesEntity that = (ClassesEntity) o;
        return classStatus == that.classStatus &&
                Objects.equals(classId, that.classId) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(classId, createDate, classStatus);
    }

    @OneToMany(mappedBy = "classesByClassId")
    public Collection<AttendanceSlotsEntity> getAttendanceSlotsByClassId() {
        return attendanceSlotsByClassId;
    }

    public void setAttendanceSlotsByClassId(Collection<AttendanceSlotsEntity> attendanceSlotsByClassId) {
        this.attendanceSlotsByClassId = attendanceSlotsByClassId;
    }

    @OneToMany(mappedBy = "classesByClassId")
    public Collection<StudentClassEntity> getStudentClassesByClassId() {
        return studentClassesByClassId;
    }

    public void setStudentClassesByClassId(Collection<StudentClassEntity> studentClassesByClassId) {
        this.studentClassesByClassId = studentClassesByClassId;
    }
}

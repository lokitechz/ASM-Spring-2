package com.spring.fpt.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "students", schema = "spring_assignment_advanced", catalog = "")
public class StudentsEntity {
    private String studentId;
    private String studentName;
    private Collection<AttendanceDetailsEntity> attendanceDetailsByStudentId;
    private Collection<StudentClassEntity> studentClassesByStudentId;

    @Id
    @Column(name = "student_id", nullable = false, length = 50, insertable=false, updatable=false)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "student_name", nullable = true, length = 255)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsEntity that = (StudentsEntity) o;
        return Objects.equals(studentId, that.studentId) &&
                Objects.equals(studentName, that.studentName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(studentId, studentName);
    }

    @OneToMany(mappedBy = "studentsByStudentId")
    public Collection<AttendanceDetailsEntity> getAttendanceDetailsByStudentId() {
        return attendanceDetailsByStudentId;
    }

    public void setAttendanceDetailsByStudentId(Collection<AttendanceDetailsEntity> attendanceDetailsByStudentId) {
        this.attendanceDetailsByStudentId = attendanceDetailsByStudentId;
    }

    @OneToMany(mappedBy = "studentsByStudentId")
    public Collection<StudentClassEntity> getStudentClassesByStudentId() {
        return studentClassesByStudentId;
    }

    public void setStudentClassesByStudentId(Collection<StudentClassEntity> studentClassesByStudentId) {
        this.studentClassesByStudentId = studentClassesByStudentId;
    }
}

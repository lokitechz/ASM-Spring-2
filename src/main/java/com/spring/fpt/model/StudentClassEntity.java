package com.spring.fpt.model;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "student_class", schema = "spring_assignment_advanced", catalog = "")
//@IdClass(StudentClassEntityPK.class)
public class StudentClassEntity implements Serializable {

	private static final long serialVersionUID = -5050729727708823474L;
	private String studentId;
    private String classId;
    private Timestamp createDate;
    private boolean status;
    private StudentsEntity studentsByStudentId;
    private ClassesEntity classesByClassId;

    @Id
    @Column(name = "student_id", nullable = false, length = 50, insertable=false, updatable=false)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "class_id", nullable = false, length = 50, insertable=false, updatable=false)
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
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
    @Column(name = "status", nullable = true)
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentClassEntity that = (StudentClassEntity) o;
        return Objects.equals(studentId, that.studentId) &&
                Objects.equals(classId, that.classId) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(studentId, classId, createDate, status);
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    public StudentsEntity getStudentsByStudentId() {
        return studentsByStudentId;
    }

    public void setStudentsByStudentId(StudentsEntity studentsByStudentId) {
        this.studentsByStudentId = studentsByStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "class_id", nullable = false)
    public ClassesEntity getClassesByClassId() {
        return classesByClassId;
    }

    public void setClassesByClassId(ClassesEntity classesByClassId) {
        this.classesByClassId = classesByClassId;
    }
}

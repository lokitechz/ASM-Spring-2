package com.spring.fpt.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "attendance_details", schema = "spring_assignment_advanced", catalog = "")
public class AttendanceDetailsEntity {
    private int id;
    private Integer idTimeSlot;
    private String studentId;
    private Timestamp createDate;
    private boolean status;
    private AttendanceSlotsEntity attendanceSlotsByIdTimeSlot;
    private StudentsEntity studentsByStudentId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_time_slot", nullable = true, insertable=false, updatable=false)
    public Integer getIdTimeSlot() {
        return idTimeSlot;
    }

    public void setIdTimeSlot(Integer idTimeSlot) {
        this.idTimeSlot = idTimeSlot;
    }

    @Basic
    @Column(name = "student_id", nullable = true, length = 50, insertable=false, updatable=false)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
        AttendanceDetailsEntity that = (AttendanceDetailsEntity) o;
        return id == that.id &&
                Objects.equals(idTimeSlot, that.idTimeSlot) &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idTimeSlot, studentId, createDate, status);
    }

    @ManyToOne
    @JoinColumn(name = "id_time_slot", referencedColumnName = "id")
    public AttendanceSlotsEntity getAttendanceSlotsByIdTimeSlot() {
        return attendanceSlotsByIdTimeSlot;
    }

    public void setAttendanceSlotsByIdTimeSlot(AttendanceSlotsEntity attendanceSlotsByIdTimeSlot) {
        this.attendanceSlotsByIdTimeSlot = attendanceSlotsByIdTimeSlot;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    public StudentsEntity getStudentsByStudentId() {
        return studentsByStudentId;
    }

    public void setStudentsByStudentId(StudentsEntity studentsByStudentId) {
        this.studentsByStudentId = studentsByStudentId;
    }

	public AttendanceDetailsEntity(Integer idTimeSlot, String studentId, Timestamp createDate, Boolean status) {
		super();
		this.idTimeSlot = idTimeSlot;
		this.studentId = studentId;
		this.createDate = createDate;
		this.status = status;
	}

	public AttendanceDetailsEntity() {
		super();
	}
    
}

package com.spring.fpt.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "timeslots", schema = "spring_assignment_advanced", catalog = "")
public class TimeslotsEntity {
    private int slotId;
    private String slotTime;
    private Collection<AttendanceSlotsEntity> attendanceSlotsBySlotId;

    @Id
    @Column(name = "slot_id", nullable = false, insertable=false, updatable=false)
    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    @Basic
    @Column(name = "slot_time", nullable = false, length = 50)
    public String getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeslotsEntity that = (TimeslotsEntity) o;
        return slotId == that.slotId &&
                Objects.equals(slotTime, that.slotTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(slotId, slotTime);
    }

    @OneToMany(mappedBy = "timeslotsBySlotId")
    public Collection<AttendanceSlotsEntity> getAttendanceSlotsBySlotId() {
        return attendanceSlotsBySlotId;
    }

    public void setAttendanceSlotsBySlotId(Collection<AttendanceSlotsEntity> attendanceSlotsBySlotId) {
        this.attendanceSlotsBySlotId = attendanceSlotsBySlotId;
    }
}

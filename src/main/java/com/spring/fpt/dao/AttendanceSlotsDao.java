package com.spring.fpt.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.spring.fpt.model.AttendanceDetailsEntity;
import com.spring.fpt.model.AttendanceSlotsEntity;
import com.spring.fpt.model.StudentsEntity;

public interface AttendanceSlotsDao {
	List<AttendanceSlotsEntity> getListAttSlots(LocalDate time);
	
	boolean checkExistAttSlots(int att_slot_id);
	
	Map<StudentsEntity, AttendanceDetailsEntity> getAllStudents(int att_slot_id);
	
	AttendanceSlotsEntity getAttSlotById(int att_slot_id);
}

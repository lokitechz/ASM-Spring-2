package com.spring.fpt.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.spring.fpt.model.AttendanceDetailsEntity;
import com.spring.fpt.model.AttendanceSlotsEntity;
import com.spring.fpt.model.StudentsEntity;

public interface AttendanceSlotsService {
	List<AttendanceSlotsEntity> getAttSlotsByDate(LocalDate date);
	
	boolean checkAttSlotsExist(int att_slot_id);

	Map<StudentsEntity, AttendanceDetailsEntity> getAllStudents(int att_slot_id);
	
	AttendanceSlotsEntity getAttSlotById(int att_slot_id);
}

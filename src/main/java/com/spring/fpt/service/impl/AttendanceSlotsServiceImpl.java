package com.spring.fpt.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.fpt.dao.AttendanceSlotsDao;
import com.spring.fpt.model.AttendanceDetailsEntity;
import com.spring.fpt.model.AttendanceSlotsEntity;
import com.spring.fpt.model.StudentsEntity;
import com.spring.fpt.service.AttendanceSlotsService;

@Service
public class AttendanceSlotsServiceImpl implements AttendanceSlotsService{
	
	@Autowired
	AttendanceSlotsDao attSlotsDao;

	@Override
	public List<AttendanceSlotsEntity> getAttSlotsByDate(LocalDate date) {
		return attSlotsDao.getListAttSlots(date);
	}

	@Override
	public boolean checkAttSlotsExist(int att_slot_id) {
		return attSlotsDao.checkExistAttSlots(att_slot_id);
	}

	@Override
	public Map<StudentsEntity, AttendanceDetailsEntity> getAllStudents(int att_slot_id) {
		return attSlotsDao.getAllStudents(att_slot_id);
	}

	@Override
	public AttendanceSlotsEntity getAttSlotById(int att_slot_id) {
		return attSlotsDao.getAttSlotById(att_slot_id);
	}

}

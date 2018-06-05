package com.spring.fpt.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.spring.fpt.dao.AttendanceSlotsDao;
import com.spring.fpt.model.AttendanceDetailsEntity;
import com.spring.fpt.model.AttendanceSlotsEntity;
import com.spring.fpt.model.StudentsEntity;

@Repository
public class AttendanceSlotsDaoImpl implements AttendanceSlotsDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<AttendanceSlotsEntity> getListAttSlots(LocalDate time) {
		List<AttendanceSlotsEntity> listAttSlots = new ArrayList<AttendanceSlotsEntity>();
		Date timeSql = java.sql.Date.valueOf(time);
		String sql = "from AttendanceSlotsEntity attSlots" + 
				" join attSlots.timeslotsBySlotId tmSlots" + 
				" join attSlots.classesByClassId as classes" + 
				" where date(attSlots.createDate) = ?" + 
				" and attSlots.status = 1" + 
				" and classes.classStatus = 1";
		List<Object[]> listObj = entityManager.createQuery(sql).setParameter(0, timeSql).getResultList();
		for (Object[] obj : listObj) {
			AttendanceSlotsEntity attSlots1 = (AttendanceSlotsEntity) obj[0];
			listAttSlots.add(attSlots1);
		}
		return listAttSlots;
	}

	@Override
	public boolean checkExistAttSlots(int att_slot_id) {
		String sql = "from AttendanceDetailsEntity where idTimeSlot = ?";
		List<AttendanceDetailsEntity> attDetail = new ArrayList<AttendanceDetailsEntity>();
		attDetail = entityManager.createQuery(sql, AttendanceDetailsEntity.class)
				.setParameter(0, att_slot_id).getResultList();
		return (attDetail.size() == 0) ? false : true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<StudentsEntity, AttendanceDetailsEntity> getAllStudents(int att_slot_id) {
		Map<StudentsEntity, AttendanceDetailsEntity> listStuAttClass = new HashMap<>();
		if(checkExistAttSlots(att_slot_id)) {
			String sql = "from AttendanceSlotsEntity attSlots" +
				" join attSlots.attendanceDetailsById attDetail" +
				" join attSlots.classesByClassId classes" +
				" join attDetail.studentsByStudentId stu" +
				" where attSlots.id = ?";
			List<Object[]> listObj = entityManager.createQuery(sql).setParameter(0, att_slot_id).getResultList();
			for (Object[] obj : listObj) {
				AttendanceDetailsEntity attDetail = (AttendanceDetailsEntity) obj[1];
				StudentsEntity student = (StudentsEntity) obj[2];
				listStuAttClass.put(student, attDetail);
			}
		} else {
			String sql = "from AttendanceSlotsEntity attSlots" +
				" join attSlots.classesByClassId classes" +
				" join classes.studentClassesByClassId stuClass" +
				" join stuClass.studentsByStudentId stu" +
				" where attSlots.id = ?";
			List<Object[]> listObj = entityManager.createQuery(sql).setParameter(0, att_slot_id).getResultList();
			for (Object[] obj : listObj) {
				StudentsEntity student = (StudentsEntity) obj[3];
				listStuAttClass.put(student, null);
			}
		}

		return listStuAttClass;
	}

	@Override
	public AttendanceSlotsEntity getAttSlotById(int att_slot_id) {
		String sql = "from AttendanceSlotsEntity where id = ?";
		AttendanceSlotsEntity attSlot = entityManager.createQuery(sql, AttendanceSlotsEntity.class)
				.setParameter(0, att_slot_id)
				.getSingleResult();
		return (attSlot != null) ? attSlot : null;
	}

}

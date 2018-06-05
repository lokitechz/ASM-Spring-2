package com.spring.fpt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.fpt.model.AttendanceDetailsEntity;

@Repository
public interface AttendanceDetailDao extends CrudRepository<AttendanceDetailsEntity, Integer> {

}

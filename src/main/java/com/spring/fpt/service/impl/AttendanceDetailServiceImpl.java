package com.spring.fpt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.fpt.dao.AttendanceDetailDao;
import com.spring.fpt.model.AttendanceDetailsEntity;
import com.spring.fpt.service.AttendanceDetailService;

@Service
public class AttendanceDetailServiceImpl implements AttendanceDetailService {
	
	@Autowired
	AttendanceDetailDao attDetailDao;

	@Override
	public boolean saveAttDetail(AttendanceDetailsEntity attDetail) {
		return (attDetailDao.save(attDetail) != null) ? true : false;
	}
}

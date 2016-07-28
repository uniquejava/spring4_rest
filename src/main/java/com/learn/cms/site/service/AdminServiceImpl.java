package com.learn.cms.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.cms.site.dao.AdminDao;
import com.learn.cms.site.model.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	@Override
	public List<Admin> findAll() {
		return adminDao.findAll();
	}
	
	@Override
	public Admin findById(Long id) {
		return adminDao.findById(id);
	}

}

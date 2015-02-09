package com.learn.cms.site.service;

import java.util.List;

import com.learn.cms.site.model.Admin;

public interface AdminService {
	public List<Admin> findAll();
	
	public Admin findById(Long id);

}

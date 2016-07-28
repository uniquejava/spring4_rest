package com.learn.cms.site.dao;

import java.util.List;

import com.learn.cms.site.model.Admin;

public interface AdminDao {
	public List<Admin> findAll();

	public Admin findById(Long id);
}

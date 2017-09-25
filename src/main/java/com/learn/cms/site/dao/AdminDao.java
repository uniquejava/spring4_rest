package com.learn.cms.site.dao;

import com.learn.cms.site.model.Admin;

import java.util.List;

public interface AdminDao {
    public List<Admin> findAll();

    public Admin findById(Long id);
}

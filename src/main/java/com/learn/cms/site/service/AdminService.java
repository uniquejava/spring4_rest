package com.learn.cms.site.service;

import com.learn.cms.site.model.Admin;

import java.util.List;

public interface AdminService {
    public List<Admin> findAll();

    public Admin findById(Long id);

}

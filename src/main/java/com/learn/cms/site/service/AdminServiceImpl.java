package com.learn.cms.site.service;

import com.learn.cms.site.dao.AdminDao;
import com.learn.cms.site.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    public Admin findById(Long id) {
        return adminDao.findById(id);
    }

}

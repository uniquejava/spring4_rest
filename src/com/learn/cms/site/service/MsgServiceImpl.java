package com.learn.cms.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.cms.site.dao.MsgDao;
import com.learn.cms.site.model.Admin;
import com.learn.cms.site.model.Msg;

@Service
public class MsgServiceImpl implements MsgService {
	@Autowired
	private MsgDao msgDao;

	@Override
	public List<Msg> findAll() {
		return msgDao.findAll();
	}

	@Override
	public Msg findById(Long id) {
		return msgDao.findById(id);
	}

	@Transactional
	public void saveMsg(Msg msg) {
		msgDao.saveMsg(msg);
	}

	@Transactional
	public void updateMsg(Msg msg) {
		msgDao.updateMsg(msg);
		;
	}

	@Override
	public void deleteById(Long id) {
		msgDao.deleteById(id);
	}

}

package com.learn.cms.site.dao;

import java.util.List;

import com.learn.cms.site.model.Admin;
import com.learn.cms.site.model.Msg;

public interface MsgDao {
	public List<Msg> findAll();

	public Msg findById(Long id);

	public void saveMsg(Msg msg);

	public void updateMsg(Msg msg);

	public void deleteById(Long id);
}

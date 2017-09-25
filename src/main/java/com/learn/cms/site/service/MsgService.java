package com.learn.cms.site.service;

import com.learn.cms.site.model.Msg;

import java.util.List;

public interface MsgService {
    public List<Msg> findAll();

    public Msg findById(Long id);

    public void saveMsg(Msg msg);

    public void updateMsg(Msg msg);

    public void deleteById(Long id);
}

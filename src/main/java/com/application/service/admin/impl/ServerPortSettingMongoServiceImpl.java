package com.application.service.admin.impl;

import com.application.dao.admin.ServerPortSettingMongoDao;
import com.application.orm.admin.ServerPortSetting;
import com.application.service.admin.ServerPortSettingMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @auther ttm
 * @date 2018/9/18
 */
@Service
public class ServerPortSettingMongoServiceImpl implements ServerPortSettingMongoService<ServerPortSetting> {

    @Autowired
    private ServerPortSettingMongoDao serverPortSettingMongoDao;

    @Override
    public List<ServerPortSetting> findCollection(Map<String, Object> request) {
        return serverPortSettingMongoDao.fetchCollection(request);
    }

    @Override
    public Long findCollectionCount(Map<String, Object> request) {
        return serverPortSettingMongoDao.fetchCollectionCount(request);
    }

    @Override
    public boolean update(Map<String, Object> request) {
        return serverPortSettingMongoDao.update(request);
    }

    @Override
    public boolean save(Map<String, Object> request) {
        return serverPortSettingMongoDao.save(request);
    }

    @Override
    public boolean deleteById(Object id) {
        return serverPortSettingMongoDao.deleteById(id);
    }

    @Override
    public ServerPortSetting findOne(Object id) {
        return (ServerPortSetting) serverPortSettingMongoDao.findOne(Integer.valueOf(id.toString()));
    }

    @Override
    public ServerPortSetting findOne(Map<String, Object> request) {
        return (ServerPortSetting) serverPortSettingMongoDao.fetchRow(request);
    }

    @Override
    public List<ServerPortSetting> findListByQuery(Map<String, Object> request) {
        return serverPortSettingMongoDao.fetchCollection(request);
    }

}
package com.application.controller.admin;

import com.application.orm.admin.ServerPortSetting;
import com.application.system.core.controller.MyErpController;
import com.application.system.core.controller.vo.ServiceResponseVo;
import com.application.system.core.dao.MongoDao;
import com.application.system.core.orm.ServiceResponseCode;
import com.application.system.core.orm.ServiceResponseDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("serverSetting")
public class ServerPortSettingMongoController extends MyErpController {

    @Autowired
    private MongoDao serverPortSettingMongoDao;

    @RequestMapping("fetchServerPortSettingCollection")
    @ResponseBody
    public ServiceResponseVo fetchServerPortSettingCollection(@RequestBody Map<String, Object> request) {
        try {
            List<ServerPortSetting> serverPortSettings = (List<ServerPortSetting>) serverPortSettingMongoDao.fetchCollection(request);
            Long collectionCount = serverPortSettingMongoDao.fetchCollectionCount(request);
            Map<String, Object> collectionInfo = new HashMap<>();
            collectionInfo.put(COLLECTION, serverPortSettings);
            collectionInfo.put(COLLECTION_COUNT, collectionCount);
            setResult(collectionInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getResponse();
    }

    @RequestMapping("updateServerPortSetting")
    @ResponseBody
    public ServiceResponseVo updateServerPortSetting(@RequestBody Map<String, Object> request) {
        try {
            if (!serverPortSettingMongoDao.update(request)) {
                setResponseCode(ServiceResponseCode.ERROR);
                setResponseDescription(ServiceResponseDescription.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getResponse();
    }

    @RequestMapping("createServerPortSetting")
    @ResponseBody
    public ServiceResponseVo createServerPortSetting(@RequestBody Map<String, Object> request) {
        try {
            if (!serverPortSettingMongoDao.save(request)) {
                setResponseCode(ServiceResponseCode.ERROR);
                setResponseDescription(ServiceResponseDescription.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getResponse();
    }

    @RequestMapping("deleteServerPortSetting")
    @ResponseBody
    public ServiceResponseVo deleteServerPortSetting(@RequestBody Object id) {
        try {
            if (!serverPortSettingMongoDao.deleteById(id)) {
                setResponseCode(ServiceResponseCode.ERROR);
                setResponseDescription(ServiceResponseDescription.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getResponse();
    }

    @RequestMapping("fetchServerPortSettingById")
    @ResponseBody
    public ServiceResponseVo fetchServerPortSettingById(@RequestBody Object id) {
        try {
            ServerPortSetting serverPortSetting = (ServerPortSetting) serverPortSettingMongoDao
                    .load(id);
            setResult(serverPortSetting);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getResponse();
    }

    @RequestMapping("queryServerPortSetting")
    @ResponseBody
    public ServiceResponseVo queryServerPortSetting(@RequestBody Map<String, Object> request) {
        try {
            ServerPortSetting serverPortSetting = (ServerPortSetting) serverPortSettingMongoDao
                    .fetchRow(request);
            setResult(serverPortSetting);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getResponse();
    }

    @RequestMapping("queryServerPortSettings")
    @ResponseBody
    public ServiceResponseVo queryServerPortSettings(@RequestBody Map<String, Object> request) {
        try {
            List<ServerPortSetting> serverPortSetting = (List<ServerPortSetting>) serverPortSettingMongoDao
                    .fetchCollection(request);
            setResult(serverPortSetting);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getResponse();
    }

}

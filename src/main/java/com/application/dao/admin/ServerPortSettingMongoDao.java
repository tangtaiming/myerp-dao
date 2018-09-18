package com.application.dao.admin;

import com.application.orm.admin.ServerPortSetting;
import com.application.system.core.dao.MongoDao;
import org.springframework.stereotype.Repository;

/**
 * @auther ttm
 * @date 2018/9/18
 */
@Repository
public class ServerPortSettingMongoDao extends MongoDao {

    public ServerPortSettingMongoDao() {
        super(ServerPortSetting.class);
    }

}

package com.application.service;

import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @auther ttm
 * @date 2018/9/18
 */
@NoRepositoryBean
public interface MongoService<T extends Serializable> {

    public List<T> findCollection(Map<String, Object> request);

    public Long findCollectionCount(Map<String, Object> request);

    public boolean update(Map<String, Object> request);

    public boolean save(Map<String, Object> request);

    public boolean deleteById(Object id);

    public T findOne(Object id);

    public T findOne(Map<String, Object> request);

    public List<T> findListByQuery(Map<String, Object> request);

}

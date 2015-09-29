package cn.bevisoft.jcasex.dal.dao;

import cn.bevisoft.jcasex.dal.model.Entity;

public interface BaseDAO<T extends Entity> {

    Long insert(T entity);
    
    int deleteById(Long id);
    
    T selectById(Long id);
}

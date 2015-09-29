package cn.bevisoft.jcasex.dal.dao.impl;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.bevisoft.jcasex.dal.dao.BaseDAO;
import cn.bevisoft.jcasex.dal.model.Entity;

public class BaseDAOImpl<T extends Entity> extends SqlSessionDaoSupport implements BaseDAO<T> {

    private String                 shortClassName;
    
    public BaseDAOImpl(){
        String name = this.getClass().getSimpleName();
        name =  StringUtils.substringBefore(name, "DAOImpl");
        this.shortClassName  = StringUtils.lowerCase(name.substring(0,1)) + name.substring(1);
   }
    
    protected final String getSqlStatement(String statementName) {
        return new StringBuffer(shortClassName).append(".").append(statementName).toString();
    }
    
    @Override
    public Long insert(T entity) {
        this.getSqlSession().insert(getSqlStatement("insert"), entity);
        return entity.getId();
    }

    @Override
    public int deleteById(Long id) {
        return this.getSqlSession().delete(getSqlStatement("deleteById"), id);
    }

    @Override
    public T selectById(Long id) {
        return this.getSqlSession().selectOne(getSqlStatement("selectById"), id);
    }
}

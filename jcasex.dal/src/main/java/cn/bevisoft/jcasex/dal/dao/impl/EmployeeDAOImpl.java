package cn.bevisoft.jcasex.dal.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.bevisoft.jcasex.dal.dao.EmployeeDAO;
import cn.bevisoft.jcasex.dal.model.Employee;

@Component("employeeDAO")
public class EmployeeDAOImpl extends BaseDAOImpl<Employee> implements EmployeeDAO {

    @Override
    public Employee selectBy(String loginAccount, String password) {
        Map<String,Object> parameterMap = new HashMap<String,Object>();
        parameterMap.put("loginAccount", loginAccount);
        parameterMap.put("password", password);
        
        return (Employee)this.getSqlSession().selectOne(this.getSqlStatement("selectByLoginAccountAndPassword"), parameterMap);
    }

    @Override
    public Employee selectBy(String loginAccount) {
        return (Employee)this.getSqlSession().selectOne(this.getSqlStatement("selectByLoginAccount"), loginAccount);
    }

}

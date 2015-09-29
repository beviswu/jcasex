package cn.bevisoft.jcasex.biz.employee.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import cn.bevisoft.jcasex.biz.employee.EmployeeManager;
import cn.bevisoft.jcasex.biz.employee.exception.EmployeeErrorCode;
import cn.bevisoft.jcasex.biz.employee.exception.EmployeeException;
import cn.bevisoft.jcasex.common.enums.MD5Encrypt;
import cn.bevisoft.jcasex.dal.dao.EmployeeDAO;
import cn.bevisoft.jcasex.dal.model.Employee;

@Component("employeeManager")
public class EmployeeManagerImpl implements EmployeeManager {
    
    @Resource(name="employeeDAO")
    private EmployeeDAO employeeDAO;

    @Override
    public Employee login(String loginId, String password) throws Exception {
        Employee employee = this.employeeDAO.selectBy(loginId);
        if (employee == null) {
            throw new EmployeeException(EmployeeErrorCode.EMPLOYEE_NOT_FUND);
        }

        if (!StringUtils.equalsIgnoreCase(employee.getPassword(), MD5Encrypt.encode(password))) {
            throw new EmployeeException(EmployeeErrorCode.PASSWORD_INCORRECT);
        }
        
        return employee;
    }

}

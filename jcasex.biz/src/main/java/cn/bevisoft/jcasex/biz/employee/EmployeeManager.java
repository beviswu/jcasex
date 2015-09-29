package cn.bevisoft.jcasex.biz.employee;

import cn.bevisoft.jcasex.dal.model.Employee;

/**
 * 员工(Employee)业务层接口
 * 
 * @author xubo.wuxb
 * @version $Id: EmployeeManager.java, v 0.1 2015-3-1 下午10:21:30 xubo.wuxb Exp $
 */
public interface EmployeeManager {
    
    /**
     * 员工登录
     * 如果登录成功则返回当前用户信息，如果未找到相应的员工信息，则返回
     * 
     * @param loginAccount 
     * @param password
     * @return
     */
    Employee login(String loginAccount,String password) throws Exception;

}

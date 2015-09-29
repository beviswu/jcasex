package cn.bevisoft.jcasex.dal.dao;

import cn.bevisoft.jcasex.dal.model.Employee;

/**
 * 用户操作DAO接口
 * 
 * @author xubo.wuxb
 *
 */
public interface EmployeeDAO extends BaseDAO<Employee> {
	/**
	 * 通过登录帐号和密码获取对应员工的员工信息。
	 * 
	 * @param loginAccount
	 *            登录帐号，不能为空
	 * @param password
	 *            密码（加密过的），不能为空
	 * @return 对应的员工信息。如果未找到对应的员工，则返回null.
	 */
	Employee selectBy(String loginAccount, String password);

	/**
	 * 通过登录帐号获取对应员工的员工信息。
	 * 
	 * @param loginAccount
	 *            登录帐号，不能为空
	 * @return 对应的员工信息。如果未找到对应的员工，则返回null.
	 */
	Employee selectBy(String loginAccount);
}

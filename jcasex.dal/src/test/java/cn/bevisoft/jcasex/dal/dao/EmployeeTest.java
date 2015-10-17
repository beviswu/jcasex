package cn.bevisoft.jcasex.dal.dao;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import cn.bevisoft.jcasex.dal.enums.EntityStatus;
import cn.bevisoft.jcasex.dal.model.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/jcasex-datasource.xml",
                                   "classpath:META-INF/spring/jcasex-dal.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class EmployeeTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private EmployeeDAO employeeDAO;

    @Test
    public void testCase01_InsertAndSelect() {
        Employee employee = new Employee();
        employee.setAccount("xubo.wuxb");
        employee.setCreatorId(1232L);
        employee.setPassword("123456");
        employee.setNickname("dsfdsf");
        employee.setStatus(EntityStatus.ENABLED);
        Long actid = this.employeeDAO.insert(employee);
        Assert.assertNotNull(actid);
        
        Employee actEmployee = this.employeeDAO.selectById(actid);
        Assert.assertNotNull(actEmployee);
        
        Assert.assertEquals(EntityStatus.ENABLED.getCode(), actEmployee.getStatus().getCode());
        Assert.assertEquals(employee.getAccount(), actEmployee.getAccount());
    }

}

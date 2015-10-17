package cn.bevisoft.jcasex.web.employee.screen;

import java.util.ArrayList;
import java.util.List;

import cn.bevisoft.jcasex.web.vo.ItemVO;
import cn.bevisoft.jcasex.web.vo.JcaseXDataVO;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;

public class EmployeeQueryAjax {
	
	public void execute(Navigator nav, Context context){
		System.out.println("asdfasdf");
		
		JcaseXDataVO dataVO = new JcaseXDataVO(true);
		dataVO.setMsg("msg...");
		List<ItemVO> items = new ArrayList<ItemVO>();
		ItemVO it1 = new ItemVO("account1","nick1","1");
		items.add(it1);
		ItemVO it2 = new ItemVO("account2","nick2","2");
		items.add(it2);
		ItemVO it3 = new ItemVO("account3","nick3","3");
		items.add(it3);


		dataVO.setData(items);
		context.put("JCASEX_DATA_VO", dataVO);
		
	}

}

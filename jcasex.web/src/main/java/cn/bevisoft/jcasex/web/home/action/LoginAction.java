package cn.bevisoft.jcasex.web.home.action;

import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.webx.tutorial.app1.Visitor;

public class LoginAction {
	
    public void doRegister(@FormGroup("loginForm") Visitor visitor, Navigator nav) {
        String name = visitor.getName();
        nav.redirectTo("app1Link").withTarget("form/welcome").withParameter("name", name);
    }

}

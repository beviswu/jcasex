package cn.bevisoft.jcasex.web.home.screen;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.dataresolver.Param;

public class Wellcome {
    public void execute(@Param("name") String name, Context context) {
        context.put("name", name);
    }
}

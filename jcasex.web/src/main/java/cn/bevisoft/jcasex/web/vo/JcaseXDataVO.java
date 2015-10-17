package cn.bevisoft.jcasex.web.vo;

import java.io.Serializable;

public class JcaseXDataVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean suceess = true;

	private Object data;

	private String msg;

	public JcaseXDataVO() {

	}

	public JcaseXDataVO(boolean suceess) {
		this.suceess = suceess;
	}

	public JcaseXDataVO(boolean suceess, String msg) {
		this.suceess = suceess;
		this.msg = msg;
	}

	public JcaseXDataVO(boolean suceess, String msg, Object data) {
		this.suceess = suceess;
		this.msg = msg;
		this.data = data;
	}

	public boolean isSuceess() {
		return suceess;
	}

	public void setSuceess(boolean suceess) {
		this.suceess = suceess;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

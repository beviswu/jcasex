package cn.bevisoft.jcasex.biz.employee.exception;

import org.apache.commons.lang3.StringUtils;

public class EmployeeException extends Exception {

	private static final long serialVersionUID = 1L;

	private EmployeeErrorCode errorCode;

	/**
	 * 格式如"p1=v1,p2=v2"
	 */
	 String bizParam;

	public String buildMsg() {
		StringBuffer msg = new StringBuffer();
		if (errorCode != null) {
			msg.append(errorCode.toString());
		}

		if (StringUtils.isNotBlank(bizParam)) {
			msg.append(":");
			msg.append(bizParam);
		}

		return msg.toString();
	}

	public EmployeeException(EmployeeErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public EmployeeException(EmployeeErrorCode errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public EmployeeException(EmployeeErrorCode errorCode, String bizParam,
			Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		this.bizParam = bizParam;
	}
}

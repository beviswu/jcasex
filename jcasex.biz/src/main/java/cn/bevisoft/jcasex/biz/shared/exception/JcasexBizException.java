package cn.bevisoft.jcasex.biz.shared.exception;

import org.apache.commons.lang3.StringUtils;

public class JcasexBizException extends Exception {

	private static final long serialVersionUID = 1L;

	private Enum errorCode;

	/**
	 * 格式如"p1=v1,p2=v2"
	 */
	protected String bizParam;

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

	public JcasexBizException(Enum errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public JcasexBizException(CommonErrorCode errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public JcasexBizException(CommonErrorCode errorCode, String bizParam,
			Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		this.bizParam = bizParam;
	}
}

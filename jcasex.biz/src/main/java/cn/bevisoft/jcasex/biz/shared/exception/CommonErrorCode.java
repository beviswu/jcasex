package cn.bevisoft.jcasex.biz.shared.exception;

public enum CommonErrorCode {
	
	SYS_ERROR("系统错误"),
	
	OBJECT_NOT_FUND("未找到对应的对象");
	
	private String errorMsg;
	
	private CommonErrorCode(String errorMsg){
		this.errorMsg = errorMsg;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}	
	
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("ErrorCode=");
		stringBuffer.append(this.name()).append(",");
		stringBuffer.append("ErrorMsg=");
		stringBuffer.append(this.getErrorMsg());
		return stringBuffer.toString();
	}

}

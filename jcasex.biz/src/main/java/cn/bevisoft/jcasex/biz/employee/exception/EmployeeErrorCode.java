package cn.bevisoft.jcasex.biz.employee.exception;

public enum EmployeeErrorCode {
	
	EMPLOYEE_NOT_FUND("未找到对应的会员信息"),
	PASSWORD_INCORRECT("密码错误");
	
	private String errorMsg;
	
	private EmployeeErrorCode(String errorMsg){
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

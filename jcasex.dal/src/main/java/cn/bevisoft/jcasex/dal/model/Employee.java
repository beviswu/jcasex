package cn.bevisoft.jcasex.dal.model;

/**
 * 员工DO对象
 * 
 * @author xubo.wuxb
 *
 */
public class Employee extends Entity {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户名
	 */
	private String loginAccount;

	/**
	 * 密码(MD5加密)
	 */
	private String password;

	/**
	 * nick
	 */
	private String nickname;

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
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
	 * 帐号
	 */
	private String account;

	/**
	 * 密码(MD5加密)
	 */
	private String password;

	/**
	 * nick
	 */
	private String nickname;


	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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
package cn.bevisoft.jcasex.web.vo;

public class ItemVO {

	private String account;

	private String nick;

	private String id;

	public ItemVO() {

	}

	public ItemVO(String account, String nick, String id) {
		this.account = account;
		this.nick = nick;
		this.id = id;

	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

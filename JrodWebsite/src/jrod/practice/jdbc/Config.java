package jrod.practice.jdbc;

public class Config {
	private String domain;
	private String database;
	private String user;
	private String password;
	
	public Config(String domain, String database, String user, String password) {
		super();
		this.domain = domain;
		this.database = database;
		this.user = user;
		this.password = password;
	}
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

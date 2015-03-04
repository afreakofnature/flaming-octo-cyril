package jrod.practice.jdbc;

public class Account {
	private String _id;
	private String _name;
	private String _description;
	private String _website;
	
	public Account(String id, String name, String description, String website) {
		this._id = id;
		this._name = name;
		this._description = description;
		this._website = website;
	}
	
	
	public String getId() {
		return _id;
	}
	public void setId(String id) {
		this._id = id;
	}
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		this._name = name;
	}
	public String getDescription() {
		return _description;
	}
	public void setDescription(String description) {
		this._description = description;
	}
	public String getWebsite() {
		return _website;
	}
	public void setWebsite(String website) {
		this._website = website;
	}
	
}

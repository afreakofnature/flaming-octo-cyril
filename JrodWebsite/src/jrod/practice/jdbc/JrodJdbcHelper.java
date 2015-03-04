package jrod.practice.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JrodJdbcHelper {
	private static List<Account> _accounts;
	
	
	public static List<Account> getAccounts() {
		if (_accounts == null || _accounts.size() == 0) {
			Connector db = new Connector();
			List<Map> accountRows = db.getRows("accounts", "id", "name", "description", "website");
			
			_accounts = new ArrayList<Account>();
			for (Map accountRow : accountRows) {
				Account a = new Account(
									(String)accountRow.get("id"),
									(String)accountRow.get("name"),
									(String)accountRow.get("description"),
									(String)accountRow.get("website")
								);
				_accounts.add(a);
			}
		}
		
		return _accounts;
	}
}

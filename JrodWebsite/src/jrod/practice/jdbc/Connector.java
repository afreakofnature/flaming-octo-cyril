package jrod.practice.jdbc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Connector {
	
	private static final String REGEX_REPLACER = ";REPLACE;THIS;WITH;PARAMETERS;";
	
	private Context _context;
	private Connection _connection;
	private Config _config;
	
	public Connector() {
		try {
			
			// (desktop applicaitons only)
			// Load the MySQL driver 
			//Class.forName("com.mysql.jdbc.Driver");
			
			// Setup connection with the DB
			/*
			this._config = configurations;
			this._connection = DriverManager
								.getConnection(
									String.format(
										"jdbc:mysql://%s/%s?user=%s&password=%s",
										this._config.getDomain(),
										this._config.getDatabase(),
										this._config.getUser(),
										this._config.getPassword()));
			*/
		
			// (using application server and JNDI)
						
			_context = new InitialContext();
            DataSource ds = (DataSource) _context.lookup("java:/comp/env/jdbc/TestDB");
             
            _connection = ds.getConnection();
			
			
		
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void close() {
		try {
			if (this._connection != null) {
				this._connection.close();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	public List<Map> getRows(String table, String... columns) {
		List<Map> rows = null;
		
		if (columns != null && columns.length > 0) {
			try {
				String queryColumns = "";
				for (int index = 0; index < columns.length; index++) {
					queryColumns += columns[index] + ", ";
				}
				// Remove the remaining ", " last two characters.
				queryColumns = queryColumns.substring(0, queryColumns.length() - 2);
				
				String queryString = String.format("SELECT %s FROM %s", queryColumns, table);
				Statement query = this._connection.createStatement();
				
				ResultSet results = query.executeQuery(queryString);
				
				rows = new ArrayList<Map>();
				while (results.next()) {
					Map<String, String> row = new HashMap<String, String>();
					for (int cIndex = 0; cIndex < columns.length; cIndex++) {
						// TODO: Don't assume always Strings
						row
							.put(
								columns[cIndex], 
								results.getString(columns[cIndex]));
					}
					rows.add(row);
				}
				
				results.close();
				query.close();
				
				return rows;
			
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		return rows;
	}
	
	
}

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

class Database {
	private final String user, password;
	private Connection conn;

	Database(String user, String password) {
		this.user = user;
		this.password = password;
	}

	static final String URL_DB = "jdbc:postgresql://127.0.0.1:5432/store";

	Connection openConn() throws SQLException {
		if (conn != null)
			conn.close();
		Properties connProps = new Properties();
		connProps.put("user", this.user);
		connProps.put("password", this.password);
		conn = DriverManager.getConnection(URL_DB, connProps);
		return conn;
	}

	ResultSet findAll(final String table) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM " + table;
		try {
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
		} catch (SQLException ex) {
			if (stmt != null)
				stmt.close();
			throw ex;
		}
		return rs;
	}

	Connection getConn() {
		return this.conn;
	}

}

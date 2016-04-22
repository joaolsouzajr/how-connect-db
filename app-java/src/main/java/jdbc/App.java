package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

	public static void main(String args[]) {
		Database db = new Database("storedba", "dba@2573");
		try {
			db.openConn();
			ResultSet rs = db.findAll("product");
			System.out.println("Table: produt");
			System.out.println("id\tname");
			System.out.println("--\t----");
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				db.getConn().close();
			} catch (SQLException ex) {
			}
		}

	}

}

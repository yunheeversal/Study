package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	// connectioin 객체가 리턴 
	public static Connection getConnection() throws SQLException {
	//	return DriverManager.getConnection(
	//			"jdbc:apache:commons:dbcp:guestbook"); // 커넥션 풀은 어디에? xml-> DBCOinit (커넥션 풀 이름이 guestbook)
		return DriverManager.getConnection(
				"jdbc:apache:commons:dbcp:board"); 
	}
}
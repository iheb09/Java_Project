package Login;
import java.sql.*;
public class JDBC {
public static void main (String[] args) throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_pharmacie","root","");	
	PreparedStatement ps = con.prepareStatement("insert into user (ID , nom , prenom , role ) values (?,?,?,?)");
	ps.setString(1, "1");
	ps.setString(2, "ahmed");
	ps.setString(3, "etteyeb");
	ps.setString(4, "1");
	
	int x= ps.executeUpdate();
	if(x>0)
		System.out.println("test done successfully");
	
}
}



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.cj.xdevapi.Statement;


@WebServlet(urlPatterns={"/javaConnection"})
@SuppressWarnings("serial")


public class JDBClogin extends HttpServlet {
	static Connection getConnection() throws Exception{
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost/onlinedirectory";
		String username="root";
		String password="asdfghjkl";
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
		
	}
	
	

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		
		PrintWriter out=response.getWriter();
		boolean flag=false;
		Connection conn=null;
		Statement stmt=null;
		java.sql.ResultSet rs=null;
		try {
			conn=getConnection();
            stmt = conn.createStatement();
			out.print("working");
			long inp;
		try {
			inp=Long.parseLong(request.getParameter("phone"));
			out.println(""+inp);
			rs=stmt.executeQuery("SELECT *FROM tele_dir where contact="+inp);
			
			}
		catch(Exception e)
		{
			String name=request.getParameter("phone");
			rs=stmt.executeQuery("SELECT * FROM tele_dir where name='"+name+"'");
			
		}
		if(rs.next()) {
			String name=rs.getString(1);
			int contact=rs.getInt(2);
			String address=rs.getString(3);
			String company=rs.getString(4);
			int pin=rs.getInt(5);
			out.println("name:"+name);
			out.println("contact:"+contact);
			out.println("address:"+address);
			out.println("company:"+company);
			out.println("pin:"+pin);
			
		}
		else {
			out.println("no contact found");
		}
			
		}catch(ClassNotFoundException e) {
			System.out.println("error:failer to load mysql driver");
			e.printStackTrace();
		}catch(SQLException e)
		{
			System.out.println("error:failed to create connection object");
			e.printStackTrace();


		} catch (Exception e) {
			System.out.println("error:unknown");
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				conn.close();
				
			}catch (Exception e) {
				e.printStackTrace();

			}
		}
		
	}

	
	

}

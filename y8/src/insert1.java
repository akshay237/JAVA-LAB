

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


@WebServlet("/insert1")

public class insert1 extends HttpServlet {
	static Connection getConnection() throws Exception{
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost/onlinedirectory";
		String username="root";
		String password="asdfghjkl";
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
		
	}
	Connection conn1=null;
	
       
    
    
	
	

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		PrintWriter out=response.getWriter();
		boolean flag=false;
		Connection conn=null;
		Statement stmt=null;
		java.sql.ResultSet rs=null;
				
		try {
			String driver="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost/onlinedirectory";
			String username="root";
			String password="asdfghjkl";
			Class.forName(driver);
			conn1=DriverManager.getConnection(url, username, password);
			if(conn1!=null) 
				System.out.println("successful");
				stmt = conn1.createStatement();
				out.print("working");
				
				String name=request.getParameter("nam");
				int contact=Integer.parseInt(request.getParameter("cnt"));
				String address=request.getParameter("address");
				String company=request.getParameter("company");
				int pin=Integer.parseInt(request.getParameter("pin"));
				System.out.println("Working ..");
				out.println("name:"+name);
				out.println("contact:"+contact);
				out.println("address:"+address);
				out.println("company:"+company);
				out.println("pin:"+pin);
				
				stmt.executeUpdate("insert into tele_dir values('"+name+"',"+contact+",'"+address+"','"+company+"',"+pin+");");
				out.println("updated the record");
				
			
			}catch(ClassNotFoundException e) {
				System.out.println("error:failer to load mysql driver");
				e.printStackTrace();
		}catch(SQLException e)
		{
			System.out.println("error:failed to create connection object");
			e.printStackTrace();


		}catch(Exception e) {
			System.out.println("error:unknown");
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn1.close();
				
			}catch (Exception e) {
				e.printStackTrace();

			}
		}
	}
}
		
			
		





import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/tcon")
public class tcon extends HttpServlet {
	
       
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	PrintWriter out=response.getWriter();
    	String[] Accessories= {};
    	Accessories=request.getParameterValues("access");
    	String tshirtTagLine=request.getParameter("tagline");
		String tshirtAccessories="";

    	String tshirtOption=request.getParameter("pocket");
    	String tcolor=request.getParameter("Tshirtcolor");
    	out.println("<html>");
    	out.println("<head><title>T-shirt</title></head>");
    	out.println("<body>");
    	try {
    		Statement stmt;
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tshirt","root","asdfghjkl");    
    			if(conn!=null) {
    				stmt=conn.createStatement();
    				String qu;
                	if(tshirtAccessories!=null && tshirtTagLine!=null && tshirtOption!=null && tcolor!=null){
    					for(String option:Accessories) {
    						tshirtAccessories=tshirtAccessories+option;
    						
    					}
    					qu="insert into Tshirts values("+null+",'"+tshirtAccessories+"','"+tshirtTagLine+"','"+tcolor+"','"+tshirtOption+"');";
    					stmt.executeUpdate(qu);
    					
    					
    					
    				}
    				qu="select * from Tshirts;";
    				ResultSet rs=stmt.executeQuery(qu);
    				out.println("<table border=2>");
    				out.println("<tr>");
    				out.println("<td>OrderNo</td>");
    				out.println("<td>T-shirt Accessories</td>");
    				out.println("<td>T-shirt tag-line</td>");
    				out.println("<td>T-shirt type</td>");
    				out.println("<td>T-shirt color</td>");
    				out.println("</tr>");
    				
    				if(!rs.isBeforeFirst()) {
    					out.println("<tr>");
    					out.println("<td>100</td>");
    					out.println("<td>NULL</td>");
    					out.println("<td>NULL</td>");
    					out.println("<td>NULL</td>");
    					out.println("<td>NULL</td>");
    					out.println("</tr>");
    					
    					}
    				while(rs.next()) {
    					System.out.print("working");
    					out.println("<tr>");
                		out.print("<td>"+(Integer.parseInt(rs.getString("OrderNo"))+99)+"</td>");
    					out.print("<td>"+rs.getString("tshirtAccessories")+"</td>");
    					out.println("<td>"+rs.getString("tshirtTagLine")+"</td>");
    					out.println("<td>"+rs.getString("tshirtOption")+"</td>");
    					out.println("<td>"+rs.getString("tcolor")+"</td>");
    					out.println("</tr>");

    				}
    				out.println("</table>");
    				out.println("<a href=\"tshirt.jsp\">click here</a>");
    				out.println("</body></html>");
    				


    			}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	
    	}
	}
}

	
	
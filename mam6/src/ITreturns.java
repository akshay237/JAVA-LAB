import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ITreturns")
public class ITreturns extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public ITreturns() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String gender=request.getParameter("gender");
        Float salary=Float.parseFloat(request.getParameter("salary"));
        Float tax=Float.parseFloat(request.getParameter("tax"));
        Float taxamt=(tax/100)*salary;
        Float basic=salary-taxamt;
        PrintWriter out=response.getWriter();
        File file = new File("1.txt");
        file.createNewFile();
        System.out.println("Working");
        FileOutputStream fout = new FileOutputStream(file);
        out.println("Name:"+name);
        out.println("Gender:"+gender);
        out.println("Salary:"+salary);
        out.println("Taxamt:"+taxamt);
        out.println("Net:"+basic);
        fout.write(("hello"+name+gender+salary+taxamt+basic).getBytes());
        fout.close();
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request,response);
        }

}

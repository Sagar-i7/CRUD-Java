/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JAYRAJ
 */
public class delete extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet delete</title>");            
            out.println("</head>");
            out.println("<body>");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
                Statement st=con.createStatement();
                int id=Integer.parseInt(request.getParameter("id"));
                ResultSet rs=st.executeQuery("select * from emp where id="+id);
                if(request.getParameter("id")!= null)
                {
                    st.executeUpdate("delete from emp where id="+id);
                    response.sendRedirect("display?msg=Successfully Deleted");
                }
                
            }catch(ClassNotFoundException e){
                System.out.println("<p> Error :</p>"+e.getMessage());
            }catch(SQLException e){
                System.out.println("<p> Error :</p>"+e.getMessage());
            }
            catch(Exception e){
                System.out.println("<p> Error :</p>"+e.getMessage());
                e.printStackTrace();
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

   
}

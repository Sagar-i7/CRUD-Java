

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class add extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css' integrity='sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm' crossorigin='anonymous'>");
            out.println("<script src='https://code.jquery.com/jquery-3.2.1.slim.min.js' integrity='sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN' crossorigin='anonymous'></script>");
            out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js' integrity='sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q' crossorigin='anonymous'></script>");
            out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js' integrity='sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl' crossorigin='anonymous'></script>");
            out.println("<link href='signin.css' rel='stylesheet'>");
            out.println("<title>Servlet add</title>");            
            out.println("</head>");
            out.println("<body>");
            try
            {
                 Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
                Statement st=con.createStatement();
                //int id=Integer.parseInt(request.getParameter("id"));
                ResultSet rs=st.executeQuery("select * from emp");
                 out.println("<nav class=\"navbar navbar-dark bg-dark\">\n" +
                            "      <a class=\"navbar-brand\" href=\"#\">Student Database</a>\n" +
                            "    </nav>");
                 out.println("<br/><br/>");
             
                    out.println("<form action=final_add method=post  class=\"col-md-7 mb-3\">");
                    /*out.println("<lable>Id</lable>");
                    out.println("<input type=number name=id> <br/>");
                    out.println("<lable>Name</id>");
                    out.println("<input type=text name=username> <br/>");
                    out.println("<lable>Password</lable>");
                    out.println("<input type=password name=password><br/>");
                    out.println("<lable>Salary</lable>");
                    out.println("<input type=number name=salary><br/><br/>");*/
                    
                    out.println("<div class=\"form-group row\">\n" +
                                "    <label for=\"colFormLabel\" class=\"col-sm-2 col-form-label\"> Student Id</label>\n" +
                                "    <div class=\"col-sm-10\">\n" +
                                "      <input type=\"number\" name=id class=\"form-control \" id=\"colFormLabel\" placeholder=\"Student Id\" required>\n" +
                                "    </div>\n" +
                                "  </div>");
                     
                    out.println("<div class=\"form-group row\">\n" +
                                "    <label for=\"colFormLabel\" class=\"col-sm-2 col-form-label \" >Student Name</label>\n" +
                                "    <div class=\"col-sm-10\">\n" +
                                "      <input type=\"text\" name=username class=\"form-control\" id=\"colFormLabel\" placeholder=\"Student Name\" required>\n" +
                                "    </div>\n" +    
                                "  </div>");
                    
                    out.println("<div class=\"form-group row\">\n" +
                                "    <label for=\"colFormLabel\" class=\"col-sm-2 col-form-label\">Password</label>\n" +
                                "    <div class=\"col-sm-10\">\n" +
                                "      <input type=\"password\" name=password class=\"form-control\" id=\"colFormLabel\" placeholder=\"Password\" required>\n" +
                                "    </div>\n" +
                                "  </div>");
                 
                   
                   out.println("<div class=\"form-group row\">\n" +
                                "    <label for=\"colFormLabel\" class=\"col-sm-2 col-form-label\">Salary</label>\n" +
                                "    <div class=\"col-sm-10\">\n" +
                                "      <input type=\"number\" name=salary class=\"form-control\" id=\"colFormLabel\" placeholder=\"Salary\" required>\n" +
                                "    </div>\n" +
                                "  </div>");
                    
                    out.println("<button type=\"submit\" class=\"btn btn-danger\">Add</button>");
 
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

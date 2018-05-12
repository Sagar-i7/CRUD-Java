import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class display extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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
            out.println("<title>Servlet display</title>");            
            out.println("</head>");
            out.println("<body>");
            
            try
            {
                int id,salary;
                String name,password;
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select * from emp");
                out.println("<nav class=\"navbar navbar-dark bg-dark\">\n" +
                            "      <a class=\"navbar-brand\" href=\"#\">Student Database</a>\n" +
                            "      <a href='index.html' class='btn btn-light active' role='button' aria-pressed='true'>Log Out</a>\n" +
                            "    </nav>");
                out.println("<table class=\"table\" broder=1>");
                //out.println("<th colspan=2 align=center>Employee Id</th><th colspan=2 align=center>Employee Name</th><th colspan=2 align=center>Employee Password</th><th colspan=2 align=center>Employee Salary</th><th colspan=2 align=center>Edit</th><th colspan=2 align=center>Delete</th>");
                out.println(" <thead>\n" +
                               "<tr>\n" +
                               "<th scope=\"col\"  align=center>Student Id</th>\n" +
                               "<th scope=\"col\" align=center>Student Name</th>\n" +
                               "<th scope=\"col\" align=center>Student Password</th>\n" +
                               "<th scope=\"col\" align=center>Student Salary</th>\n" +
                               "<th scope=\"col\" align=center>Edit</th>\n"+
                               "<th scope=\"col\" align=center>Delete</th>\n"+
                               "</tr>\n" +
                               "</thead>");
                while(rs.next())
                {
                    id=rs.getInt("id");
                    name=rs.getString("name");
                    password=rs.getString("psswd");
                    salary=rs.getInt("salary");
                    out.println("<tr>");
                    out.println("<td  >"+id+"</td>");
                    out.println("<td  >"+name+"</td>");
                    out.println("<td  >"+password+"</td>");
                    out.println("<td  >"+salary+"</td>");
                    out.println("<td  ><a href='edit?id="+rs.getInt("id")+"'>Edit</a></td>");
                    out.println("<td  ><a href='delete?id="+rs.getInt("id")+"'>Delete</a></td>");
                    out.println("</tr>");
                }
                    out.println("</table>");
                    out.println("<br/>");
                    out.println("<form action=add method=post>");
                    //out.println("<input type=submit value='Add New Student'>");
                    out.println("<button class=\"btn btn-primary\" type=\"submit\">Add New Student</button>");
                    out.println("</from>");
                    
                    //out.println("<form action=index.html method=post>");
                    //out.println("<input type=submit value='Log Out'>");
                    //out.println("<a href='index.html'> Log Out</a>");
                    //out.println("</from>");
                    
                    rs.close();
            }catch(SQLException e){out.println(e);}
            catch(ClassNotFoundException e){out.println(e);}
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JAYRAJ
 */
public class validate extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;chatset=UTF-8");
        PrintWriter out=response.getWriter();
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
                int flag=0;
                String name,passwd;
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select * from login");
                //pst.setString(1, request.getParameter("name"));
                //pst.setString(2,request.getParameter("password"));
                name= request.getParameter("name");
                passwd=request.getParameter("password");
                //ResultSet rs=pst.executeQuery();
                /*while(rs.next())
                {
                    flag = 1;
                }*/
                if(name.equals("sagar") &&(passwd.equals("sagar@1234")))
                {
                    
                    RequestDispatcher rd=request.getRequestDispatcher("display");
                    rd.forward(request,response);
                }
                else
                {
                    //out.println("<h1>Error!! UserId OR Password are incorrect..!!</h1>");
                    out.println("<div class=\"alert alert-success\" role=\"alert\">\n" +
                                "  <h4 class=\"alert-heading\">Opps!</h4>\n" +
                                " <lable> You Entered invalid Username or password..!!</lable>\n" +
                                "</div>");
                    RequestDispatcher rd=request.getRequestDispatcher("index.html");
                    rd.include(request,response);
                }
            }
            catch(SQLException e)
            {
                System.out.println(e.getMessage());
            }
            catch(ClassNotFoundException e)
            {
                   System.out.println(e.getMessage());
            }
            catch(Exception e){System.out.println(e.getMessage());}
          out.println("</body>");
            out.println("</html>");
    }
}

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class  ShowAll extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		
		
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='abc.css'/>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<div id='mymenu'>");
          out.println("<ul><li>home</li><li><a href='Insertdemo.html'>Insert</a></li><li><a href='ShowAll'>ShoAll</a></li><li><a href='searchdemo.html'>search</a></li><li><a href='UpdateDemo1.html'>update</a></li><li><a href='DeleteDemo1.html'>delete</a></li><li><a href='login.html'>LogOut</a></li><li>Contact</li></ul></div>");

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///ajava68?useSSL=false","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from insmarks ");
			 
			 out.println("<center>");
             out.println("<table cellpadding='12'>");			 
			 out.println("<tr>");
			 out.println("<th>first Name</th>");
			 out.println("<th>Last Name</th>");
			 out.println("<th>Phone Number</th>");
			 out.println("<th>Email</th>");
			 out.println("<th>Address</th>");
			 out.println("</tr>");
			 
			 while(rs.next())
			 {
				 out.println("<tr>");
				 out.println("<th>"+rs.getString(1)+"</th>");
				 out.println("<th>"+rs.getString(2)+"</th>");
				 out.println("<th>"+rs.getString(3)+"</th>");
				 out.println("<th>"+rs.getString(4)+"</th>");
				 out.println("<th>"+rs.getString(5)+"</th>");
				 out.println("</tr>");
			 }
			 out.println("</table>");
			con.close();
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
	
}
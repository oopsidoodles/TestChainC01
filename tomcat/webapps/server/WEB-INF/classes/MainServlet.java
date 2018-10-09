import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
 
public class MainServlet extends HttpServlet {
	private String tableName = "test";
	
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
 
      // Set the response MIME type of the response message
      response.setContentType("text/html");
      // Allocate a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();
 
      // Write the response message, in an HTML page
      try {
         /*out.println("<html>");
         out.println("<head><title>Hello, World</title></head>");
         out.println("<body>");
         out.println("<h1>Hello, world!</h1>");  // says Hello
         // Echo client's request information
         out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
         out.println("<p>Protocol: " + request.getProtocol() + "</p>");
         out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
         out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
         // Generate a random number upon each request
         out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
         out.println("</body></html>");*/
      } finally {
         out.close();  // Always close the output writer
      }
   }
   
   @Override
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
	   Connection conn = null;
	   Statement stmt = null;
	   try
	   {
	       String firstname = request.getParameter("firstname");
	       String lastname = request.getParameter("lastname");
	       
	       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/c01testing?useSSL=false", "vili", "vili");
	       
	       //stmt = conn.createStatement();
	       
	       //String insert = String.format("INSERT INTO test VALUES (%s, %s)", firstname, lastname);
	       String insert = "INSERT INTO " + tableName + "(firstname, lastname) " + "VALUES(?,?)";
	       
	       PreparedStatement insertSql = conn.prepareStatement(insert);
	       insertSql.setString(1, firstname);
	       insertSql.setString(2, lastname);
	       insertSql.executeUpdate();
	       
	       //stmt.executeUpdate(insert);
	       
		   stmt.close();
		   conn.close();
	   }
	   catch (SQLException e)
	   {
		   e.printStackTrace();
	   }
   }
}
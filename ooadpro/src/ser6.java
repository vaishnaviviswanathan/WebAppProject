

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ser6
 */
public class ser6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ser6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		 out.println("<html>");
		 out.println("<head>");
         out.println("<title>UNIVERSITY ADMISSION</title>");
         out.println("</head>");
         out.println("<body>");
         try
		 {
				ResultSet result;
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				java.sql.Connection con;
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ooadtab","root","tylorhoechlin");
				
				 
				java.sql.Statement stat=con.createStatement();
				result=stat.executeQuery("select * from student_details where marks>90");
				
			 out.println("<p style='text-align:center;font-size:30px'><b>ADMITTED STUDENT DETAILS</b></p>");
			 out.println("<table border='1'>");
			 out.println("<tr>");
			 out.println("<th>NAME </th>");
			 out.println("<th>BIRTHDATE </th>");
			 out.println("<th>EMAIL ID </th>");
			 out.println("<th>CITIZENSHIP </th>");
			 out.println("<th>SSN </th>");
			 out.println("<th>TERM </th>");
			 out.println("<th colspan='3'>DEPARTMENT </th>");
			 out.println("<th colspan='3'>COURSE SELECTED</th>");
			 out.println("<th colspan='3'>PROFESSOR REQUIRED</th>");
			 out.println("<th>MARKS OBTAINED </th>");
			 out.println("<th colspan='2'>PASSWORD </th>");
			 out.println("</tr>");
			 while(result.next())
			 {
			 out.println("<tr>");
			 out.println("<td>"+result.getString(1)+"</td>");
			 out.println("<td>"+result.getString(2)+"</td>");
			 out.println("<td>"+result.getString(3)+"</td>");
			 out.println("<td>"+result.getString(4)+"</td>");
			 out.println("<td>"+result.getString(5)+"</td>");
			 out.println("<td>"+result.getString(6)+"</td>");
			 out.println("<td colspan='3'>"+result.getString(7)+"</td>");
			 out.println("<td colspan='3'>"+result.getString(8)+"</td>");
			 out.println("<td colspan='3'>"+result.getString(9)+"</td>");
			 out.println("<td>"+result.getString(10)+"</td>");
			  out.println("<td colspan='2'>"+result.getString(11)+"</td>");
			 out.println("</tr>");
			 }
		 }//try close
		 catch(Exception e)
		 {	
				out.println("Error"+e);
		 }//catch close
		 

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

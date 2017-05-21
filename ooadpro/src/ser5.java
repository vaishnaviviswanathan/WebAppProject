

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ser5
 */
public class ser5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ser5() {
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
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 
				 java.sql.Connection con;
				 
				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ooadtab","root","pswd");
				 String action=request.getParameter("acc");
				 if(action.equals("SUBMIT"))
				 {
					 String field1,field2,field3,field4;
					 String f1,f2,f3,f4;
					 	 field1=request.getParameter("term");
						 field2=request.getParameter("department");
						 field3=request.getParameter("branch");
						 field4=request.getParameter("professor");
						//out.println(""+field2+""+field3+""+field4+"");
						 java.sql.Statement s=con.createStatement();
						 s.executeQuery("select * from course_details where season='"+field1+"' ");
						 ResultSet rs=s.getResultSet();
						while(rs.next())
						{
							f1=rs.getString("season");
							f2=rs.getString("department");
							f3=rs.getString("course");
							f4=rs.getString("prof");
						
							if(field1.equals(f1) && field3.equals(f3) && field2.equals(f2) && field4.equals(f4))
							{ 
								response.sendRedirect("ooqadrep.html");
							}//if close
							
							else
							{
							    response.sendRedirect("courseselect.html");
							}
							
						
						
						}//if close
						 
						
						
						
				 }//if close
				 
				 
	        }//try close
	        catch(Exception e)
	        {
	        	out.println("Error : "+e);
	        }//catch close
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

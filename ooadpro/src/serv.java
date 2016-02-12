

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class serv
 */
public class serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
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
				 
				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ooadtab","root","tylorhoechlin");
				 
				 String field1=request.getParameter("appid");
				 String field2=request.getParameter("pswd");
				 String action=request.getParameter("appl");
				 
				 if(action.equals("CLICK TO CONFIRM SUBMISSION"))
				 {
					 String insertion=("insert into details values('"+field1+"','"+field2+"')");
					 PreparedStatement pstmt=(PreparedStatement)con.prepareStatement(insertion);
					 pstmt.executeUpdate();
					 response.sendRedirect("courseselect.html");
				}
				
				 out.println("</body>");
	        
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
	doGet(request,response);
	}

}

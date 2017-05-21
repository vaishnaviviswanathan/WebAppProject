

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class serv4
 */
public class serv4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serv4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//pswd1 appid
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Hello World!</title>");
	        out.println("</head>");
	        out.println("<body>");
	        
	        
	        try
	        {
	        	
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 java.sql.Connection con;
				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ooadtab","root","pswd");
				 String field1; 
				 String pswd1;
				 
				 String action=request.getParameter("acc");
				 if(action.equals("LOGIN"))
				 {
					
					 String appid=request.getParameter("appid");
					 pswd1=request.getParameter("pswd1");
					 java.sql.Statement s=con.createStatement();
					 s.executeQuery("select * from details where app_id='"+appid+"'");
					 ResultSet rs=s.getResultSet();
				    
				    // out.println(field1);
				     //out.println(pswd1);
				     if(rs.next())
				     {
				     field1=rs.getString("passwd");
				     if(pswd1.equals(field1))
					{
						response.sendRedirect("form.html");

					}//if close
					else
					{ 
						//out.println("<head><script>alert('wrong application id or password...REGISTER IF YOU DONT HAVE AN ACCOUNT')</script></head>");
						response.sendRedirect("loginpage.html");
					}//else close
					 
				     }//inner if close
				 }//if close
	        }//try close
	        catch(Exception e)
	        {
	        	out.println("Error :"+e);
	        }//catch close
	        out.println("</table>");  
	       
	        out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}	
}

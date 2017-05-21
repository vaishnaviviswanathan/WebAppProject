

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class ooadserv1
 */
public class ooadserv1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ooadserv1() {
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
				 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ooadtab","root","pswd");
				 String action=request.getParameter("acc");
				 
				 if(action.equals("SUBMIT"))
				 {
					String field1=request.getParameter("name");
					String field2=request.getParameter("birthday");
					String field3=request.getParameter("email");
					String field4=request.getParameter("citizenship");
					String field5=request.getParameter("ssn");
					String field6=request.getParameter("term");
					String field7=request.getParameter("department");
					String field8=request.getParameter("branch");
					String field9=request.getParameter("professor");
					String field10=request.getParameter("marks");
					String field11=request.getParameter("pswd");
					if(field1!=null && field2!=null && field3!=null && field4!=null&& field5!=null && field6!=null&& field7!=null && field8!=null&& field9!=null && field10!=null&& field11!=null )
					{	
					String insertion=("insert into student_details values('"+field1+"','"+field2+"','"+field3+"','"+field4+"','"+field5+"','"+field6+"','"+field7+"','"+field8+"','"+field9+"','"+field10+"','"+field11+"')");
					PreparedStatement pstmt=(PreparedStatement)con.prepareStatement(insertion);
					pstmt.executeUpdate();
					}
					out.println("</body>");
					if(field1==null || field2==null || field3==null|| field4==null|| field5==null|| field6==null|| field7==null|| field8==null|| field9==null|| field10==null|| field11==null)
					{
					response.sendRedirect("form.html");
					}
					else
					{
					response.sendRedirect("appid.html");
					}
					//out.println("<head><script> window.location.href='http://localhost:8080/ooadpro/appid.html'</script></head>");
				 }//else if close insert	 
	        }
	catch(Exception e)
	{
	out.println("Error"+e);
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
		//doGet(request,response);
	}

}

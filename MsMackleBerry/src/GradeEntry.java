import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GradeEntry
 */
@WebServlet("/GradeEntry")
public class GradeEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeEntry() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //connect to the DB.
    public static Connection connectDB() throws SQLException, ClassNotFoundException {
    	Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:testuser/password@localhost";
		Properties props = new Properties();
		props.setProperty("user", "testdb");
		props.setProperty("password", "password");
		Connection conn = DriverManager.getConnection(url, props);
		return conn;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			getServletContext().getRequestDispatcher("/Grades.jsp").forward(request, response);		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn;
		try {
			conn = connectDB();
			
	        //creating PreparedStatement object to execute query
	        PreparedStatement preStatement = conn.prepareStatement("insert into grades(assignment, grade) values (" + "\'"
					+request.getParameter("assignment")+ "\'" + "," +request.getParameter("grade")+ ")");
	        preStatement.executeQuery();
	        conn.commit();
	       
	        if(request.getParameter("actSubmit").equals("submit")){
	        	String line =  "<h3> grades display </h3>";
	           	try {
					conn = connectDB();
								        //creating PreparedStatement object to execute query
					preStatement = conn.prepareStatement("select * from grades");
			        ResultSet result = preStatement.executeQuery();        
			        		        
			        line += "<table class=" 
			        		+ "\"table table-striped\"" 
			        		+ "style=width:60%>";
			        
			        line += 
		     			"<tr>" 
		     			+"<th>" + "assignment" + "</th> <br>"
		     			+"<th>" + "grades" + "</th><br>"
		     			+ "</tr>"
		     			;
					
			        while(result.next()){
			        	line += "<tr>" 
			        			+"<td>" + result.getString("assignment") + "</td>"
			        			+ "<td>" +result.getString("Grade") + "</td>"
			        			+"</tr>"
			        	        ;
			        	}
			        
			    line += "</table>";
			    line+= "<br><form action=GradeEntry method=post><input type=submit value=dispAvg name=dispAvg ></form>";
		     	request.setAttribute("message", line);
				getServletContext().getRequestDispatcher("/GradeRecord.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}	         	
	  }
	  if(request.getParameter("dispAvg").equals("dispAvg")){
			try {
				conn = connectDB();
		        //creating PreparedStatement object to execute query
						preStatement = conn.prepareStatement("select count(*)as count, sum(grade)as sum from  grades");
				        ResultSet count = preStatement.executeQuery();  
				        
				        String avgline =  "<h3> average is </h3>";
				        double avg=0;
				        while(count.next()){
				        	
				        	avg = count.getInt(1)/count.getInt("count");
				        	System.out.println(avg);
				        	
				        }
				        avgline += avg;
				        request.setAttribute("message", avgline);
						getServletContext().getRequestDispatcher("/GradeAvg.jsp").forward(request, response);
						conn.close();
				        }catch(Exception e){
							e.printStackTrace();
						}
				}else{
					System.out.println("null pointer exception");
				}
	          
	 }catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	 }    
	}	
}

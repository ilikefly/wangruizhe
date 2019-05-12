package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Zf extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Zf() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		  
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");//璁剧疆杈撳嚭鍐呭鐨勭紪鐮佹牸寮�
		
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/schooldb";
			String user = "root";
			String pwd = "070809";
			conn = (Connection) DriverManager.getConnection(url, user, pwd);// 创建连接，登录数据库
			System.out.println("连接对象创建成功");
		Statement sta=(Statement)conn.createStatement();
		String yhm=request.getParameter("userName");	
		String mm=request.getParameter("dpassword");
ResultSet rs=(ResultSet)sta.executeQuery( "SELECT * FROM schooldb.new_table where name='"+yhm+"' and mima='"+mm+"'");
		if(rs.next()){
			String yh=rs.getString("name");
			String mim=rs.getString("mima");
			if(yh.equals(yhm) && mim.equals(mm)){
//				HttpSession session=request.getSession();
//				session.setAttribute(" name", yhm);
//				session.setAttribute("mima", mm);
//				session.setMaxInactiveInterval(10);
				System.out.println("登陆成功");
			
				 request.getRequestDispatcher("/home").forward(request, response);
			}
		}else{
			 response.sendRedirect("/Xm/zc.html");
		}

		
		} catch (ClassNotFoundException e) {

			System.out.println("没有找到");
		} // 加载驱动
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		
		
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

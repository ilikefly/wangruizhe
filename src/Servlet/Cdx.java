package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Cdx extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Cdx() {
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
		
		 out.println("<BODY>鐢ㄦ埛"+request.getParameter("userName")+"鐧诲綍澶辫触</BODY>");
		
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
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
	
		
		
		Connection conn = null;
		Statement sta=null;
		String yhm=request.getParameter("yhm");	
		String mm=request.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/schooldb";
			String user = "root";
			String pwd = "070809";
			conn = (Connection) DriverManager.getConnection(url, user, pwd);// 创建连接，登录数据库
			System.out.println("连接对象创建成功");
			
			String sql="INSERT INTO schooldb.new_table(name, mima) VALUES ('"+yhm+"','"+mm+"')";
			sta=(Statement) conn.createStatement();
			int r=sta.executeUpdate(sql);
			if(r>0)
				System.out.println("添加成功");
				
			
		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 加载驱动
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (sta!= null)
					sta.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	
		 out.println("<!DOCTYPE html>");
	        out.println("<HTML>");
	        out.println("<HEAD><meta charset='UTF-8'><title>月老登场</title></HEAD>");
	        out.println("<BODY> 恭喜驻车成功请返回登陆页面" +
	        		"：http://pc-20190122uhgj:8080/Xm/MyHtml.html。</BODY>");      
	out.println("</HTML>");
	out.flush();
	out.close();
};

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

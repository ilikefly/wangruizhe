package Servlet;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Sjklj {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement sta=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/schooldb";
			String user = "root";
			String pwd = "070809";
			conn = (Connection) DriverManager.getConnection(url, user, pwd);// 创建连接，登录数据库
			System.out.println("连接对象创建成功");
			
			String sql="INSERT INTO schooldb.new_table(name, mima) VALUES ('')";
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

	}
}

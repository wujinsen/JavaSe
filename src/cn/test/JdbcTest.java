package cn.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {
	private static final String DBURL = "jdbc:mysql://localhost:3306/test";
	private static final String DBUSER = "root";
	private static final String DBPASS = "root";

	public static void main(String[] args) {
		// 数据库连接
		Connection conn = null;
		// 预编译可以提高数据库的性能
		PreparedStatement preparedStatement = null;
		// 结构集
		ResultSet rs = null;		
		try {
			// 加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 通过驱动管理类获取数据库连接
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			// 定义sql语句 ?表示占位符
			String sql = "select * from user where u_name=?";
			// 获取预处理statement
			preparedStatement = conn.prepareStatement(sql);
			//设置参数，第一个参数为sql语句中参数的序号(从1开始)，第二个为设置的参数值
			preparedStatement.setString(1, "333");
			//项数据发出sql执行查询，查询出结果集
			rs = preparedStatement.executeQuery();
			
			//遍历查询结果集
			while(rs.next()){
				System.out.println(rs.getString("id") +", " + rs.getString("u_name"));
			}
			System.out.println("hello");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}

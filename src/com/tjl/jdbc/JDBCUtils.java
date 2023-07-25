package com.tjl.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import java.sql.SQLException;
import java.sql.Statement;




public class JDBCUtils {

	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	//静态语句块
	static
	{
	//将db配置文件读入
	//JDBCUtils.class获得对象
	//getClassLoader()类加载器
	//getResourceAsStream("db.properties")加载资源文件到输入流中
		InputStream is =JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
	    
	//创建Properties对象
		Properties p =new Properties();
	//加载流文件
		try {
			p.load(is);
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			username = p.getProperty("username");
			password = p.getProperty("password");
			//加载驱动
			Class.forName(driver);
			System.out.print("驱动加载成功！");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}		
	}
	
	  //获得链接对象的方法
			public static Connection getConnection()
			{
				try {
					System.out.print("数据库连接成功！");
					return DriverManager.getConnection(url, username, password);
					
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					System.out.print("数据库连接失败！");
					e.printStackTrace();
				}
				return null;
			}
	//释放资源的方法
			public static void close(Connection conn,Statement statement,ResultSet result)
			{
				try {
					if(result!=null)
					{
						result.close();	
						result=null;
					}
					if(statement!=null)
					{
						statement.close();
						statement=null;
					}
					if(conn!=null)
					{
						conn.close();
						conn=null;
					}
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
}

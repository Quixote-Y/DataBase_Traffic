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
	
	//��̬����
	static
	{
	//��db�����ļ�����
	//JDBCUtils.class��ö���
	//getClassLoader()�������
	//getResourceAsStream("db.properties")������Դ�ļ�����������
		InputStream is =JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
	    
	//����Properties����
		Properties p =new Properties();
	//�������ļ�
		try {
			p.load(is);
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			username = p.getProperty("username");
			password = p.getProperty("password");
			//��������
			Class.forName(driver);
			System.out.print("�������سɹ���");
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}		
	}
	
	  //������Ӷ���ķ���
			public static Connection getConnection()
			{
				try {
					System.out.print("���ݿ����ӳɹ���");
					return DriverManager.getConnection(url, username, password);
					
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					System.out.print("���ݿ�����ʧ�ܣ�");
					e.printStackTrace();
				}
				return null;
			}
	//�ͷ���Դ�ķ���
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
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
			
}

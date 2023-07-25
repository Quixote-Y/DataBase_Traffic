package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.DriverManager;

public class JDBC {
	public static void main(String[] args)
	{
	//加载mysql驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.print("驱动加载成功！");
	//连接数据库,获得连接对象
			Connection conne=DriverManager.getConnection("jdbc:mysql://localhost:3306/homework", "root", "1234");
			System.out.print("数据库连接成功！");
	//创建执行环境
			Statement statement =conne.createStatement();
	//执行sql语句，得到结果集
			ResultSet result =statement.executeQuery("select * from 车队表");
			while(result.next())
			{
				System.out.print(result.getInt("车队编号")+"  ");
				
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.print("驱动加载失败！");
			System.out.print("数据库连接失败失败！");
			
		}
	}

}

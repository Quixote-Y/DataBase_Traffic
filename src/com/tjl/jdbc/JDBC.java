package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import java.sql.DriverManager;

public class JDBC {
	public static void main(String[] args)
	{
	//����mysql����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.print("�������سɹ���");
	//�������ݿ�,������Ӷ���
			Connection conne=DriverManager.getConnection("jdbc:mysql://localhost:3306/homework", "root", "1234");
			System.out.print("���ݿ����ӳɹ���");
	//����ִ�л���
			Statement statement =conne.createStatement();
	//ִ��sql��䣬�õ������
			ResultSet result =statement.executeQuery("select * from ���ӱ�");
			while(result.next())
			{
				System.out.print(result.getInt("���ӱ��")+"  ");
				
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.print("��������ʧ�ܣ�");
			System.out.print("���ݿ�����ʧ��ʧ�ܣ�");
			
		}
	}

}

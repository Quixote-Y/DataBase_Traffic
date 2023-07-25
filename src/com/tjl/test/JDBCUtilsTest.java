package com.tjl.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.tjl.jdbc.JDBCUtils;

public class JDBCUtilsTest {

	@Test
	public void jdbcConnectionTest() throws Exception {
		Connection conn = JDBCUtils.getConnection();
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery("select * from Ա����");
		while(result.next())
		{
			System.out.print(result.getString("Ա����"));
		}
	}
}

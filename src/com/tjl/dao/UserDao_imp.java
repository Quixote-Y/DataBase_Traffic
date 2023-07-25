package com.tjl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tjl.bean.Car;
import com.tjl.bean.Peccant;
import com.tjl.bean.Staff;
import com.tjl.jdbc.JDBCUtils;

public class UserDao_imp implements UserDao {
	
	private static final String SQL_USER_ENTERDRIVER = "INSERT into `员工表` values (?,?,?,?)";
	private static final String SQL_USER_ENTERCAR = "INSERT into `汽车表` values (?,?,NULL)";
	private static final String SQL_USER_ENTERPeccant = "INSERT into `违章记录表` values (?,?,?,?,?,?)";
	private static final String SQL_USER_SearchDriver1 = "select * from 车队长表 where 员工号 = ?";
	private static final String SQL_USER_SearchDriver2 = "select * from 路队长表 where 员工号 = ?";
	private static final String SQL_USER_SearchDriver3 = "select * from 员工表 where 员工号 = ?";
	private static final String SQL_USER_SearchPeccant = "select * from 违章记录表 where 员工号=? and ( `发生时间` between ? and ?)";
	private static final String SQL_USER_SearchPeccantTs = "select `违章名` , COUNT(违章名) from 违章记录表 where 员工号=? and ( `发生时间` between ? and ?) Group by `违章名`";
	
	@Override
	public boolean EnterDriver(Staff driver) {
		// 连接数据库 创建连接对象conn
		Connection conn = JDBCUtils.getConnection();
		
		//创建执行环境statement
		
		try {
		PreparedStatement preparedStatement =conn.prepareStatement(SQL_USER_ENTERDRIVER);
       //设置sql语句参数
			preparedStatement.setString(1, driver.getNumber());
			preparedStatement.setString(2, driver.getName());
			preparedStatement.setString(3, driver.getSex());
			preparedStatement.setString(4, driver.getdata());
			int result = preparedStatement.executeUpdate();
			return result>0? true:false;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return false;
	
	}

	@Override
	public boolean EnterCar(Car car) {
		
			// 连接数据库 创建连接对象conn
			Connection conn = JDBCUtils.getConnection();
			
			//创建执行环境statement
			
			try {
			PreparedStatement preparedStatement =conn.prepareStatement(SQL_USER_ENTERCAR);
	       //设置sql语句参数
				preparedStatement.setString(1, car.getNumber());
				preparedStatement.setInt(2, car.getCNumber());
				int result = preparedStatement.executeUpdate();
				return result>0? true:false;
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean EnterSPeccant(Peccant peccant) {
		// 连接数据库 创建连接对象conn
				Connection conn = JDBCUtils.getConnection();
				
				//创建执行环境statement
				
				try {
				PreparedStatement preparedStatement =conn.prepareStatement(SQL_USER_ENTERPeccant);
		       //设置sql语句参数
					preparedStatement.setInt(1, peccant.getPNumber());
					preparedStatement.setString(2, peccant.getPName());
					preparedStatement.setString(3, peccant.getPSNumber());
					preparedStatement.setString(4, peccant.getdata());
					preparedStatement.setString(5, peccant.getPPlace());
					preparedStatement.setString(6, peccant.getCSNumber());
					int result = preparedStatement.executeUpdate();
					return result>0? true:false;
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		return false;
	}

	@Override
	public Staff SearchDriver(String Number,String Number2) {
		// 连接数据库 创建连接对象conn
		Connection conn = JDBCUtils.getConnection();
		
		//创建执行环境statement
		
		try {
		    PreparedStatement preparedStatement =conn.prepareStatement(SQL_USER_SearchDriver1);
       //设置sql语句参数
			preparedStatement.setString(1, Number);
			ResultSet result1 = preparedStatement.executeQuery();
			PreparedStatement preparedStatement2 =conn.prepareStatement(SQL_USER_SearchDriver2);
		       //设置sql语句参数
			preparedStatement2.setString(1, Number);
			ResultSet result2 = preparedStatement2.executeQuery();
			if(result1.next()||result2.next()) {
				PreparedStatement preparedStatement3 =conn.prepareStatement(SQL_USER_SearchDriver3);
			       //设置sql语句参数
				preparedStatement3.setString(1, Number2);
				ResultSet result3 = preparedStatement3.executeQuery();
				if(result3.next()) {
				String number=result3.getString("员工号");
				String name =result3.getString("姓名");
				String sex =result3.getString("性别");
				String data =result3.getString("出生日期");
				Staff staff=new Staff(number,name,sex,data);
				return staff;
			
				}
			}	
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String SearchPeccant(String PSNumber, String SNumber, String date) {
		// 连接数据库 创建连接对象conn
		Connection conn = JDBCUtils.getConnection();
		
		//创建执行环境statement
		
		try {
		    PreparedStatement preparedStatement =conn.prepareStatement(SQL_USER_SearchDriver1);
       //设置sql语句参数
			preparedStatement.setString(1, SNumber);
			ResultSet result1 = preparedStatement.executeQuery();
			PreparedStatement preparedStatement2 =conn.prepareStatement(SQL_USER_SearchDriver2);
		       //设置sql语句参数
			preparedStatement2.setString(1, SNumber);
			ResultSet result2 = preparedStatement2.executeQuery();
			if(result1.next()||result2.next()) {

				String[] data =date.split("--");
				PreparedStatement preparedStatement3 =conn.prepareStatement(SQL_USER_SearchPeccant);
			       //设置sql语句参数
				preparedStatement3.setString(1, PSNumber);
				preparedStatement3.setString(2, data[0]);
				preparedStatement3.setString(3, data[1]);
				
				ResultSet result3 = preparedStatement3.executeQuery();
				String res = null ;
				while(result3.next()) {
				int number=result3.getInt("违章记录编号");
				String name =result3.getString("违章名");
				String PNumber =result3.getString("员工号");
				String data2 =result3.getString("发生时间");
				String place =result3.getString("发生地点");
				String CNumber =result3.getString("记录人员工号"); 
				Peccant a =new Peccant(number,name,PNumber,data2,place,CNumber);
				if(res!=null)
				   res=res+a.toString2();
				else
					res=a.toString2();
				}
				return res;
			}	
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
		
	}



	@Override
	public String SearchPeccantTs(String PSNumber, String SNumber, String date) {
		// 连接数据库 创建连接对象conn
		Connection conn = JDBCUtils.getConnection();
		
		//创建执行环境statement
		
		try {
		    PreparedStatement preparedStatement =conn.prepareStatement(SQL_USER_SearchDriver1);
       //设置sql语句参数
			preparedStatement.setString(1, SNumber);
			ResultSet result1 = preparedStatement.executeQuery();
			PreparedStatement preparedStatement2 =conn.prepareStatement(SQL_USER_SearchDriver2);
		       //设置sql语句参数
			preparedStatement2.setString(1, SNumber);
			ResultSet result2 = preparedStatement2.executeQuery();
			if(result1.next()||result2.next()) {

				String[] data =date.split("--");
				PreparedStatement preparedStatement3 =conn.prepareStatement(SQL_USER_SearchPeccantTs);
			       //设置sql语句参数
				preparedStatement3.setString(1, PSNumber);
				preparedStatement3.setString(2, data[0]);
				preparedStatement3.setString(3, data[1]);
				
				ResultSet result3 = preparedStatement3.executeQuery();
				String res = null ;
				while(result3.next()) {
				String name=result3.getString("违章名");
				String count =result3.getString("COUNT(违章名)");

				if(res!=null)
				   res=res+name+count+'\n';
				else
					res=name+count+'\n';
				}
				return res;
			}	
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;

	}

}

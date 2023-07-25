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
	
	private static final String SQL_USER_ENTERDRIVER = "INSERT into `Ա����` values (?,?,?,?)";
	private static final String SQL_USER_ENTERCAR = "INSERT into `������` values (?,?,NULL)";
	private static final String SQL_USER_ENTERPeccant = "INSERT into `Υ�¼�¼��` values (?,?,?,?,?,?)";
	private static final String SQL_USER_SearchDriver1 = "select * from ���ӳ��� where Ա���� = ?";
	private static final String SQL_USER_SearchDriver2 = "select * from ·�ӳ��� where Ա���� = ?";
	private static final String SQL_USER_SearchDriver3 = "select * from Ա���� where Ա���� = ?";
	private static final String SQL_USER_SearchPeccant = "select * from Υ�¼�¼�� where Ա����=? and ( `����ʱ��` between ? and ?)";
	private static final String SQL_USER_SearchPeccantTs = "select `Υ����` , COUNT(Υ����) from Υ�¼�¼�� where Ա����=? and ( `����ʱ��` between ? and ?) Group by `Υ����`";
	
	@Override
	public boolean EnterDriver(Staff driver) {
		// �������ݿ� �������Ӷ���conn
		Connection conn = JDBCUtils.getConnection();
		
		//����ִ�л���statement
		
		try {
		PreparedStatement preparedStatement =conn.prepareStatement(SQL_USER_ENTERDRIVER);
       //����sql������
			preparedStatement.setString(1, driver.getNumber());
			preparedStatement.setString(2, driver.getName());
			preparedStatement.setString(3, driver.getSex());
			preparedStatement.setString(4, driver.getdata());
			int result = preparedStatement.executeUpdate();
			return result>0? true:false;
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return false;
	
	}

	@Override
	public boolean EnterCar(Car car) {
		
			// �������ݿ� �������Ӷ���conn
			Connection conn = JDBCUtils.getConnection();
			
			//����ִ�л���statement
			
			try {
			PreparedStatement preparedStatement =conn.prepareStatement(SQL_USER_ENTERCAR);
	       //����sql������
				preparedStatement.setString(1, car.getNumber());
				preparedStatement.setInt(2, car.getCNumber());
				int result = preparedStatement.executeUpdate();
				return result>0? true:false;
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean EnterSPeccant(Peccant peccant) {
		// �������ݿ� �������Ӷ���conn
				Connection conn = JDBCUtils.getConnection();
				
				//����ִ�л���statement
				
				try {
				PreparedStatement preparedStatement =conn.prepareStatement(SQL_USER_ENTERPeccant);
		       //����sql������
					preparedStatement.setInt(1, peccant.getPNumber());
					preparedStatement.setString(2, peccant.getPName());
					preparedStatement.setString(3, peccant.getPSNumber());
					preparedStatement.setString(4, peccant.getdata());
					preparedStatement.setString(5, peccant.getPPlace());
					preparedStatement.setString(6, peccant.getCSNumber());
					int result = preparedStatement.executeUpdate();
					return result>0? true:false;
				} catch (Exception e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
		return false;
	}

	@Override
	public Staff SearchDriver(String Number,String Number2) {
		// �������ݿ� �������Ӷ���conn
		Connection conn = JDBCUtils.getConnection();
		
		//����ִ�л���statement
		
		try {
		    PreparedStatement preparedStatement =conn.prepareStatement(SQL_USER_SearchDriver1);
       //����sql������
			preparedStatement.setString(1, Number);
			ResultSet result1 = preparedStatement.executeQuery();
			PreparedStatement preparedStatement2 =conn.prepareStatement(SQL_USER_SearchDriver2);
		       //����sql������
			preparedStatement2.setString(1, Number);
			ResultSet result2 = preparedStatement2.executeQuery();
			if(result1.next()||result2.next()) {
				PreparedStatement preparedStatement3 =conn.prepareStatement(SQL_USER_SearchDriver3);
			       //����sql������
				preparedStatement3.setString(1, Number2);
				ResultSet result3 = preparedStatement3.executeQuery();
				if(result3.next()) {
				String number=result3.getString("Ա����");
				String name =result3.getString("����");
				String sex =result3.getString("�Ա�");
				String data =result3.getString("��������");
				Staff staff=new Staff(number,name,sex,data);
				return staff;
			
				}
			}	
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String SearchPeccant(String PSNumber, String SNumber, String date) {
		// �������ݿ� �������Ӷ���conn
		Connection conn = JDBCUtils.getConnection();
		
		//����ִ�л���statement
		
		try {
		    PreparedStatement preparedStatement =conn.prepareStatement(SQL_USER_SearchDriver1);
       //����sql������
			preparedStatement.setString(1, SNumber);
			ResultSet result1 = preparedStatement.executeQuery();
			PreparedStatement preparedStatement2 =conn.prepareStatement(SQL_USER_SearchDriver2);
		       //����sql������
			preparedStatement2.setString(1, SNumber);
			ResultSet result2 = preparedStatement2.executeQuery();
			if(result1.next()||result2.next()) {

				String[] data =date.split("--");
				PreparedStatement preparedStatement3 =conn.prepareStatement(SQL_USER_SearchPeccant);
			       //����sql������
				preparedStatement3.setString(1, PSNumber);
				preparedStatement3.setString(2, data[0]);
				preparedStatement3.setString(3, data[1]);
				
				ResultSet result3 = preparedStatement3.executeQuery();
				String res = null ;
				while(result3.next()) {
				int number=result3.getInt("Υ�¼�¼���");
				String name =result3.getString("Υ����");
				String PNumber =result3.getString("Ա����");
				String data2 =result3.getString("����ʱ��");
				String place =result3.getString("�����ص�");
				String CNumber =result3.getString("��¼��Ա����"); 
				Peccant a =new Peccant(number,name,PNumber,data2,place,CNumber);
				if(res!=null)
				   res=res+a.toString2();
				else
					res=a.toString2();
				}
				return res;
			}	
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;
		
	}



	@Override
	public String SearchPeccantTs(String PSNumber, String SNumber, String date) {
		// �������ݿ� �������Ӷ���conn
		Connection conn = JDBCUtils.getConnection();
		
		//����ִ�л���statement
		
		try {
		    PreparedStatement preparedStatement =conn.prepareStatement(SQL_USER_SearchDriver1);
       //����sql������
			preparedStatement.setString(1, SNumber);
			ResultSet result1 = preparedStatement.executeQuery();
			PreparedStatement preparedStatement2 =conn.prepareStatement(SQL_USER_SearchDriver2);
		       //����sql������
			preparedStatement2.setString(1, SNumber);
			ResultSet result2 = preparedStatement2.executeQuery();
			if(result1.next()||result2.next()) {

				String[] data =date.split("--");
				PreparedStatement preparedStatement3 =conn.prepareStatement(SQL_USER_SearchPeccantTs);
			       //����sql������
				preparedStatement3.setString(1, PSNumber);
				preparedStatement3.setString(2, data[0]);
				preparedStatement3.setString(3, data[1]);
				
				ResultSet result3 = preparedStatement3.executeQuery();
				String res = null ;
				while(result3.next()) {
				String name=result3.getString("Υ����");
				String count =result3.getString("COUNT(Υ����)");

				if(res!=null)
				   res=res+name+count+'\n';
				else
					res=name+count+'\n';
				}
				return res;
			}	
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return null;

	}

}

package com.tjl.dao;

import com.tjl.bean.*;



public interface UserDao {

	/**���Ա��
	 * @author 86136
	 *����ֵ true ��ӳɹ���falseʧ��
	 */
	boolean EnterDriver(Staff driver);
	
	/**��ӳ���
	 * @param car
	 * @return true ��ӳɹ���falseʧ��
	 */
	boolean EnterCar(Car car);
	
	/**���Υ�¼�¼
	 * @param peccant
	 * @return true ��ӳɹ���falseʧ��
	 */
	boolean EnterSPeccant(Peccant peccant);
	
	/**��ѯԱ����Ϣ
	 * @param Number
	 * @return staff,��ѯĿ����Ϣ,��Ϊnull,��ʾ��ѯĿ�겻���ڻ��ѯ��Ȩ�޲���
	 */
	Staff SearchDriver(String Number,String Number2);
	
	/**��ѯʱ�����Υ�¼�¼
	 * @param PSNumber ����ѯ��Ա����
	 * @param SNumber ��ѯ��Ա����
	 * @param data ��ѯʱ������
	 * return ����һ���ַ������������в�ѯ������Ϣ
	 */
	String SearchPeccant(String PSNumber,String SNumber,String data);

	/**��ѯʱ�����Υ�´���
	 * @param PSNumber ����ѯ��Ա����
	 * @param SNumber ��ѯ��Ա����
	 * @param data ��ѯʱ������
	 */
	String SearchPeccantTs(String PSNumber,String SNumber,String data);
}

package com.tjl.dao;

import com.tjl.bean.*;



public interface UserDao {

	/**添加员工
	 * @author 86136
	 *返回值 true 添加成公，false失败
	 */
	boolean EnterDriver(Staff driver);
	
	/**添加车辆
	 * @param car
	 * @return true 添加成公，false失败
	 */
	boolean EnterCar(Car car);
	
	/**添加违章记录
	 * @param peccant
	 * @return true 添加成公，false失败
	 */
	boolean EnterSPeccant(Peccant peccant);
	
	/**查询员工信息
	 * @param Number
	 * @return staff,查询目标信息,或为null,表示查询目标不存在或查询者权限不足
	 */
	Staff SearchDriver(String Number,String Number2);
	
	/**查询时间段内违章记录
	 * @param PSNumber 被查询者员工号
	 * @param SNumber 查询者员工号
	 * @param data 查询时间区间
	 * return 返回一个字符串，包含所有查询到的信息
	 */
	String SearchPeccant(String PSNumber,String SNumber,String data);

	/**查询时间段内违章次数
	 * @param PSNumber 被查询者员工号
	 * @param SNumber 查询者员工号
	 * @param data 查询时间区间
	 */
	String SearchPeccantTs(String PSNumber,String SNumber,String data);
}

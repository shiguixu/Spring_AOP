/*
*www.dyr.com
*Copyright(c)2014 All Rights Reserved.
*/
/**
 * 
 */
package service;

import java.util.List;

import dao.UserDao;
import entity.Qx;
import entity.Role;
import entity.User;

/**
 * Project:Spring_AOP
 * package:service
 * FileName:UserService.java
 * Comments:
 * JDK  Version:
 * Author:Casper
 * Create Date:2015-3-5 下午2:58:39
 * Modified By:Casper
 * Modified Time:
 * What is Modified:
 * Version:
 */
public class UserService {
	
	
	
	private UserDao userDao;

	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 *@author Casper
	 *Create Time:2015-3-5 下午3:33:04
	 * Description:
	 * @param uname
	 * @param upswd
	 * @return
	 */
	public User getUserByNameAndPswd(String uname, String upswd) {
		User user=userDao.selectUserByNameAndPswd(uname,upswd);
		return user;
	}

	/**
	 *@author Casper
	 *Create Time:2015-3-5 下午4:27:00
	 * Description:
	 * @return
	 */
	public List<User> getUser() {
		List<User> users=userDao.selectUser();
		return users;
	}

	/**
	 *@author Casper
	 *Create Time:2015-3-5 下午4:57:46
	 * Description:
	 * @param urid
	 * @return
	 */
	public List<Qx> getQxByRid(int rid) {
		List<Qx> qxs=userDao.selectQxByRid(rid);
		return qxs;
	}

	/**
	 *@author Casper
	 *Create Time:2015-3-5 下午5:19:37
	 * Description:
	 * @param uname
	 * @param upswd
	 * @param urid
	 * @return
	 */
	public int addUser(String uname, String upswd, String urid) {
		System.out.println("增加了一个用户");
		return 1;
	}

	/**
	 *@author Casper
	 *Create Time:2015-3-5 下午5:19:09
	 * Description:
	 * @param uname
	 * @param upswd
	 * @param urid
	 */

}

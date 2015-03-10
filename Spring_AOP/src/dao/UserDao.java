/*
*www.dyr.com
*Copyright(c)2014 All Rights Reserved.
*/
/**
 * 
 */
package dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import entity.Qx;
import entity.Role;
import entity.User;

/**
 * Project:Spring_AOP
 * package:dao
 * FileName:UserDao.java
 * Comments:
 * JDK  Version:
 * Author:Casper
 * Create Date:2015-3-5 下午2:59:33
 * Modified By:Casper
 * Modified Time:
 * What is Modified:
 * Version:
 */
public interface UserDao {

	/**
	 *@author Casper
	 *Create Time:2015-3-5 下午3:33:59
	 * Description:
	 * @param uname
	 * @param upswd
	 * @return
	 */
	@Select("select * from role where rid=#{rid}")
	public Role selectRoleByRid(int rid);
	
	@Select("select * from [user] where uname=#{uname} and upswd=#{upswd}")
	@Results({
		@Result(column="urid",property="urid",one=@One(select="dao.UserDao.selectRoleByRid"))
	})
	public User selectUserByNameAndPswd(@Param("uname")String uname,@Param("upswd") String upswd);

	/**
	 *@author Casper
	 *Create Time:2015-3-5 下午4:27:28
	 * Description:
	 * @return
	 */
	@Select("select * from [user] ")
	@Results({
		@Result(column="urid",property="urid",one=@One(select="dao.UserDao.selectRoleByRid"))
	})
	public List<User> selectUser();

	/**
	 *@author Casper
	 *Create Time:2015-3-5 下午4:58:51
	 * Description:
	 * @param urid
	 * @return
	 */
	@Select("select * from qx where qid in (select qid from roleqx where rid=#{rid})")
	public List<Qx> selectQxByRid(int rid);

}

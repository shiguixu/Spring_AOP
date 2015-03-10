/*
*www.dyr.com
*Copyright(c)2014 All Rights Reserved.
*/
/**
 * 
 */
package entity;

/**
 * Project:Spring_AOP
 * package:entity
 * FileName:User.java
 * Comments:
 * JDK  Version:
 * Author:Casper
 * Create Date:2015-3-5 ÏÂÎç2:47:06
 * Modified By:Casper
 * Modified Time:
 * What is Modified:
 * Version:
 */
public class User {
	private int uid;
	private String uname;
	private String upswd;
	private Role urid;
	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * @return the upswd
	 */
	public String getUpswd() {
		return upswd;
	}
	/**
	 * @param upswd the upswd to set
	 */
	public void setUpswd(String upswd) {
		this.upswd = upswd;
	}
	/**
	 * @return the urid
	 */
	public Role getUrid() {
		return urid;
	}
	/**
	 * @param urid the urid to set
	 */
	public void setUrid(Role urid) {
		this.urid = urid;
	}
}

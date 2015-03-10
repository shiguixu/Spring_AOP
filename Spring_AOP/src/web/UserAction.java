/*
*www.dyr.com
*Copyright(c)2014 All Rights Reserved.
*/
/**
 * 
 */
package web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Qx;
import entity.User;

import service.UserService;

/**
 * Project:Spring_AOP
 * package:web
 * FileName:UserAction.java
 * Comments:
 * JDK  Version:
 * Author:Casper
 * Create Date:2015-3-5 ÏÂÎç2:59:51
 * Modified By:Casper
 * Modified Time:
 * What is Modified:
 * Version:
 */
public class UserAction extends ActionSupport {
	
	public String tologin(){
		
		return SUCCESS;
	}
	
	public String login(){
		User user=userService.getUserByNameAndPswd(uname,upswd);
		if(user!=null){
			session.setAttribute("user", user);
			return SUCCESS;
		}
		else{
			ActionContext.getContext().put("tip", "*µÇÂ¼Ê§°Ü£¡");
			return INPUT;
		}
	}
	public String show(){
		List<User> users=userService.getUser();
		request.setAttribute("users", users);
		
		return SUCCESS;
	}
	
	public String deleteuser(){
		return SUCCESS;
	}	
	
	public String adduser(){
		int result= userService.addUser(uname,upswd,urid);
		return SUCCESS;
	}
	
	private HttpServletRequest request=ServletActionContext.getRequest();
	private HttpSession session=request.getSession();
	private UserService userService;
	private String uname;
	private String upswd;
	private String urid;
	/**
	 * @return the urid
	 */
	public String getUrid() {
		return urid;
	}

	/**
	 * @param urid the urid to set
	 */
	public void setUrid(String urid) {
		this.urid = urid;
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
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}

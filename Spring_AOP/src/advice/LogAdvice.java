/*
*www.dyr.com
*Copyright(c)2014 All Rights Reserved.
*/
/**
 * 
 */
package advice;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;

import service.UserService;

import com.opensymphony.xwork2.ActionContext;

import dao.UserDao;

import entity.Qx;
import entity.User;

/**
 * Project:Spring_AOP
 * package:advice
 * FileName:LogAdvice.java
 * Comments:
 * JDK  Version:
 * Author:Casper
 * Create Date:2015-3-5 ����4:12:17
 * Modified By:Casper
 * Modified Time:
 * What is Modified:
 * Version:
 */
public class LogAdvice {
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		User user= (User) ActionContext.getContext().getSession().get("user");
		boolean flag=false;
		if(user!=null){
			List<Qx> qxs=userService.getQxByRid(user.getUrid().getRid());
			for (Qx qx : qxs) {
				if(("service."+qx.getQway()).equals(pjp.getTarget().getClass().getName()+"-"+pjp.getSignature().getName())){
					flag=true;
				}
			}
		}
		
		System.out.println("����֪ͨ��ʼ����" + pjp.getTarget().getClass().getName() + " - " + pjp.getSignature().getName());
		long time1 = System.currentTimeMillis();
		
		//ִ��ʵ�ʵ�ҵ�񷽷���������ǲ�����������仰���Ϳ�����ֹʵ�ʵ�ҵ��ִ�У����ͨ������Ȩ�޿��Ʒ��棩
		
		if(flag){
			Object retVal = pjp.proceed();	return retVal;
		}
		else{
			throw new RuntimeException("û��Ȩ��");
			
		}
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
	private UserService userService;
}

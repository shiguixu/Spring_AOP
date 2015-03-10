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
 * Create Date:2015-3-5 下午4:12:17
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
		
		System.out.println("环绕通知开始……" + pjp.getTarget().getClass().getName() + " - " + pjp.getSignature().getName());
		long time1 = System.currentTimeMillis();
		
		//执行实际的业务方法（如果我们不调用下面这句话，就可以阻止实际的业务被执行，这个通常用在权限控制方面）
		
		if(flag){
			Object retVal = pjp.proceed();	return retVal;
		}
		else{
			throw new RuntimeException("没有权限");
			
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

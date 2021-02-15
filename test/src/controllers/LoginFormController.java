package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.User;
import business.LoginBusinessService;


@SuppressWarnings("deprecation")
@ManagedBean
public class LoginFormController {
	
	public LoginBusinessService loginBusinessService = new LoginBusinessService();
	
	public String onSubmit() {
		
		
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		System.out.println("You clicked the submit button");
		System.out.println("You entered the user name: " + user.getUserName());
		System.out.println("You entered the password: " + user.getPassword());
		
		//Non-SQL method
		try {
			if(loginBusinessService.validateUser(user)) {
				FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
				return "response.xhtml";
				
			}else {
				return "registration.xhtml";
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//SQL Method
		/*try {
			if(loginBusinessService.validate(user)) {
				FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
				return "response.xhtml";
				
			}else {
				return "registration.xhtml";
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//put the user object into the POST request
		//FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		//show next page
		return "login-form.xhtml";
	}
}

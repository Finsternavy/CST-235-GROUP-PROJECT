package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.User;
import dao.LoginDao;

@SuppressWarnings("deprecation")
@ManagedBean
public class LoginFormController {
	
	public LoginDao loginDao = new LoginDao();
	
	
	public String onSubmit() {
		
		//This method should check for the user in the database, if not present, direct user
		//to registration page. 
		
		
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		System.out.println("You clicked the submit button");
		System.out.println("You entered the user name: " + user.getUserName());
		System.out.println("You entered the password: " + user.getPassword());
		
		try {
			if(loginDao.validate(user)) {
				FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
				return "response.xhtml";
				
			}else {
				return "registration.xhtml";
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//put the user object into the POST request
		//FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		//show next page
		return "response.xhtml";
	}
}

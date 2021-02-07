package controllers;


import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.Database;
import beans.User;

@SuppressWarnings("deprecation")
@ManagedBean
public class RegistrationFormController {
	
	private int id = 0;
	public Database myDB = new Database();
	
	public String onSubmit() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		id = id + 1;
		myDB.registerMember(user);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		return "login-form.xhtml";
		
	}

}

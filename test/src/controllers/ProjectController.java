package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.Project;
import beans.Task;
import beans.User;

@SuppressWarnings("deprecation")
@ManagedBean
public class ProjectController {
	
	
	Project project = new Project();

	public String createTask() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		Task task = context.getApplication().evaluateExpressionGet(context, "#{task}", Task.class);
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		project.allTasks.add(task);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "response.xhtml";
	}
}

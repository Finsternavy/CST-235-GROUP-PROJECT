package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

@SuppressWarnings("deprecation")
@ManagedBean
public class Project {

	public Project(String name) {
		this.name = name;
		allTasks = new ArrayList<Task>();
		hotItems = new ArrayList<Task>();
		ComingDue = new ArrayList<Task>();
		ideas = new ArrayList<Task>();
	}
	
	public Project() {
		allTasks = new ArrayList<Task>();
		hotItems = new ArrayList<Task>();
		ComingDue = new ArrayList<Task>();
		ideas = new ArrayList<Task>();
		
	}
	
	private String name;
	private String description;
	private Date duedate;
	private int tasksActive;
	private int tasksCompleted;
	private int percentCompete;
	
	public List<Task> allTasks;
	public List<Task> hotItems;
	public List<Task> ComingDue;
	public List<Task> ideas;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public int getTasksActive() {
		return tasksActive;
	}
	public void setTasksActive(int tasksActive) {
		this.tasksActive = tasksActive;
	}
	public int getTasksCompleted() {
		return tasksCompleted;
	}
	public void setTasksCompleted(int tasksCompleted) {
		this.tasksCompleted = tasksCompleted;
	}
	public int getPercentCompete() {
		return percentCompete;
	}
	public void setPercentCompete(int percentCompete) {
		this.percentCompete = percentCompete;
	}
	public List<Task> getAllTasks() {
		return allTasks;
	}
	public void setAllTasks(List<Task> allTasks) {
		this.allTasks = allTasks;
	}
	public List<Task> getHotItems() {
		return hotItems;
	}
	public void setHotItems(List<Task> hotItems) {
		this.hotItems = hotItems;
	}
	public List<Task> getComingDue() {
		return ComingDue;
	}
	public void setComingDue(List<Task> comingDue) {
		ComingDue = comingDue;
	}
	public List<Task> getIdeas() {
		return ideas;
	}
	public void setIdeas(List<Task> ideas) {
		this.ideas = ideas;
	}
	
	
	
}

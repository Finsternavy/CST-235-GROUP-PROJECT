package beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@SuppressWarnings("deprecation")
@ManagedBean
@ApplicationScoped
public class Project {

	public Project(String name, String description, String dueDate, int tasksActive, int tasksCompleted, int percentComplete) {
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.tasksActive = tasksActive;
		this.tasksCompleted = tasksCompleted;
		this.percentCompete = percentComplete;
		
		
	}
	
	public Project() {
		
	}

	public List<Task> taskHashMapList = new ArrayList<Task>();

	private String name;
	private String description;
	private String dueDate;
	private int tasksActive;
	private int tasksCompleted;
	private int percentCompete;
	private String choice = "";
	private int choiceInt = 0;
	
	
	int keyValue = 0;
	
	public static HashMap<String, Task> tasks = new HashMap<String, Task>();
	
	public int keyValue() {
		return this.keyValue;
	}
	
	public void setKeyValue(int key) {
		this.keyValue = key;
	}
	
	

	public String getChoice() {
		return this.choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	
	
	public int getChoiceInt() {
		return choiceInt;
	}

	public void setChoiceInt(int choiceInt) {
		this.choiceInt = choiceInt;
	}

	public boolean validateIsNew(Task task) {
		
		String checkTaskName = task.getName();
		
		boolean isNew = true;
		
		for(String s: tasks.keySet()) {
			String taskName = tasks.get(s).getName();
			if(taskName.equals(checkTaskName)) {
			
				isNew = false;
				return isNew;
				
			}
		}
		
		return isNew;
	}
	
	public void addTask(Task task) {
		
		this.keyValue = this.keyValue + 1;
		
		String keyString = String.valueOf(this.keyValue);
	
		tasks.put(keyString, task);
	}
	
	public void removeTask(String taskToRemoved) {
		
		boolean taskFound = false;
		
		for (String s: tasks.keySet()) {
			String taskName = tasks.get(s).getName();
			if(taskName.equals(taskToRemoved)) {
				taskFound = true;
				tasks.remove(s);
				System.out.println("Task was removed!");
				break;
			}
		}
		
		if(taskFound) {
			System.out.println("Task was removed!");
		}else {
			
			System.out.println("Task not found! No task was removed!");
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(String s: tasks.keySet()) {
			sb.append("Task Name: " + tasks.get(s).getName() + " Task Description: " + tasks.get(s).getDescription() 
					+ " Due Date: " + tasks.get(s).getDueDate() + " Assigned to: " + tasks.get(s).getMemberAssigned() + " Approved?: " +  
					tasks.get(s).getApproved() + "\n");
		}
		
		return sb.toString();
	}
	
	public static HashMap<String, Task> getTasks() {
		return tasks;
	}
	

	public static void setTasks(HashMap<String, Task> tasks) {
		Project.tasks = tasks;
	}
	
	
	public void setChoiceIntManual(String choice) {
		
		if(this.choice == null) {
			this.setChoice("All Tasks");
		}
		if(this.choice.equals("All Tasks")) {
			this.choiceInt = 0;
		}else if(this.choice.equals("Past Due")) {
			this.choiceInt = 1;
		}else if(this.choice.equals("Coming Due")) {
			this.choiceInt = 2;
		}else if(this.choice.equals("Unassigned")) {
			this.choiceInt = 3;
		}else if(this.choice.equals("Assigned")){
			this.choiceInt = 4;
		}else if(this.choice.equals("Approved")){
			this.choiceInt = 5;
		}else if(choice.equals("Not Approved")){
			this.choiceInt = 6;
		}else {
			this.choiceInt = 0;
		}
		
	}
	
	public List<Task> hashMapToList() {
		
		this.setChoiceIntManual(choice);
		
		
		switch(this.getChoiceInt()) {
		
		//ALLTASKS
		case 0: 		taskHashMapList.clear();
						for(String s: Project.tasks.keySet()) {
						taskHashMapList.add(tasks.get(s));
						}
	
						return taskHashMapList;
		//PASTDUE				
		case 1:			taskHashMapList.clear();
	
						for(String s: Project.tasks.keySet()) {

							if((tasks.get(s).getDueDate().calculateTotalDaysFromToday() > 0)) {
								taskHashMapList.add(tasks.get(s));
							}
						}
						
	
						return taskHashMapList;
		//COMINGDUE				
		case 2:			taskHashMapList.clear();
		
						for(String s: Project.tasks.keySet()) {

							if((tasks.get(s).getDueDate().calculateTotalDaysFromToday() < 0)) {
								taskHashMapList.add(tasks.get(s));
							}
						}
		

		return taskHashMapList;
		//UNASSIGNED				
		case 3:			taskHashMapList.clear();
						for(String s: Project.tasks.keySet()) {
							if(tasks.get(s).getMemberAssigned().equals("")){
								taskHashMapList.add(tasks.get(s));
							}
						}
							
						return taskHashMapList;
		//ASSIGNED			
		case 4:			taskHashMapList.clear();
						for(String s: Project.tasks.keySet()) {
							if(!tasks.get(s).getMemberAssigned().equals("")){
								taskHashMapList.add(tasks.get(s));
							}
						}
			
						return taskHashMapList;
		//APPROVED	
		case 5:			taskHashMapList.clear();
						for(String s: Project.tasks.keySet()) {
							if(tasks.get(s).getApproved())
							taskHashMapList.add(tasks.get(s));
						}

						return taskHashMapList;
		//NOTAPPROVED	
		case 6:			taskHashMapList.clear();
						for(String s: Project.tasks.keySet()) {
							if(!tasks.get(s).getApproved())
								taskHashMapList.add(tasks.get(s));
						}

						return taskHashMapList;
						
		default:		taskHashMapList.clear();
						for(String s: Project.tasks.keySet()) {
						taskHashMapList.add(tasks.get(s));
						}

						return taskHashMapList;
						
		
		
		
		}
		
	}
	
	 
		
}



package beans;

import java.util.HashMap;

import javax.annotation.ManagedBean;

@ManagedBean
public class Database {

public Database() {
		
		
		
	}
	
	int keyValue = 0;
	
	public static HashMap<String, User> users = new HashMap<String, User>();
	
	public int keyValue() {
		return this.keyValue;
	}
	
	public void setKeyValue(int key) {
		this.keyValue = key;
	}
	
	public boolean validateIsNew(User member) {
		
		String checkUserName = member.getUserName();
		
		boolean isNew = true;
		
		for(String s: users.keySet()) {
			String memberUserName = users.get(s).getUserName();
			if(memberUserName.equals(checkUserName)) {
			
				isNew = false;
				return isNew;
				
			}
		}
		
		return isNew;
	}
	
	public void registerMember(User member) {
		
		this.keyValue = this.keyValue + 1;
		
		String keyString = String.valueOf(this.keyValue);
	
		users.put(keyString, member);
	}
	
	public void removeMember(String UserNameToBeRemoved) {
		
		boolean userFound = false;
		
		for (String s: users.keySet()) {
			String userName = users.get(s).getUserName();
			if(userName.equals(UserNameToBeRemoved)) {
				userFound = true;
				users.remove(s);
			}
		}
		
		if(userFound) {
			System.out.println("User was removed!");
		}else {
			
			System.out.println("UserName not found! No members were removed!");
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(String s: users.keySet()) {
			sb.append("ID: " + s + " First Name: " + users.get(s).getFirstName() + " Last Name: " + users.get(s).getLastName() 
					+ " User Name: " + users.get(s).getUserName() + " Password: " + users.get(s).getPassword() + " Email: " +  
					users.get(s).getEmail() + " Phone: " + users.get(s).getPhone() + "\n");
		}
		
		return sb.toString();
	}
	

}

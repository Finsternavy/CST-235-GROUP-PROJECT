package dao;

import beans.Database;
import beans.User;

public class LoginDao {
	
	public LoginDao() {
		myDB = new Database();
	}

	Database myDB; 

	public boolean validate(User user) throws ClassNotFoundException {
		
		boolean status = false;
		String message = "Incorrect User Name.  Please register or reload the page.";
		
		//For use with mySQL
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		String userName = user.getUserName();
		String userPassword = user.getPassword();
		
		for(String s: Database.users.keySet()) {
			
			String checkUserName = Database.users.get(s).getUserName();
			String checkUserPassword = Database.users.get(s).getPassword();
			if(checkUserName.equals(userName)) {
				
				if(checkUserPassword.equals(userPassword)) {
					
					message = "User name and password match found!";
					System.out.println(message);
					
					return true;
					
				}else {
					message = "Incorrect Password";
					System.out.println(message);
					return false;
					
				}
				
			}
			
		}
		
		System.out.println(message);
		
		//For use with mySQL
		/*try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/members", "root", "QAZXSWedcvfr1!");
				
				PreparedStatement preparedStatement = connection.prepareStatement("select * from member where username = ? and password = ?")){
				preparedStatement.setString(1, loginBean.getUsername());
				preparedStatement.setString(2, loginBean.getPassword());
				
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				status = rs.next();
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}*/
						
		
		return status;
	}
}

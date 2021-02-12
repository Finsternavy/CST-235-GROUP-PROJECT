package business;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Database;
import beans.User;

@Stateless
@Local(LoginBusinessInterface.class)
@Alternative
public class LoginBusinessService implements LoginBusinessInterface{

	public LoginBusinessService() {
		
	}
	
	@Override
	public boolean validateUser(User user) throws ClassNotFoundException {
		
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
					user.setFirstName(Database.users.get(s).getFirstName());
					user.setLastName(Database.users.get(s).getLastName());
					user.setEmail(Database.users.get(s).getEmail());
					user.setPhone(Database.users.get(s).getPhone());

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

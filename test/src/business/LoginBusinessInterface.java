package business;

import javax.ejb.Local;

import beans.User;

@Local
public interface LoginBusinessInterface {

	boolean validateUser(User user) throws ClassNotFoundException;
}

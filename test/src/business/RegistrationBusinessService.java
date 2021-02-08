package business;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Database;

@Stateless
@Local(RegistrationBusinessInterface.class)
@Alternative
public class RegistrationBusinessService implements RegistrationBusinessInterface {

	public RegistrationBusinessService() {
		db = new Database();
	}
	
	public Database db;
}

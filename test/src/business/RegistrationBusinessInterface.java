package business;

import javax.ejb.Local;

import beans.Database;

@Local
public interface RegistrationBusinessInterface {
	Database DB = null;
}

package nz.ac.auckland.accountmanagement;

/**
 * A simple class representing a User's credentials
 * @author Brad
 *
 */
public class User {

	private String _username;
	private String _password;
	
	public User(String username, String password) {
		_username = username;
		_password = password;
	}
	
	public String getUsername() {
		return _username;
	}
	
	public String getPassword() {
		return _password;
	}
	
}

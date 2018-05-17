package nz.ac.auckland.accountmanagement;

/**
 * A simple class representing a User's credentials
 * @author Brad
 *
 */
public class User {

	private String _username;
	private String _password;
	private int _currentActiveSearches;
	
	public User(String username, String password) {
		_username = username;
		_password = password;
		_currentActiveSearches = 0;
	}
	
	public String getUsername() {
		return _username;
	}
	
	public String getPassword() {
		return _password;
	}
	
	public void incrementSearchCount() {
		_currentActiveSearches++;
	}
	
	public int getActiveSearchCount() {
		return _currentActiveSearches;
	}
	
	public void clearActiveSearchCount() {
		_currentActiveSearches = 0;
	}
}

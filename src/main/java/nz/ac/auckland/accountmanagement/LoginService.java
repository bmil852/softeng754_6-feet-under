package nz.ac.auckland.accountmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A singleton class that manages registering users, and logging them in and out.
 * @author Brad
 *
 */
public class LoginService {
	
	private Map<UserType,List<User>> _registered;
	private Map<UserType,List<User>> _active;
	
	public LoginService() {
		_registered = new HashMap<UserType,List<User>>();
		_active = new HashMap<UserType,List<User>>();
		
		_registered.put(UserType.USER, new ArrayList<User>());
		_registered.put(UserType.ADMINISTRATOR, new ArrayList<User>());
		_active.put(UserType.USER, new ArrayList<User>());
		_active.put(UserType.ADMINISTRATOR, new ArrayList<User>());
	}
	
	public void register(User credentials, UserType userType) {
		if (credentials.getUsername() != null && credentials.getPassword() != null) {
			_registered.get(userType).add(credentials);
		}
	}
	
	public void signIn(User credentials, UserType userType) {
		for (User c : _registered.get(userType)) {
			if (c.getUsername().equals(credentials.getUsername()) && c.getPassword().equals(credentials.getPassword())) {
				_active.get(userType).add(c);
			}
		}
	}
	
	public void signOut(User credentials, UserType userType) {
		User removeMe = null;
		for (User c : _active.get(userType)) {
			if (c.getUsername().equals(credentials.getUsername()) && c.getPassword().equals(credentials.getPassword())) {
				removeMe = c;
				break;
			}
		}
		if (removeMe != null) {
			removeMe.clearActiveSearchCount();
			_active.get(userType).remove(removeMe);
		}
	}
	
	public List<String> getActive(UserType userType) {
		List<String> returnList = new ArrayList<String>();
		for (User c : _active.get(userType)) {
			returnList.add(c.getUsername());
		}
		return returnList;
	}
	
	public List<String> getRegistered(UserType userType) {
		List<String> returnList = new ArrayList<String>();
		for (User c : _registered.get(userType)) {
			returnList.add(c.getUsername());
		}
		return returnList;
	}
	
	public User getUser(String name) {
		for (User c : _registered.get(UserType.USER)) {
			if (c.getUsername().equals(name)) {
				return c;
			}
		}
		return null;
	}
	
	public int getTotalSearchCount() {
		int returnVal = 0;
		for (User c : _registered.get(UserType.USER)) {
			returnVal += c.getActiveSearchCount();
		}
		return returnVal;
	}
	
	public void refreshRegisteredUserCount() {
		//Don't need to do anything right now as no concurrency issues to deal with
	}
}

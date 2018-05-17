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
	
	private Map<UserType,List<Credentials>> _registered;
	private Map<UserType,List<Credentials>> _active;
	
	public LoginService() {
		_registered = new HashMap<UserType,List<Credentials>>();
		_active = new HashMap<UserType,List<Credentials>>();
		
		_registered.put(UserType.USER, new ArrayList<Credentials>());
		_registered.put(UserType.ADMINISTRATOR, new ArrayList<Credentials>());
		_active.put(UserType.USER, new ArrayList<Credentials>());
		_active.put(UserType.ADMINISTRATOR, new ArrayList<Credentials>());
	}
	
	public void register(Credentials credentials, UserType userType) {
		if (credentials.getUsername() != null && credentials.getPassword() != null) {
			_registered.get(userType).add(credentials);
		}
	}
	
	public void signIn(Credentials credentials, UserType userType) {
		for (Credentials c : _registered.get(userType)) {
			if (c.getUsername().equals(credentials.getUsername()) && c.getPassword().equals(credentials.getPassword())) {
				_active.get(userType).add(c);
			}
		}
	}
	
	public void signOut(Credentials credentials, UserType userType) {
		Credentials removeMe = null;
		for (Credentials c : _active.get(userType)) {
			if (c.getUsername().equals(credentials.getUsername()) && c.getPassword().equals(credentials.getPassword())) {
				removeMe = c;
				break;
			}
		}
		if (removeMe != null) {
			_active.get(userType).remove(removeMe);
		}
	}
	
	public List<String> getActive(UserType userType) {
		List<String> returnList = new ArrayList<String>();
		for (Credentials c : _active.get(userType)) {
			returnList.add(c.getUsername());
		}
		return returnList;
	}
	
	public List<String> getRegistered(UserType userType) {
		List<String> returnList = new ArrayList<String>();
		for (Credentials c : _registered.get(userType)) {
			returnList.add(c.getUsername());
		}
		return returnList;
	}
}

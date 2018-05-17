Feature: Account Management
The count of searches that have been performed by a user so far in the current session
and the total count of searches should be recorded.

	Scenario: A user performs a number of searches
	Given a User is already signed into the system
	When the User performs 3 searches
	Then the search count for that User is equal to 3
	
	Scenario: A user has not performed any searches
	Given a User is already signed into the system
	When the User performs 0 searches
	Then the search count for that User is equal to 0
	
	Scenario: A number of users perform a number of searches
	Given a total of 5 Users are already signed into the system
	When each user performs 2 searches
	Then the total search count for all Users is equal to 10
	
	Scenario: Signing out of the system resets the active search count of the User
	Given the User signs out of the system
	Then the search count for that User is equal to 0
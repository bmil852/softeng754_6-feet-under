Feature: Account Management
Administrators need to know how many users have registered.

	Scenario: One user is registered with the system
	Given a User exists in the system
	When the Administrator wants to know how many users are in the system
	Then the total number of users returned is 1
	
	Scenario: No users are registered with the system
	Given No users are yet registered with the system
	When the Administrator wants to know how many users are in the system
	Then the total number of users returned is 0
	
	Scenario: A number of users are registered with the system
	Given a total of 5 Users are already signed into the system
	When the Administrator wants to know how many users are in the system
	Then the total number of users returned is 5
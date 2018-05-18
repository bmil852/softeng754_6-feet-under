Feature: Business Idea Keyword Extraction - Keyword Prioritisation
Users can prioritise the keywords by changing the weights or order of the keywords.

	Scenario: User changes the weight of a keyword
	Given a User already has a number of keywords returned
	When the User requests to change the weight of keyword 1 to 4
	Then the weight of keyword 1 is updated to 4
	
	Scenario: User changes the weight of all keywords
	Given a User already has a number of keywords returned
	When the User requests to change the weight of all keywords to 5
	Then the weight of all keywords are equal to 5
	
	Scenario: User changes the weight of a keyword to an invalid value - zero
	Given a User already has a number of keywords returned
	When the User requests to change the weight of keyword 1 to 0
	Then the weight of keyword 1 is not updated to 0
	
	Scenario: User changes the order of keywords
	Given a User already has a number of keywords returned
	When the User swaps the order of keywords 1 and 3
	Then the keyword that was in position 1 is now in position 3
	And the keyword that was in position 3 is now in position 1
	And the total number of keywords is unchanged
	
	Scenario: User changes the order of a keyword with an invalid value - zero
	Given a User already has a number of keywords returned
	When the User swaps the order of keywords 1 and 0
	Then all the keywords are in the same place as before
	And the total number of keywords is unchanged
Feature: Business Idea Keyword Extraction - Add and Remove Keywords
Users can inject or remove keywords from the keyword list.

	Scenario: User adds a valid keyword to the keyword list
	Given a User already has a number of keywords returned
	When the User requests to add the keyword "testNewKeyword" to the list
	Then the keyword list contains the keyword "testNewKeyword"
	
	Scenario: User tries to add an invalid (empty) keyword to the keyword list
	Given a User already has a number of keywords returned
	When the User requests to add the keyword "" to the list
	Then the total number of keywords is unchanged
	
	Scenario: User tries to remove an existing keyword from the list
	Given a User already has a number of keywords returned
	When the User tries to remove keyword 1 from the list
	Then all the keywords except keyword 1 remain in the list
	
	Scenario: User tries to remove a non existing keyword from the list
	Given a User already has a number of keywords returned
	When the User tries to remove a keyword from the list that does not exist
	Then all the keywords are in the same place as before
	And the total number of keywords is unchanged
	
	
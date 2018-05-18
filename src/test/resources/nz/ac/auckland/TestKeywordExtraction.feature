Feature: Business Idea Keyword Extraction
Users input their business idea in the form of text, and the application can extract a few
keywords from the input text.

	Scenario: User enters empty text (i.e. does not enter a business idea)
	Given the User wants to input their business idea to the system
	When the User enters their business idea as ""
	Then the System will extract no keywords from the business idea
	
	Scenario: User enters a business idea
	Given the User wants to input their business idea to the system
	When the User enters their business idea as "My mock business idea is a dog walking service in Ponsonby"
	Then the System will extract a number of keywords from the business idea
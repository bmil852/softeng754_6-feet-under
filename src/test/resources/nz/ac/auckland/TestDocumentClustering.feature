Feature: Market Comprehension
The returned documents should be clustered into a few categories.

	Scenario: A user would like search results to be clustered into categories
	Given a User has a set of weighted keywords to search for
	When the User performs a search
	Then the set of documents returned will be clustered into a few categories
Feature: Market Comprehension
The weighted keywords should be used as the input to a traditional search engine, 
and a set of documents are expected to be returned.

	Scenario: A user searches their business idea
	Given a User has a set of weighted keywords to search for
	When the User performs a search
	Then a non-empty set of documents will be returned
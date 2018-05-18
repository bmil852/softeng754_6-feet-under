Feature: Business Idea Validation - Category Popularity
The application should assign a weight to each category as its popularity. The weight can
be computed as the proportion of the associated documents of a category within the total
returned documents from the search. For example, we have 100 returned documents
which have been clustered into 3 categories (C1, C2, C3). Assuming that C1 contains 50
documents, C2 contains 30 documents and C3 contains 20, the popularities for C1, C2,
and C3 will be 50 percent, 30 percent and 20 percent, respectively.

	Scenario: The user wants to know about category popularity
	Given the search results have returned an example set of documents as described
	When the popularity of each category is processed
	Then category 1 should have a popularity of 50 percent
	And category 2 should have a popularity of 30 percent
	And category 3 should have a popularity of 20 percent
	
	Scenario: A category popularity of 0 exists
	Given the search results have returned an example set of documents as described
	And an additional fourth category with no documents exists
	When the popularity of each category is processed
	Then category 4 should have a popularity of 0 percent
Feature: Business Idea Validation - Category Relevance
Users can set the relevance of each category to their ideas

	Scenario Outline: User sets the relevance of a category to <Category>
	Given the search results have returned an example set of documents as described
	When the user selects the relevance of category 1 to <Category>
	Then the relevance of category 1 will be equal to <Category>
	
	Examples:
	|  Category     |
	| NOT_RELEVANT  |
	| WEAK_RELEVANT |
	| RELEVANT      |
	| VERY_RELEVAT  |
	| THE SAME      |
	
	Scenario Outline: User sets the relevance of all categories to <Category>
	Given the search results have returned an example set of documents as described
	When the user selects the relevance of all categories to <Category>
	Then the relevance of all categories will be equal to <Category>
	
	Examples:
	|  Category     |
	| NOT_RELEVANT  |
	| WEAK_RELEVANT |
	| RELEVANT      |
	| VERY_RELEVAT  |
	| THE SAME      |
	
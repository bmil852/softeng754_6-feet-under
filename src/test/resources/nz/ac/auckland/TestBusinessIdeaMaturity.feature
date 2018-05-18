Feature: Business Validation - Overall Maturity of Business Idea
Users can obtain the maturity of the business idea in the market via aggregating the
popularity weights and the relevance values/levels of each category. This is achieved by
adding the products of the popularity weight and relevance values. The sum will be
the degree of the maturity, an indicator for the users to overview the market. Continuing
the example in 12) and assuming a user the relevance values for C1, C2 and C3 as 1,
0 and 0.5, respectively, the maturity can be calculated as 0.5*1+0.3*0+0.2*0.5 = 0.6.

	Scenario: The user gets the overall maturity of the business idea
	Given the search results have returned an example set of documents as described
	When the user sets the relevance of category 1 to THE_SAME
	And the user sets the relevance of category 2 to NOT_RELEVANT
	And the user sets the relevance of category 3 to RELEVANT
	Then the overall maturity for the business idea will be 0.6
package nz.ac.auckland.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BusinessIdeaStepDefs {
	
	KeywordExtractor _keywordExtractor;
	List<Keyword> _keywords;
	
	@Given("^the User wants to input their business idea to the system$")
	public void the_User_wants_to_input_their_business_idea_to_the_system() throws Exception {
	    List<Keyword> extractedKeywordsPopulated = new ArrayList<Keyword>();
	    extractedKeywordsPopulated.add(new Keyword("Dog", 0.4));
	    extractedKeywordsPopulated.add(new Keyword("Walking", 0.5));
	    extractedKeywordsPopulated.add(new Keyword("Ponsonby", 0.6));
	    
	    _keywordExtractor = mock(KeywordExtractor.class);
	    when(_keywordExtractor.extractFrom("")).thenReturn(new ArrayList<Keyword>());
	    when(_keywordExtractor.extractFrom("A dog walking service in Ponsonby")).thenReturn(extractedKeywordsPopulated);
	}

	@When("^the User enters their business idea as \"([^\"]*)\"$")
	public void the_User_enters_their_business_idea_as(String arg1) throws Exception {
	    _keywords = _keywordExtractor.extractFrom(arg1);
	}

	@Then("^the System will extract (no|a number of) keywords from the business idea$")
	public void the_System_will_extract_no_keywords_from_the_business_idea(String howMany) throws Exception {
	    int expectedKeywordListSize = (howMany.equals("no")) ? 0 : 3;
	    assertThat(_keywords.size(), equalTo(expectedKeywordListSize));
	}
	
}

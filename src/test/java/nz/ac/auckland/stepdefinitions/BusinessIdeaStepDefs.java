package nz.ac.auckland.stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.ac.auckland.businessidea.Keyword;
import nz.ac.auckland.businessidea.KeywordExtractor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class BusinessIdeaStepDefs {
	
	KeywordExtractor _keywordExtractor;
	List<Keyword> _keywords;
	
	@Given("^the User wants to input their business idea to the system$")
	public void the_User_wants_to_input_their_business_idea_to_the_system() throws Exception {
	    List<Keyword> extractedKeywordsPopulated = new ArrayList<Keyword>();
	    extractedKeywordsPopulated.add(new Keyword("Dog", 3));
	    extractedKeywordsPopulated.add(new Keyword("Walking", 4));
	    extractedKeywordsPopulated.add(new Keyword("Ponsonby", 5));
	    
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
	
	@Given("^a User already has a number of keywords returned$")
	public void a_User_already_has_a_number_of_keywords_returned() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the User requests to change the weight of keyword (\\d+) to (\\d+)$")
	public void the_User_requests_to_change_the_weight_of_keyword_to(int arg1, int arg2) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the weight of keyword (\\d+) (is|is not) updated to (\\d+)$")
	public void the_weight_of_keyword_is_updated_to(int arg1, String success, int arg2) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the User requests to change the weight of all keywords to (\\d+)$")
	public void the_User_requests_to_change_the_weight_of_all_keywords_to(int arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the weight of all keywords are equal to (\\d+)$")
	public void the_weight_of_all_keywords_are_equal_to(int arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the User swaps the order of keywords (\\d+) and (\\d+)$")
	public void the_User_swaps_the_order_of_keywords_and(int arg1, int arg2) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the keyword that was in position (\\d+) is now in position (\\d+)$")
	public void the_keyword_that_was_in_position_is_now_in_position(int arg1, int arg2) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the total number of keywords is unchanged$")
	public void the_total_number_of_keywords_is_unchanged() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^all the keywords are in the same place as before$")
	public void all_the_keywords_are_in_the_same_place_as_before() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}

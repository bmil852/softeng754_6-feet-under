package nz.ac.auckland.stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.ac.auckland.keywordextraction.KeywordService;
import nz.ac.auckland.keywordextraction.Keyword;
import nz.ac.auckland.keywordextraction.KeywordExtractor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.hamcrest.CoreMatchers.equalTo;

public class KeywordExtractionStepDefs {
	
	private KeywordService _keywordService;
	List<Keyword> _previousKeywords;
	
	@Given("^the User wants to input their business idea to the system$")
	public void the_User_wants_to_input_their_business_idea_to_the_system() {
		initializeKeywordServiceWithMockKeywordExtractor();
	}

	@When("^the User enters their business idea as \"([^\"]*)\"$")
	public void the_User_enters_their_business_idea_as(String arg1) {
	    _keywordService.extractFrom(arg1);
	}

	@Then("^the System will extract (no|a number of) keywords from the business idea$")
	public void the_System_will_extract_no_keywords_from_the_business_idea(String howMany) {
	    int expectedKeywordListSize = (howMany.equals("no")) ? 0 : 3;
	    assertThat(_keywordService.getKeywords().size(), equalTo(expectedKeywordListSize));
	}
	
	@Given("^a User already has a number of keywords returned$")
	public void a_User_already_has_a_number_of_keywords_returned() {
		initializeKeywordServiceWithMockKeywordExtractor();
		_keywordService.extractFrom("A dog walking service in Ponsonby");
		List<Keyword> extractedKeywords = _keywordService.getKeywords();
		_previousKeywords = new ArrayList<Keyword>();
		for (Keyword k : extractedKeywords) {
			_previousKeywords.add(k);
		}
	}

	@When("^the User requests to change the weight of keyword (\\d+) to (\\d+)$")
	public void the_User_requests_to_change_the_weight_of_keyword_to(int arg1, int arg2) {
	    _keywordService.updateWeight(arg1, arg2);
	}

	@Then("^the weight of keyword (\\d+) (is|is not) updated to (\\d+)$")
	public void the_weight_of_keyword_is_updated_to(int arg1, String success, int arg2) {
	    boolean isUpdated = success.equals("is");
	    assertThat(_keywordService.getKeywords().get(arg1-1).getWeight() == arg2, equalTo(isUpdated));
	}

	@When("^the User requests to change the weight of all keywords to (\\d+)$")
	public void the_User_requests_to_change_the_weight_of_all_keywords_to(int arg1) {
	    int keywordsTotal = _keywordService.getKeywords().size();
	    for (int i = 1; i <= keywordsTotal; i++) {
	    	_keywordService.updateWeight(i, arg1);
	    }
	}

	@Then("^the weight of all keywords are equal to (\\d+)$")
	public void the_weight_of_all_keywords_are_equal_to(int arg1) {
		List<Keyword> keywords = _keywordService.getKeywords();
	    for (Keyword k : keywords) {
	    	assertThat(k.getWeight(), equalTo(arg1));
	    }
	}

	@When("^the User swaps the order of keywords (\\d+) and (\\d+)$")
	public void the_User_swaps_the_order_of_keywords_and(int arg1, int arg2) {
	    _keywordService.swapOrder(arg1, arg2);
	}

	@Then("^the keyword that was in position (\\d+) is now in position (\\d+)$")
	public void the_keyword_that_was_in_position_is_now_in_position(int arg1, int arg2) {
		List<Keyword> newKeywords = _keywordService.getKeywords();
	    assertThat(_previousKeywords.get(arg1-1), equalTo(newKeywords.get(arg2-1)));
	}

	@Then("^the total number of keywords is unchanged$")
	public void the_total_number_of_keywords_is_unchanged() {
		List<Keyword> newKeywords = _keywordService.getKeywords();
		assertThat(_previousKeywords.size(), equalTo(newKeywords.size()));
	}

	@Then("^all the keywords are in the same place as before$")
	public void all_the_keywords_are_in_the_same_place_as_before() {
		List<Keyword> newKeywords = _keywordService.getKeywords();
		for (int i = 0; i < newKeywords.size(); i++) {
			assertThat(newKeywords.get(i), equalTo(_previousKeywords.get(i)));
		}
	}
	
	@When("^the User requests to add the keyword \"([^\"]*)\" to the list$")
	public void the_User_requests_to_add_the_keyword_to_the_list(String arg1) {
	    _keywordService.addKeyword(arg1, 1);
	}

	@Then("^the keyword list contains the keyword \"([^\"]*)\"$")
	public void the_keyword_list_contains_the_keyword(String arg1) {
		boolean found = false;
		List<Keyword> newKeywords = _keywordService.getKeywords();
		for (Keyword k : newKeywords) {
			if (k.getWord().equals(arg1)) {
				found = true;
			}
		}
		assertThat(found, equalTo(true));
	}

	@When("^the User tries to remove keyword (\\d+) from the list$")
	public void the_User_tries_to_remove_keyword_from_the_list(int arg1) {
	    _keywordService.removeKeyword(arg1);
	}

	@Then("^all the keywords except keyword (\\d+) remain in the list$")
	public void all_the_keywords_except_keyword_remain_in_the_list(int arg1) {
		List<Keyword> newKeywords = _keywordService.getKeywords();
		Keyword removedWord = _previousKeywords.get(arg1-1);
		for (Keyword k : _previousKeywords) {
			if (!(k.equals(removedWord))) {
				assertThat(newKeywords.contains(k), equalTo(true));
			}
		}
		assertFalse(newKeywords.contains(removedWord));
	}

	@When("^the User tries to remove a keyword from the list that does not exist$")
	public void the_User_tries_to_remove_a_keyword_from_the_list_that_does_not_exist() {
	    int invalidIndex = _keywordService.getKeywords().size() + 1;
	    _keywordService.removeKeyword(invalidIndex);
	}
	
	private void initializeKeywordServiceWithMockKeywordExtractor() {
		List<Keyword> extractedKeywordsPopulated = new ArrayList<Keyword>();
	    extractedKeywordsPopulated.add(new Keyword("Dog", 3));
	    extractedKeywordsPopulated.add(new Keyword("Walking", 4));
	    extractedKeywordsPopulated.add(new Keyword("Ponsonby", 5));
	    
	    KeywordExtractor _keywordExtractor = mock(KeywordExtractor.class);
	    when(_keywordExtractor.extractFrom("")).thenReturn(new ArrayList<Keyword>());
	    when(_keywordExtractor.extractFrom("A dog walking service in Ponsonby")).thenReturn(extractedKeywordsPopulated);
	    _keywordService = new KeywordService(_keywordExtractor);
	}
}

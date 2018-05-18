package nz.ac.auckland.stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.ac.auckland.businessidea.Keyword;

public class MarketComprehensionStepDefs {

	private List<Keyword> _finalKeywords;
	private MarketService _marketService;
	
	@Given("^a User has a set of weighted keywords to search for$")
	public void a_User_has_a_set_of_weighted_keywords_to_search_for() throws Exception {
		List<Keyword> finalKeywords = new ArrayList<Keyword>();
	    finalKeywords.add(new Keyword("Dog", 3));
	    finalKeywords.add(new Keyword("Walking", 4));
	    finalKeywords.add(new Keyword("Ponsonby", 5));
	    _finalKeywords = finalKeywords;
		initializeMarketServiceWithMockAPICommunicator();
	}

	@When("^the User performs a search$")
	public void the_User_performs_a_search() throws Exception {
	    _marketService.performSearch(_finalKeywords);
	}

	@Then("^a non-empty set of documents will be returned$")
	public void a_non_empty_set_of_documents_will_be_returned() throws Exception {
	    assertThat(_marketService.getSearchResults().size() > 0, equalTo(true));
	}
	
	private void initializeMarketServiceWithMockAPICommunicator() {
		List<Document> documents = new ArrayList<Document>();
		for (int i = 0; i < 100; i++) {
			documents.add(new Document("Mock text for a document object"));
		}
		
		APICommunicator apiCommunicator = mock(APICommunicator.class);
		when(apiCommunicator.callAllAPIs(anyObject())).thenReturn(documents);
		_marketService = new MarketService(apiCommunicator);
	}
	
}

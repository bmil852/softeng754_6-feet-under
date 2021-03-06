package nz.ac.auckland.stepdefinitions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.ac.auckland.keywordextraction.Keyword;
import nz.ac.auckland.marketcomprehension.APICommunicator;
import nz.ac.auckland.marketcomprehension.Category;
import nz.ac.auckland.marketcomprehension.Document;
import nz.ac.auckland.marketcomprehension.MarketService;

public class MarketComprehensionStepDefs {

	private MarketService _marketService;
	
	@Given("^a User has a set of weighted keywords to search for$")
	public void a_User_has_a_set_of_weighted_keywords_to_search_for() {
		initializeMarketServiceWithMockAPICommunicator();
	}

	@When("^the User performs a search$")
	public void the_User_performs_a_search() {
	    _marketService.searchAndProcess(new ArrayList<Keyword>());
	}

	@Then("^a non-empty set of documents will be returned$")
	public void a_non_empty_set_of_documents_will_be_returned() {
	    assertThat(_marketService.getSearchResults().size() > 0, equalTo(true));
	}
	
	@Then("^the set of documents returned will be clustered into a few categories$")
	public void the_set_of_documents_returned_will_be_clustered_into_a_few_categories() {
	    assertTrue(_marketService.getResultCategories().size() > 0);
	}
	
	@Then("^there will be a label for each category in the results$")
	public void there_will_be_a_label_for_each_category_in_the_results() {
	    for (Category c : _marketService.getResultCategories()) {
	    	assertThat(c.getLabel(), not(equalTo(null)));
	    }
	}

	@Then("^the label for each category will be concise$")
	public void the_label_will_be_concise() {
		for (Category c : _marketService.getResultCategories()) {
	    	assertTrue(c.getLabel().toCharArray().length < 140);
	    }
	}
	
	@Then("^each category in the search results will have an associated summary$")
	public void each_category_in_the_search_results_will_have_an_associated_summary() {
		for (Category c : _marketService.getResultCategories()) {
	    	assertThat(c.getSummary(), not(equalTo(null)));
	    }
	}
	
	private void initializeMarketServiceWithMockAPICommunicator() {
		List<Document> documents = new ArrayList<Document>();
		Document d1 = new Document("Mock text for a document object", new Category("C1"));
		Document d2 = new Document("Mock text for a document object", new Category("C2"));
		documents.add(d1);
		documents.add(d2);
		APICommunicator apiCommunicator = mock(APICommunicator.class);
		when(apiCommunicator.searchAndCategorize(anyList())).thenReturn(documents);
		when(apiCommunicator.labelCategory(anyList())).thenReturn("Mock label for a category of documents");
		when(apiCommunicator.summarizeCategory(anyList())).thenReturn("Mock summary for a category of documents");
		_marketService = new MarketService(apiCommunicator);
	}
	
}

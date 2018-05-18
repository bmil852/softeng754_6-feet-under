package nz.ac.auckland.stepdefinitions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.ac.auckland.businessidea.Keyword;
import nz.ac.auckland.marketcomprehension.APICommunicator;
import nz.ac.auckland.marketcomprehension.Category;
import nz.ac.auckland.marketcomprehension.Document;
import nz.ac.auckland.marketcomprehension.MarketService;

public class MarketComprehensionStepDefs {

	private MarketService _marketService;
	
	@Given("^a User has a set of weighted keywords to search for$")
	public void a_User_has_a_set_of_weighted_keywords_to_search_for() throws Exception {
		initializeMarketServiceWithMockAPICommunicator();
	}

	@When("^the User performs a search$")
	public void the_User_performs_a_search() throws Exception {
	    _marketService.searchAndProcess(new ArrayList<Keyword>());
	}

	@Then("^a non-empty set of documents will be returned$")
	public void a_non_empty_set_of_documents_will_be_returned() throws Exception {
	    assertThat(_marketService.getSearchResults().size() > 0, equalTo(true));
	}
	
	@Then("^the set of documents returned will be clustered into a few categories$")
	public void the_set_of_documents_returned_will_be_clustered_into_a_few_categories() throws Exception {
	    assertThat(_marketService.getResultCategories().size() > 0, equalTo(true));
	}
	
	@Then("^there will be a label for each category in the results$")
	public void there_will_be_a_label_for_each_category_in_the_results() throws Exception {
	    for (Category c : _marketService.getResultCategories()) {
	    	assertThat(c.getLabel(), not(equalTo(null)));
	    }
	}

	@Then("^the label for each category will be concise$")
	public void the_label_will_be_concise() throws Exception {
		for (Category c : _marketService.getResultCategories()) {
	    	assertThat(c.getLabel().toCharArray().length < 140, equalTo(true));
	    }
	}
	
	@Then("^each category in the search results will have an associated summary$")
	public void each_category_in_the_search_results_will_have_an_associated_summary() throws Exception {
		for (Category c : _marketService.getResultCategories()) {
	    	assertThat(c.getSummary(), not(equalTo(null)));
	    }
	}
	
	private void initializeMarketServiceWithMockAPICommunicator() {
		List<Document> documents = new ArrayList<Document>();
		Category c1 = new Category("C1");
		Category c2 = new Category("C2");
		Category c3 = new Category("C3");
		for (int i = 0; i < 100; i++) {
			if (i < 50) {
				Document d = new Document("Mock text for a document object", c1);
				documents.add(d);
				c1.addDocument(d);
			} else if (i < 80) {
				Document d = new Document("Mock text for a document object", c2);
				documents.add(d);
				c2.addDocument(d);
			} else {
				Document d = new Document("Mock text for a document object", c3);
				documents.add(d);
				c3.addDocument(d);
			}
		}
		
		APICommunicator apiCommunicator = mock(APICommunicator.class);
		when(apiCommunicator.searchAndCategorize(anyList())).thenReturn(documents);
		when(apiCommunicator.labelCategory(anyList())).thenReturn("Mock label for a category of documents");
		when(apiCommunicator.summarizeCategory(anyList())).thenReturn("Mock summary for a category of documents");
		_marketService = new MarketService(apiCommunicator);
	}
	
}

package nz.ac.auckland.stepdefinitions;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nz.ac.auckland.businessvalidation.BusinessValidationService;
import nz.ac.auckland.businessvalidation.Relevance;
import nz.ac.auckland.marketcomprehension.Category;
import nz.ac.auckland.marketcomprehension.Document;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BusinessValidationStepDefs {

	private BusinessValidationService _businessValidationService;
	
	@Given("^the search results have returned an example set of documents as described$")
	public void the_search_results_have_returned_an_example_set_of_documents_as_described() {
		List<Category> categories = new ArrayList<Category>();
		Category c1 = new Category("C1");
		Category c2 = new Category("C2");
		Category c3 = new Category("C3");
		for (int i = 0; i < 100; i++) {
			if (i < 50) {
				Document d = new Document("Mock text for a document object", c1);
				c1.addDocument(d);
			} else if (i < 80) {
				Document d = new Document("Mock text for a document object", c2);
				c2.addDocument(d);
			} else {
				Document d = new Document("Mock text for a document object", c3);
				c3.addDocument(d);
			}
		}
		categories.add(c1);
		categories.add(c2);
		categories.add(c3);
		
		_businessValidationService = new BusinessValidationService(categories);
	}

	@When("^the popularity of each category is processed$")
	public void the_popularity_of_each_category_is_processed() {
	    _businessValidationService.calculateCategoryPopularities();
	}

	@Then("^category (\\d+) should have a popularity of (\\d+) percent$")
	public void category_should_have_a_popularity_of_percent(int arg1, int arg2) {
	    assertTrue(_businessValidationService.getPopularity(arg1) == arg2/100.0);
	}

	@Given("^an additional fourth category with no documents exists$")
	public void an_additional_fourth_category_with_no_documents_exists() {
		Category c4 = new Category("C4");
		_businessValidationService.addCategory(c4);
	}
	
	@When("^the user sets the relevance of category (\\d+) to (.*)$")
	public void the_user_sets_the_relevance_of_category_to(int arg1, String arg2) {
		_businessValidationService.setRelevance(arg1, Relevance.valueOf(arg2));
	}

	@Then("^the relevance of category (\\d+) will be equal to (.*)$")
	public void the_relevance_of_category_will_be_equal_to(int arg1, String arg2) {
		assertThat(_businessValidationService.getRelevance(arg1), equalTo(Relevance.valueOf(arg2)));
	}
	
	@Then("^the overall maturity for the business idea will be (\\d+)\\.(\\d+)$")
	public void the_overall_maturity_for_the_business_idea_will_be(int arg1, int arg2) throws Exception {
	    String parseableDouble = arg1 + "." + arg2;
	    double d = Double.parseDouble(parseableDouble);
	    assertThat(_businessValidationService.getOverallMaturity(), equalTo(d));
	}
}

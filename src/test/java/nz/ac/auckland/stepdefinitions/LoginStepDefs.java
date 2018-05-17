package nz.ac.auckland.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefs {
	
	@Given("^a new (?:User|Administrator) wants to sign up to the system$")
	public void a_new_User_or_Administrator_wants_to_sign_up_to_the_system() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the (User|Administrator) provides (valid|invalid) details for signing up$")
	public void the_User_or_Administrator_provides_valid_or_invalid_details_for_signing_up(String roleType, String validity) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the (User|Administrator) (is|is not) succesfully registered with the system$")
	public void the_User_or_Administrator_is_or_is_not_succesfully_registered_with_the_system(String roleType, String success) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^(a User|an Administrator) exists in the system$")
	public void a_User_or_Administrator_exists_in_the_system(String roleType) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the (User|Administrator) provides (valid|invalid) details for signing in$")
	public void the_User_or_Administrator_provides_valid_or_invalid_details_for_signing_in(String roleType, String validity) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the (User|Administrator) (is|is not) succesfully signed in$")
	public void the_User_or_Administrator_is_or_is_not_succesfully_signed_in(String roleType, String success) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^(a User|an Administrator) is already signed into the system$")
	public void a_User_or_Administrator_is_already_signed_into_the_system(String roleType) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the (User|Administrator) signs out of the system$")
	public void the_User_or_Administrator_signs_out_of_the_system(String roleType) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the (User|Administrator) is no longer signed in to the system$")
	public void the_User_or_Administrator_is_no_longer_signed_in_to_the_system() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}

package com.gig.atfdemo.user.adapters.bdd;

import com.gig.atfdemo.SpringIntegrationTests;
import com.gig.atfdemo.user.application.port.in.GetUserListUseCase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;

import static org.junit.Assert.*;

import static com.gig.atfdemo.user.application.port.in.GetUserListUseCase.*;

@RequiredArgsConstructor
public class GetUserListStepdefsAdapter extends SpringIntegrationTests {

    private final GetUserListUseCase getUserListUseCase;
    private GetUserListResponse getUserListResponse;

    @When("the user tries to get users from the page {int}")
    public void the_user_tries_to_get_users_from_the_page(int page) {
        getUserListResponse = getUserListUseCase.getUserList(page);
    }

    @Then("the user list is not empty")
    public void the_user_list_is_not_empty() {
        assertEquals(200, getUserListResponse.getStatus());
        assertTrue( getUserListResponse.getUsers().size() > 0);
    }

    @Then("the user list is empty")
    public void theUserListIsEmpty() {
        assertEquals(200, getUserListResponse.getStatus());
        assertTrue(getUserListResponse.getUsers().isEmpty());
    }
}

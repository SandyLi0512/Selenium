package com.epam.bdd.utaf.web.steps.wangyi;

import com.epam.bdd.utaf.core.GlobalVar;
import com.epam.bdd.utaf.core.utils.PropertiesReader;
import com.epam.bdd.utaf.web.pages.wangyi.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class SignInSteps {
    private static Logger logger = LoggerFactory.getLogger(com.epam.bdd.utaf.web.steps.wangyi.SignInSteps.class);
    private LoginPage loginPage;

    public SignInSteps() {
        loginPage = new LoginPage();
    }

    @Given("I navigate to yandex website")
    public void openSignPage() throws InterruptedException {
        logger.info("Navigate to yandex website");
        loginPage.openWebURL(PropertiesReader.getInstance().getProperty("url"));
        Thread.sleep(Integer.valueOf(GlobalVar.GLOBAL_VARIABLES.get("sleep")));
    }

    @When("I click Log in button")
    public void clickSignIn() throws InterruptedException {
        logger.info("Click signin icon");
        loginPage.clickSignIn();
        Thread.sleep(Integer.valueOf(GlobalVar.GLOBAL_VARIABLES.get("sleep")));
    }

    @And("I input account, password and click sing in")
    public void setAccount(List<Map<String, String>> account) throws InterruptedException {
        logger.info("Input email first");
        loginPage.setAccount(account.get(0).get("email"), account.get(0).get("password"));
        Thread.sleep(Integer.valueOf(GlobalVar.GLOBAL_VARIABLES.get("sleep")));
    }


    @Then("I see the organization home page")
    public void verifySignin() {
        logger.info("Verify signed in page");
        loginPage.verifySignedIn();
    }
}

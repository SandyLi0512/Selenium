package com.epam.bdd.utaf.web.steps.wangyi;

import com.epam.bdd.utaf.core.GlobalVar;
import com.epam.bdd.utaf.web.pages.wangyi.NewEmailPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class NewEmailSteps {
    private static Logger logger = LoggerFactory.getLogger(com.epam.bdd.utaf.web.steps.wangyi.SignInSteps.class);
    private NewEmailPage newEmailPage;

    public NewEmailSteps() {
        newEmailPage = new NewEmailPage();
    }

    @Given("I click Compose button")
    public void clickComposeButton() throws InterruptedException{
        logger.info("click Compose button");
        newEmailPage.clickNewEmail();
        Thread.sleep(Integer.valueOf(GlobalVar.GLOBAL_VARIABLES.get("sleep")));

    }
    @When("I give email address")
    public void setToAddress(List<Map<String, String>> datatable) throws InterruptedException{
        logger.info("Input email address");
        newEmailPage.setToAddress(datatable.get(0).get("emailAddress"));
    }

    @And("I give email subject")
    public void setEmailSubject(List<Map<String, String>> datatable) throws InterruptedException{
        logger.info("Input email subject");
        newEmailPage.setSubject(datatable.get(0).get("emailSubject"));
    }
    @And("I give email detail text")
    public void setEmailText(List<Map<String, String>> datatable) throws InterruptedException{
        logger.info("Input email text");
        newEmailPage.setEmailText(datatable.get(0).get("emailText"));
    }
    @Then("I click close button")
    public void clickCloseButton(){
        logger.info("I click close button");
        newEmailPage.clickCloseButton();
    }
}


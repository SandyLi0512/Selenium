package com.epam.bdd.utaf.web.steps.wangyi;

import com.epam.bdd.utaf.core.GlobalVar;
import com.epam.bdd.utaf.web.pages.wangyi.SendEmailPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendEmailSteps {

    private static Logger logger = LoggerFactory.getLogger(com.epam.bdd.utaf.web.steps.wangyi.SendEmailSteps.class);
    private SendEmailPage sendEmailPage;

    public SendEmailSteps() {
        sendEmailPage = new SendEmailPage();
    }

    @Given("I check the sent email in inbox")
    public void checkSentEmail() throws InterruptedException {
        logger.info("check the sent email in inbox");
        Thread.sleep(Integer.valueOf(GlobalVar.GLOBAL_VARIABLES.get("sleep")));
        sendEmailPage.clickInboxLink();
    }
    @When("Checked the email title in sent box")
    public void checkEmailTitle() throws InterruptedException{
        logger.info("check the email title in sent box");
        sendEmailPage.checkEmailTitle();
    }
    @Then("Logout account")
    public void clickLogoutButton() throws InterruptedException{
        logger.info("click logout button");
        Thread.sleep(Integer.valueOf(GlobalVar.GLOBAL_VARIABLES.get("sleep")));
        sendEmailPage.clickLoginButton();
    }
}

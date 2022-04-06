package com.epam.bdd.utaf.web.steps.wangyi;

import com.epam.bdd.utaf.core.GlobalVar;
import com.epam.bdd.utaf.web.pages.wangyi.DraftPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DraftSteps {
    private static Logger logger = LoggerFactory.getLogger(com.epam.bdd.utaf.web.steps.wangyi.DraftSteps.class);
    private DraftPage draftPage;

    public DraftSteps(){
        draftPage = new DraftPage();
    }

    @Given("I click Draft link")
    public void clickDraftLink() throws  InterruptedException{
        logger.info("click Draft link");
        draftPage.clickDraft();
        Thread.sleep(Integer.valueOf(GlobalVar.GLOBAL_VARIABLES.get("sleep")));
    }

    @When("I get the email title in Draft")
    public void checkEmailTitle() throws InterruptedException{
        logger.info("get the email title in Draft");
        draftPage.getEmailTitle();
        };


    @And("I click send button")
    public void clickSendButton() throws InterruptedException{
        logger.info("click the send button");
        draftPage.clickSendEmail();
        Thread.sleep(Integer.valueOf(GlobalVar.GLOBAL_VARIABLES.get("sleep")));
    }
    @Then("Check the email deleted from draft")
    public void checkEmailDis() throws InterruptedException{
        logger.info("check the email deleted from draft");
        draftPage.cheEmailDisappeared();
        Thread.sleep(Integer.valueOf(GlobalVar.GLOBAL_VARIABLES.get("sleep")));
    }
}



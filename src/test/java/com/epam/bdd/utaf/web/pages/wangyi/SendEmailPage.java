package com.epam.bdd.utaf.web.pages.wangyi;

import com.epam.bdd.utaf.core.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class SendEmailPage extends WangyiBasePage {
    private final Logger logger = LoggerFactory.getLogger(NewEmailPage.class);

    public SendEmailPage() {
        super("Send Email Page");
    }

    @FindBy(how = How.XPATH, using = "//a[@title = 'Sent']")
    private WebElement sent;

    @FindBy(how = How.XPATH, using = "//span[@class = 'mail-MessageSnippet-Item mail-MessageSnippet-Item_subject']")
    private WebElement emailSentTitle;

    @FindBy(how = How.XPATH, using = "//img[@class = 'user-pic__image']")
    private WebElement loginIcon;

    @FindBy(how = How.XPATH,using = "//span[@class = 'menu__text']]")
    private WebElement logoutButton;


    public void clickInboxLink() {

        clickElement(sent);
    }

    public void checkEmailTitle(){
        assertThat(emailSentTitle.getText().equals("Testing"));
    }

    public void clickLoginButton(){
        clickElement(loginIcon);
        if(logoutButton.isDisplayed()){
            clickElement(logoutButton);
        } else Utils.logFail("close button is not visible.");
    }


}

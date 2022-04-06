package com.epam.bdd.utaf.web.pages.wangyi;

import com.epam.bdd.utaf.core.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends WangyiBasePage{
    private final Logger logger = LoggerFactory.getLogger(com.epam.bdd.utaf.web.pages.wangyi.LoginPage.class);

    public LoginPage() {
        super("Login Page");
    }

    @FindBy (how = How.XPATH, using = "//a[contains(@href,'auth?from=mail')]")
    private WebElement logIn;


    @FindBy(how = How.ID, using = "passp-field-login")
    private WebElement email;

    @FindBy(how = How.ID, using = "passp:sign-in")
    private WebElement passSingIn;

    @FindBy(how = How.ID, using = "passp-field-passwd")
    private WebElement passWord;

    @FindBy(how = How.CLASS_NAME,using = "mail-ComposeButton-Text")
    private WebElement composeElement;

    public void clickSignIn() {
        clickElement(logIn);
        assertThat(passSingIn.isDisplayed()).isTrue();
    }
    public void setAccount( String username, String password) {
        if (isElementVisible(email)) {
            //setText();
            setText(email, username);
            clickElement(passSingIn);
            setText(passWord, password);
            clickElement(passSingIn);
        } else
            Utils.logFail("Password field is not visible.");
    }



    public void verifySignedIn() {
        assertThat(composeElement.isDisplayed()).as("The user profile image displayed").isTrue();
    }
}

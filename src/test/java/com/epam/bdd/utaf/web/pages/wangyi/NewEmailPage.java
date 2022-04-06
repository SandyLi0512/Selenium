package com.epam.bdd.utaf.web.pages.wangyi;

import com.epam.bdd.utaf.core.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class NewEmailPage extends WangyiBasePage{
    private final Logger logger = LoggerFactory.getLogger(NewEmailPage.class);

    public NewEmailPage() {
        super("New Email");
    }

    @FindBy(how = How.CLASS_NAME, using = "mail-ComposeButton-Text")
    private WebElement newEmailButton;

    @FindBy(how = How.CLASS_NAME, using = "composeYabbles")
    private WebElement toAdds;

    @FindBy(how = How.NAME, using = "subject")
    private WebElement subj;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'cke_wysiwyg_div')]")
    private WebElement emailT;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'ControlButton_button_close')]")
    private WebElement closed;

    public void clickNewEmail() {
        clickElement(newEmailButton);
        assertThat(closed.isDisplayed()).isTrue();
    }

    public void setToAddress(String toAddress){
        setText(toAdds,toAddress);

    }

    public void setSubject(String subject){
        setText(subj,subject);
    }

    public void setEmailText(String emailText){
        setText(emailT,emailText);
    }

    public void clickCloseButton(){
        if(closed.isEnabled()) {
            clickElement(closed);
        }else Utils.logFail("close button is not visible.");
    }

}

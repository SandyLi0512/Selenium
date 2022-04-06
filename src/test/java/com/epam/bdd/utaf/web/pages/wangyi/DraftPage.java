package com.epam.bdd.utaf.web.pages.wangyi;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class DraftPage extends WangyiBasePage{
    private final Logger logger = LoggerFactory.getLogger(NewEmailPage.class);

    public DraftPage() {
        super("Draft Page");
    }

    @FindBy(how = How.XPATH, using = "//a[@title = 'Drafts']")
    private WebElement draftLink;

    @FindBy(how = How.XPATH, using = "//span[@class = 'mail-MessageSnippet-Item mail-MessageSnippet-Item_subject']")
    private WebElement emailTitle;

    @FindBy(how = How.XPATH, using = "//button[@class = 'Button2 Button2_pin_circle-circle Button2_view_default Button2_size_l']")
    private WebElement sendButton;


    public void clickDraft(){
        clickElement(draftLink);
    }

    public void getEmailTitle(){
        assertThat(emailTitle.getText().equals("Testing"));
    }

    public void clickSendEmail(){
        if(emailTitle.getText().equals("Testing")){
            clickElement(emailTitle);
            clickElement(sendButton);
        }
    }

    public void cheEmailDisappeared(){
        clickDraft();
        assertThat(emailTitle.getText().isEmpty());

    }
}

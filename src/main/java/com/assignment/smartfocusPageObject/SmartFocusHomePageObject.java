package com.assignment.smartfocusPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.assignment.smartfocusComponent.BaseClass;

public class SmartFocusHomePageObject extends BaseClass {
	@FindBy(name="q")
	 public WebElement searchinputField;
	
	@FindBy(id="login")
	public WebElement smarkFocusLoginLink;
	
	@FindBy(xpath="//div[@class='form-item form-type-checkbox']")
	public WebElement acceptcheckBox;
	
	@FindBy(xpath="//h3[text()='SmartFocus: The Message Cloud']")
	public WebElement smarkFocusLink;
	
	@FindBy(xpath="//*[@value='Login']")
	public WebElement LoginButton;
	
	
	@FindBy(css=".language-switcher")
	public WebElement switchlang;
	
	@FindBy(xpath="//span[text()='English']")
	public WebElement lang;
	
	
	
	
	

	
	
	public SmartFocusHomePageObject(WebDriver driver) {
        this.driver = driver;     
        PageFactory.initElements(driver, this);
}

}
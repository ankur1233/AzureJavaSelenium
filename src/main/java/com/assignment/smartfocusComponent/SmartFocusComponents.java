package com.assignment.smartfocusComponent;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assignment.smartfocusPageObject.SmartFocusHomePageObject;
import com.assignment.smartfocusPageObject.SmartFocusLoginPageObject;

public class SmartFocusComponents {

	final static Logger logger = Logger.getLogger(SmartFocusComponents.class);

	SmartFocusHomePageObject componets = new SmartFocusHomePageObject(BaseClass.driver);
	SmartFocusLoginPageObject loginPage = new SmartFocusLoginPageObject(BaseClass.driver);

	// Explicit wait
	WebDriverWait wait = new WebDriverWait(BaseClass.driver, 20);

	public void waitForToLoad() throws InterruptedException {
		Thread.sleep(2000);
	}

	public void waitForToLoad(int a) throws InterruptedException {
		Thread.sleep(a);
	}

	public boolean verifyText(String str) {

		boolean ispass = false;

		logger.info(loginPage.Errorvalidation.getText());
		
		if (loginPage.Errorvalidation.getText().equals(str)) {

			ispass = true;
		}

		return ispass;
	}
	
	
	public void switchToTab() {
		
		String parent=BaseClass.driver.getWindowHandle();
		Set<String>s1=BaseClass.driver.getWindowHandles();
		Iterator<String> I1= s1.iterator();
		while(I1.hasNext())
		{
		  String child_window=I1.next();
		  if(!parent.equals(child_window))
		  {
			  BaseClass.driver.switchTo().window(child_window);
		    System.out.println(BaseClass.driver.switchTo().window(child_window).getTitle());
		   // BaseClass.driver.close();
		  }
		}	
			
	}
	
	
	

}

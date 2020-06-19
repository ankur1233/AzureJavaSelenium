package com.assignment.smartfocusComponent;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BaseClass {

	final static Logger logger = Logger.getLogger(BaseClass.class);

	public static WebDriver driver;
	String Browser= "chrome";
	String URL ="https://google.com";
	
	URL currentTestResourceFolder = getClass().getResource("/"+getClass().getSimpleName());
	
	public static  void   launchApp(/*String URL1, String Browser1*/) {

		String Browser= "chrome";
		String URL ="https://google.com";
		
		try {

			if (Browser.toUpperCase().contains("CHROME")) {
			
			
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") +"\\Driver\\chromedriver.exe");
				

	
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.prompt_for_download", "false");
				// chromePrefs.put("download.default_directory", DOWNLOAD_FILE_PATH);
				DesiredCapabilities cap =  DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("useAutomationExtension", false);
				options.setExperimentalOption("prefs", chromePrefs);
				options.addArguments("disable-infobars");
				// options.setHeadless(true);
				options.addArguments("start-maximized");
				options.addArguments("--disable-popup-blocking");
				options.addArguments("--disable-default-apps");
				options.addArguments("--enable-automation");
				options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				
				cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.IGNORE);
				
				
				driver = new ChromeDriver(options);
				driver.get(URL);
				driver.manage().deleteAllCookies();

				logger.info("Chrome browser");
				logger.info("URL" + URL);

			} else if (Browser.toUpperCase().contains("FIREFOX")) {

				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");

				driver = new FirefoxDriver();

				driver.get(URL);

				logger.info("FIREFOX");
				logger.info("URL" + URL);

			} else if (Browser.toUpperCase().contains("IE")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\Driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.get(URL);

				logger.info("IE");
				logger.info("URL" + URL);
			}

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}
	

	public static  void closeApp() {

		driver.quit();
		logger.info("Browser Close");

	}

}

package com.RelianceJio.srikanta.basic;

import org.openqa.selenium.WebDriver;

public class BasicFunctions {

	public void clearCookies(WebDriver driver) throws InterruptedException 
	{
		driver.manage().deleteAllCookies();
		Thread.sleep(5000); //wait 5 seconds to clear cookies.
	}
	
	public void openUrlInBrowser(WebDriver driver,String url)
	{
		driver.get(url);
	}
	public void goToBack(WebDriver driver)
	{
		driver.navigate().back();
	}
	public void goForward(WebDriver driver)
	{
		driver.navigate().forward();
	}
	public void refreshBrowser(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	public String getTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
}


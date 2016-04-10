package com.RelianceJio.srikanta.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageElements {
	
Select selectRef = null;
	
	public WebElement byclassName(WebDriver driver, String sClassId)
	{
		return driver.findElement(By.className(sClassId));
	}
	
	public WebElement byName(WebDriver driver, String sNameId)
	{
		return driver.findElement(By.name(sNameId));
	}
	
	public WebElement byLinkText(WebDriver driver, String sLinkText)
	{
		return driver.findElement(By.linkText(sLinkText));
	}
	
	public WebElement byXpath(WebDriver driver,String sXpathString)
	{
		return driver.findElement(By.xpath(sXpathString));
	}
	
	public WebElement byCSSPath(WebDriver driver,String sCssSelector)
	{
		return driver.findElement(By.cssSelector(sCssSelector));
	}
	
	public WebElement byId(WebDriver driver,String sId)
	{
		return driver.findElement(By.id(sId));
	}

}

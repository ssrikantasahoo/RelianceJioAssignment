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
	public WebElement byclassName1(WebDriver driver, String sClassId,int i)
	{
		return driver.findElements(By.className(sClassId)).get(i);
	}
	
	public WebElement byName1(WebDriver driver, String sNameId,int i)
	{
		return driver.findElements(By.name(sNameId)).get(i);
	}
	
	public WebElement byLinkText1(WebDriver driver, String sLinkText,int i)
	{
		return driver.findElements(By.linkText(sLinkText)).get(i);
	}
	
	public WebElement byXpath1(WebDriver driver,String sXpathString,int i)
	{
		return driver.findElements(By.xpath(sXpathString)).get(i);
	}
	
	public WebElement byCSSPath1(WebDriver driver,String sCssSelector,int i)
	{
		return driver.findElements(By.cssSelector(sCssSelector)).get(i);
	}
	
	public WebElement byId1(WebDriver driver,String sId,int i)
	{
		return driver.findElements(By.id(sId)).get(i);
	}

}

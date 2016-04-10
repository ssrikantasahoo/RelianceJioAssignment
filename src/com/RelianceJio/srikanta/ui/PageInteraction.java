package com.RelianceJio.srikanta.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageInteraction {
	
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
	public void selectBy(WebDriver driver, String sDomType, String sUIReference, String selectType, String sValue)
	{
		Select selectRef = null;
		if(sDomType.equals("name"))
		{
			selectRef = new Select(byName(driver, sUIReference));
		}
		else if(sDomType.equals("linkText"))
		{
			selectRef = new Select(byLinkText(driver, sUIReference));
		}
		else if(sDomType.equals("id"))
		{
			selectRef = new Select(byId(driver, sUIReference));
		}
		else if(sDomType.equals("className"))
		{
			selectRef = new Select(byclassName(driver, sUIReference));
		}
		else if(sDomType.equals("xpath"))
		{
			selectRef = new Select(byXpath(driver, sUIReference));
		}
		else if(sDomType.equals("cssSelector"))
		{
			selectRef = new Select(byCSSPath(driver, sUIReference));
		}
		if(selectType.equals("Index"))
		{
			selectRef.selectByIndex(Integer.parseInt(sValue));
		}
		else if(selectType.equals("Value"))
		{
			selectRef.selectByValue(sValue);
		}
		else if(selectType.equals("VisibleText"))
		{
			selectRef.selectByVisibleText(sValue);
		}
	}
	public void deselectBy(WebDriver driver, String sDomType, String sUIReference, String selectType, String sValue)
	{
		Select selectRef = null;
		if(sDomType.equals("name"))
		{
			selectRef = new Select(byName(driver, sUIReference));
		}
		else if(sDomType.equals("linkText"))
		{
			selectRef = new Select(byLinkText(driver, sUIReference));
		}
		else if(sDomType.equals("id"))
		{
			selectRef = new Select(byId(driver, sUIReference));
		}
		else if(sDomType.equals("className"))
		{
			selectRef = new Select(byclassName(driver, sUIReference));
		}
		else if(sDomType.equals("xpath"))
		{
			selectRef = new Select(byXpath(driver, sUIReference));
		}
		else if(sDomType.equals("cssSelector"))
		{
			selectRef = new Select(byCSSPath(driver, sUIReference));
		}
		if(selectType.equals("Index"))
		{
			selectRef.deselectByIndex(Integer.parseInt(sValue));
		}
		else if(selectType.equals("Value"))
		{
			selectRef.deselectByValue(sValue);
		}
		else if(selectType.equals("VisibleText"))
		{
			selectRef.deselectByVisibleText(sValue);
		}
	}
	
	public boolean isElementPresent(WebDriver driver,By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	}

}

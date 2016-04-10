package com.RelianceJio.srikanta.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class UIAssert {
	
PageInteraction objPageInteraction = new PageInteraction();
	
	public void assertEquals(WebDriver driver,String sDomType, String sUIReference,String sExpectedValue)
	{
		if(sDomType.equals("linkText"))
		{
			Assert.assertEquals( objPageInteraction.byLinkText(driver, sUIReference),sExpectedValue);
		}
		else if(sDomType.equals("id"))
		{
			Assert.assertEquals( objPageInteraction.byId(driver, sUIReference),sExpectedValue);
		}
		else if(sDomType.equals("className"))
		{
			Assert.assertEquals( objPageInteraction.byclassName(driver, sUIReference),sExpectedValue);
		}
		else if(sDomType.equals("name"))
		{
			Assert.assertEquals( objPageInteraction.byName(driver, sUIReference),sExpectedValue);
		}
		else if(sDomType.equals("xpath"))
		{
			Assert.assertEquals( objPageInteraction.byXpath(driver, sUIReference),sExpectedValue);
		}
		else if(sDomType.equals("cssSelector"))
		{
			Assert.assertEquals( objPageInteraction.byCSSPath(driver, sUIReference),sExpectedValue);
		}
	}
	public void assertEquals(String sActualValue,String sExpectedValue)
	{
		Assert.assertEquals(sActualValue, sExpectedValue);
	}
	
	public void assertTrue(WebDriver driver,String sDomType, String sUIReference)
	{
		if(sDomType.equals("linkText"))
		{
			Assert.assertTrue(objPageInteraction.isElementPresent(driver,By.linkText(sUIReference)));
		}
		else if(sDomType.equals("id"))
		{
			Assert.assertTrue(objPageInteraction.isElementPresent(driver,By.id(sUIReference)));
		}
		else if(sDomType.equals("className"))
		{
			Assert.assertTrue(objPageInteraction.isElementPresent(driver,By.className(sUIReference)));
		}
		else if(sDomType.equals("name"))
		{
			Assert.assertTrue(objPageInteraction.isElementPresent(driver,By.name(sUIReference)));
		}
		else if(sDomType.equals("xpath"))
		{
			Assert.assertTrue(objPageInteraction.isElementPresent(driver,By.xpath(sUIReference)));
		}
		else if(sDomType.equals("cssSelector"))
		{
			Assert.assertTrue(objPageInteraction.isElementPresent(driver,By.cssSelector(sUIReference)));
		}
	}
	
	public void assertFalse(WebDriver driver,String sDomType, String sUIReference)
	{
		if(sDomType.equals("linkText"))
		{
			Assert.assertFalse(objPageInteraction.isElementPresent(driver,By.linkText(sUIReference)));
		}
		else if(sDomType.equals("id"))
		{
			Assert.assertFalse(objPageInteraction.isElementPresent(driver,By.id(sUIReference)));
		}
		else if(sDomType.equals("className"))
		{
			Assert.assertFalse(objPageInteraction.isElementPresent(driver,By.className(sUIReference)));
		}
		else if(sDomType.equals("name"))
		{
			Assert.assertFalse(objPageInteraction.isElementPresent(driver,By.name(sUIReference)));
		}
		else if(sDomType.equals("xpath"))
		{
			Assert.assertFalse(objPageInteraction.isElementPresent(driver,By.xpath(sUIReference)));
		}
		else if(sDomType.equals("cssSelector"))
		{
			Assert.assertFalse(objPageInteraction.isElementPresent(driver,By.cssSelector(sUIReference)));
		}
	}


}

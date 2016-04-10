package com.RelianceJio.srikanta.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UIVerify {
	
PageInteraction objPageInteraction = new PageInteraction();
	
	public void verifyEquals(WebDriver driver,String sDomType, String sUIReference,String sExpectedValue)
	{
		setVerificationType("equals",driver,sDomType,sUIReference,sExpectedValue);
	}
	public void verifyTrue(WebDriver driver,String sDomType, String sUIReference)
	{
		setVerificationType("true",driver,sDomType,sUIReference,"");
	}
	
	public void verifyFalse(WebDriver driver,String sDomType, String sUIReference)
	{
		setVerificationType("false",driver,sDomType,sUIReference,"");
	}
	public void setVerificationType(String sverifyType,WebDriver driver,String sDomType, String sUIReference,String sExpectedValue)
	{
		if(sDomType.equals("linkText"))
		{
			try{
				if(objPageInteraction.isElementPresent(driver,By.linkText(sUIReference)))
				{
					if(sverifyType.equals("equals"))
					{
						 Assert.assertEquals( objPageInteraction.byLinkText(driver, sUIReference),sExpectedValue);
					}
					else if(sverifyType.equals("true"))
					{
						Assert.assertTrue(objPageInteraction.isElementPresent(driver,By.linkText(sUIReference)));
					}
					else if(sverifyType.equals("false"))
					{
						Assert.assertFalse(objPageInteraction.isElementPresent(driver,By.linkText(sUIReference)));
					}
					
				}
	        }
	        catch(NoSuchElementException e){
	        }
		}
		else if(sDomType.equals("id"))
		{
			try{
				if(objPageInteraction.isElementPresent(driver,By.id(sUIReference)))
				{
					if(sverifyType.equals("equals"))
					{
						Assert.assertEquals( objPageInteraction.byId(driver, sUIReference),sExpectedValue);
					}
					else if(sverifyType.equals("true"))
					{
						Assert.assertTrue(objPageInteraction.isElementPresent(driver,By.id(sUIReference)));
					}
					else if(!sverifyType.equals("false"))
					{
						Assert.assertFalse(objPageInteraction.isElementPresent(driver,By.id(sUIReference)));
					}
				 
				}
	        }
	        catch(NoSuchElementException e){
	        }
		}
		else if(sDomType.equals("className"))
		{
			try{
				if(objPageInteraction.isElementPresent(driver,By.className(sUIReference)))
				{
					if(sverifyType.equals("equals"))
					{
						Assert.assertEquals( objPageInteraction.byclassName(driver, sUIReference),sExpectedValue);
					}
					else if(sverifyType.equals("true"))
					{
						Assert.assertTrue(objPageInteraction.isElementPresent(driver,By.className(sUIReference)));
					}
					else if(!sverifyType.equals("false"))
					{
						Assert.assertFalse(objPageInteraction.isElementPresent(driver,By.className(sUIReference)));
					}
				}
	        }
	        catch(NoSuchElementException e){
	        }
		}
		else if(sDomType.equals("name"))
		{
			try{
				if(objPageInteraction.isElementPresent(driver,By.name(sUIReference)))
				{
					if(sverifyType.equals("equals"))
					{
						Assert.assertEquals( objPageInteraction.byName(driver, sUIReference),sExpectedValue);
					}
					else if(sverifyType.equals("true"))
					{
						Assert.assertTrue(objPageInteraction.isElementPresent(driver,By.name(sUIReference)));
					}
					else if(!sverifyType.equals("false"))
					{
						Assert.assertFalse(objPageInteraction.isElementPresent(driver,By.name(sUIReference)));
					}
				 
				}
	        }
	        catch(NoSuchElementException e){
	        }
		}
		else if(sDomType.equals("xpath"))
		{
			try{
				if(objPageInteraction.isElementPresent(driver,By.xpath(sUIReference)))
				{
					if(sverifyType.equals("equals"))
					{
						Assert.assertEquals( objPageInteraction.byXpath(driver, sUIReference),sExpectedValue);
					}
					else if(sverifyType.equals("true"))
					{
						Assert.assertTrue(objPageInteraction.isElementPresent(driver,By.xpath(sUIReference)));
					}
					else if(!sverifyType.equals("false"))
					{
						Assert.assertFalse(objPageInteraction.isElementPresent(driver,By.xpath(sUIReference)));
					}
				 
				}
	        }
	        catch(NoSuchElementException e){
	        }
		}
		else if(sDomType.equals("cssSelector"))
		{
			try{
				if(objPageInteraction.isElementPresent(driver,By.cssSelector(sUIReference)))
				{
					if(sverifyType.equals("equals"))
					{
						Assert.assertEquals( objPageInteraction.byCSSPath(driver, sUIReference),sExpectedValue);
					}
					else if(sverifyType.equals("true"))
					{
						Assert.assertTrue(objPageInteraction.isElementPresent(driver,By.cssSelector(sUIReference)));
					}
					else if(!sverifyType.equals("false"))
					{
						Assert.assertFalse(objPageInteraction.isElementPresent(driver,By.cssSelector(sUIReference)));
					}
				}
	        }
	        catch(NoSuchElementException e){
	        }
		}
	}

}

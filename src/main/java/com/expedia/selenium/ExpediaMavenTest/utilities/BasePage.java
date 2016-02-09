package com.expedia.selenium.ExpediaMavenTest.utilities;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage extends AbstractTest{
	

	
	private final static String xpath = "xpath";
	private final static String id = "id";
	private final static String cssSelector = "css";
	private final static String name = "name";
	private final static String className = "className";
	private final static String tagName = "tagName";
	
	public static String getXpath() {
		return xpath;
	}
	
	public static String getId() {
		return id;
	}
	
	public static String getCssselector() {
		return cssSelector;
	}
	
	public static String getName() {
		return name;
	}
	
	public static String getClassName() {
		return className;
	}
	
	public static String getTagName() {
		return tagName;
	}
	//This method is used to click button
	public void clickButton(String locator, String attributeOfLocator){
		try {
			WebElement ele = getElement(locator, attributeOfLocator);
			ele.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("No Such Element Found Exception Occured on: "
					+ locator + " " + attributeOfLocator);
		}
	}
	
	//This method is used for clicking date on calendar
	public void clickOnCalendarDateFromDatePicker(String locator, String day, String monthYear, String months_years, String[] cal_dates, String calNextButton){
		
		try {
			List<WebElement> cal_month = getElements(locator, months_years);
			int i = 0;

			for (i = 0; i < cal_month.size(); i++) {
				
				if (cal_month.get(i).getText().equalsIgnoreCase(monthYear)) {
					List<WebElement> dates = getElements(locator, cal_dates[0]+ (i + 1) + cal_dates[1]);
					
					for (WebElement d : dates) {
						if (d.getText().equals(day)) {
							d.click();
							return;
						}
					}
				}

				if (i == cal_month.size() - 1) {
					WebElement nextButton = getElement(locator, calNextButton);
					nextButton.click();
					clickOnCalendarDateFromDatePicker(locator, day, monthYear, months_years, cal_dates, calNextButton);
				}
			}
		} catch (NoSuchElementException | TimeoutException e) {
			Reporter.log("Exception occure on Calendar operation by date picker");
			e.printStackTrace();
		}

	}
	
	//This method is used for auto complete text
	public void autoCompleteText(String typeaheadListLocator, String typeaheadListAttribute,String listLocator, String listAttribute, String selectText){
		WebElement ele = getElement(typeaheadListLocator, typeaheadListAttribute);
		List<WebElement> lists = getElements(listLocator, listAttribute, ele);
		
		for(WebElement list : lists){
			if(list.getText().equals(selectText)){
				list.click();
				break;
			}else{
				if(list.getText().length() > 0)
				Reporter.log("Not match : "+selectText+" -> With List Text -> "+list.getText());
			}
		}
	}
	
	//This method is used for listing all web element
	public void clickOnWebElenemtFromList(String locator, String attributeOfLocator, int index){
		List<WebElement> lists = getElements(locator, attributeOfLocator);
		
		int listSize = lists.size();
		System.out.println(listSize);
		try {
			if((listSize > 0) && (listSize >= index)){
				lists.get(index).click();
			}else{
				throw new NoSuchElementException("No Flight select button found");
			}
		} catch (NoSuchElementException e) {
			Reporter.log("No Such Element Found Exception Occured on: "
					+ locator + " " + attributeOfLocator);
			e.printStackTrace();
		}
	}
	
	
	//This method is used for entering text on text field
	public void enterDataIntoTextField(String locator, String attributeOfLocator,String value){
		
		try {
			WebElement ele = getElement(locator, attributeOfLocator);
			ele.sendKeys(value);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Reporter.log("No Such Element Found Exception Occured on: "
					+ locator + " " + attributeOfLocator);
		}				
		
	}
	
	//This method is used for clearing text field
			public void clearTextField(String locator,String attributeOfLocator){
				try {
					WebElement ele = getElement(locator, attributeOfLocator);
					ele.clear();
				} catch (NoSuchElementException e) {
					e.printStackTrace();
					Reporter.log("No Such Element Found Exception Occured on: "
							+ locator + " " + attributeOfLocator);
				}	
			}
			
			public String getName(String locator, String attributeOfLocator){
				try{
					WebElement ele = getElement(locator, attributeOfLocator);
					return ele.getText();
				}catch(NoSuchElementException e){
					e.printStackTrace();
					Reporter.log("No Such Element Found Exception Occured on: "
							+ locator + " " + attributeOfLocator);
					return locator+" "+attributeOfLocator;
				}
				
			}
			
			public String getValueFromTextField(String locator, String attributeOfLocator){
				try{
					WebElement ele = getElement(locator, attributeOfLocator);
					return ele.getAttribute("value");
				}catch(NoSuchElementException e){
					e.printStackTrace();
					Reporter.log("No Such Element Found Exception Occured on: "
							+ locator + " " + attributeOfLocator);
					return locator+" "+attributeOfLocator;
				}
				
			}
			
			public void selectDropDown(String locator, String attributeOfLocator,String value){
				try {
					WebElement ele = getElement(locator, attributeOfLocator);
					Select dropdown = new Select(ele);
					dropdown.selectByValue(value);
				} catch (NoSuchElementException e) {
					Reporter.log("No Such Element Found Exception Occured on: "
							+ locator + " " + attributeOfLocator);
					e.printStackTrace();
				}
			}
			
			public String getDropDownValue(String locator, String attributeOfLocator){
				WebElement ele = getElement(locator, attributeOfLocator);
				Select dropdown = new Select(ele);
				String value = dropdown.getFirstSelectedOption().getText();
				return value;
			}
			
			// This method is use assert value from web Page
			
			public void assertValue(WebElement actualResult, String expected) {
				Assert.assertEquals(actualResult, expected);
			}

			public void assertValue(String actualResult, String expected) {
				Assert.assertEquals(actualResult, expected);
			}

			public void assertValue(boolean actualResult, String expected) {
				Assert.assertEquals(actualResult, expected);
			}
		

}

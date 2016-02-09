package com.expedia.selenium.ExpediaMavenTest;

import org.testng.annotations.Test;

import com.expedia.selenium.ExpediaMavenTest.utilities.AbstractTest;

public class TS002_TC004_VerifyOnewayFlightUsingDatePicker extends AbstractTest{
	
	
	/*
	 * Verify the Oneway flight from New York to Dhaka on departing date as 
	 * 12/20/2015 
	 * 
	 */
	
	@Test(description = "Verify oneway flight using date picker from calendar")
	public void VerifyDate() {
		
		
		homeScreen().clickOnFlightButton();
		homeScreen().clickOnOnewayButton();
		homeScreen().clearFlyingFromCity();
		homeScreen().enterFlyingFromCity("New York");
		homeScreen().clearFlyingToCity();
		homeScreen().enterFlyingToCity("Dhaka");
		homeScreen().clearDepartingDate();
		homeScreen().clickOnDepartingDateTextField();
		homeScreen().clickOnCalendarDate("20-JUN 2016");
		homeScreen().clickOnSearchButton();
		homeScreen().verifyDestInNextPage("Dhaka");
	
	}
	
}

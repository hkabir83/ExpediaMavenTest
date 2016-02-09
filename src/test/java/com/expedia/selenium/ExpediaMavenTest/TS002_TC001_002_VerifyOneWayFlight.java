package com.expedia.selenium.ExpediaMavenTest;

import org.testng.annotations.Test;

import com.expedia.selenium.ExpediaMavenTest.utilities.AbstractTest;

public class TS002_TC001_002_VerifyOneWayFlight extends AbstractTest{


	/*
	 * Verify Oneway flight from New York to Dhaka on departing date as 
	 * 03/03/2016 
	 * 
	 */
	
	
	@Test(description = "Verify Oneway Flight from Home Screen")
	public void onewayFlight(){
		String departure = "New York";
		String destination = "Dhaka";
		homeScreen().clickOnFlightButton();
		homeScreen().clickOnOnewayButton();
		homeScreen().clearFlyingFromCity();
		homeScreen().enterFlyingFromCity(departure);
		homeScreen().clearFlyingToCity();
		homeScreen().enterFlyingToCity(destination);
		homeScreen().clearDepartingDate();
		homeScreen().setDepartingDate("03/03/2016");
		homeScreen().clickOnSearchButton();
		homeScreen().verifyDestInNextPage(destination);
		
	}
	
	
	/*
	 * Verify button by clicking flight list after search Oneway flight from New York to Dhaka 
	 * on departing date as 03/03/2016  
	 */
		
	
	@Test(dependsOnMethods={"onewayFlight"},description="Verify button by clicking from flight list")
	public void clickOnSelectButtonFromFlightList() throws InterruptedException{
		
		homeScreen().clickOnFlightSelectBtn(0);
		browserWindowHandle();
		//driver.navigate().to(expedia);
	}
	
}

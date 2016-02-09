package com.expedia.selenium.ExpediaMavenTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.expedia.selenium.ExpediaMavenTest.utilities.BasePage;

public class HomeScreen extends BasePage{
	
private static WebDriver driver = null;
	
	//Locators
	private String flightButton = "//a[@id='tab-flight-tab']";
	private String roundTripButton = "//*[@id='flight-type-roundtrip-label']";
	private String oneWayButton = "//*[@id='flight-type-one-way-label']";
	private String flyingFrom = "//input[@id='flight-origin']";
	private String flyingTo = "//input[@id='flight-destination']";
	private String departingDate = "//input[@id='flight-departing']";
	private String returningDate = "//input[@id='flight-returning']";
	private String searchButton = "//button[@id='search-button']";
	private String nextPageText = "//div[@class='title-departure']/span[1]";
	//private String preferredDropdown = "//select[@id='flight-advanced-preferred-airline']";
	private String preferredDropdown="//section[@class='advanced-options']/descendant::div/descendant::select[@id='flight-advanced-preferred-airline']";
	private String advanceOption = "//a[@id='advanced-options']";
	private String addingHotelCheckBox = "//input[@id='flight-add-hotel-checkbox']";
	private String hotelCheckInDate = "//input[@id='flight-hotel-checkin']";
	private String hotelCheckOutDate = "//input[@id='flight-hotel-checkout']";
	private String nextPageTextWtAddingHotel="//h1[@id='packageSearchTitle']";
	private String addingCarCheckBox = "//input[@id='flight-add-car-checkbox']";
	private String addingCarMessage = "//div[@id='flight-car']/p";
	private String addingCarErroTitle = "//div[@id='flight-errors']/h5";
	private String addingCarErrorMsg = "//div[@id='flight-errors']/div/ul/li/a";
	private String flightOnewayChildren = "//select[@id='flight-children']";
	private String flightOnewayChildAgePart1 = "//select[@id='flight-age-select-"; // 1']  /first child
	private String flightOnewayChildAgePart2 = "']";
	private String typeAheadList = "//*[@id='typeahead-list']";
	private String listAttribute = "li";
	private String flightSelectBtn = "//div[@class='price-button-wrapper']/button";
	
	private String month_year_header = "//div[@class='cal']/section[@class='cal-month']/header/h2";
	private String[] cal_dates = {"//div[@class='cal']/section[@class='cal-month'][" , "]/ul[@class='cal-dates']/li/a"};
	private String calNextButton = "//div[@class='cal']/button[2]";
	
	//Messages
	private String addingCarMsgText = "A car will be added to your search. You'll be able to customize your car choice later.";
	private String addingCarErrTitleText ="Please correct the errors below.";
	private String addingCarErrMsgText = "Please complete the highlighted date field(s) below.";
	
    

	public HomeScreen(WebDriver driver){
		this.driver = driver;
	}
	
	//methods with actions
	public void enterFlyingFromCity(String enterFlyingFromCity){
		
		enterDataIntoTextField(getXpath(), flyingFrom, enterFlyingFromCity);
	}
	
	public void enterFlyingToCity(String enterFlyingToCity) {
		enterDataIntoTextField(getXpath(), flyingTo, enterFlyingToCity);
	}
	
	public void setDepartingDate(String enterDepartingDate) {
		enterDataIntoTextField(getXpath(), departingDate, enterDepartingDate);
	}
	
	public void setReturningDate(String enterReturningDate) {
		enterDataIntoTextField(getXpath(), returningDate, enterReturningDate);
	}
	
	public void setHotelCheckInDate(String enterCheckInDate){
		enterDataIntoTextField(getXpath(), hotelCheckInDate, enterCheckInDate);
	}
	
	public void setHotelCheckOutDate(String enterCheckOutDate){
		enterDataIntoTextField(getXpath(), hotelCheckOutDate, enterCheckOutDate);
	}
	
	public void clearFlyingFromCity(){
		clearTextField(getXpath(), flyingFrom);
	}
	
	public void clearFlyingToCity(){
		clearTextField(getXpath(), flyingTo);
	}
	
	public void clearHoteCheckInDate(){
		clearTextField(getXpath(), hotelCheckInDate);
	}
	
	public void clearHoteCheckOutDate(){
		clearTextField(getXpath(), hotelCheckOutDate);
	}
	
	public void clearDepartingDate() {
		clearTextField(getXpath(), departingDate);
	}
	
	public void clearReturnDate() {
		clearTextField(getXpath(), returningDate);
	}
	
	public void clickOnSearchButton() {
		clickButton(getXpath(), searchButton);
	}
	
	public void clickOnFlightButton(){
		clickButton(getXpath(), flightButton);
	}
	
	public void clickOnroundTripButton(){
		clickButton(getXpath(),roundTripButton);
	}
	
	public void clickOnOnewayButton(){
		clickButton(getXpath(), oneWayButton);
	}
	
	public void clickOnAdvanceOptionLink(){
		
		String advOpt = driver.findElement(By.xpath(advanceOption)).getAttribute("data-wizard-action");
		String advOptStat = advOpt.substring(23, advOpt.length()-2);
		
		if(advOptStat.equals("true")){
			clickButton(getXpath(),advanceOption);
		}
	}
	
	public void clickOnAddingHotelCheckBox(){
		clickButton(getXpath(),addingHotelCheckBox);
	}
	
	public void clickOnAddingCarCheckBox(){
		clickButton(getXpath(), addingCarCheckBox);
	}
	
	public void clickOnFlightSelectBtn(int index){
		clickOnWebElenemtFromList(getXpath(), flightSelectBtn, index);
	}
	
	public void clickOnCalendarDate(String dates){
		
		String[] date_splitter = dates.split("-");
		String day = date_splitter[0];
		String monthYear = date_splitter[1];
		
		clickOnCalendarDateFromDatePicker(getXpath(), day, monthYear, month_year_header, cal_dates, calNextButton);
	}
	
	public void clickOnDepartingDateTextField(){
		clickButton(getXpath(), departingDate);
	}
	
	public void selectPreferredAirlineDropdown(String value){
		selectDropDown(getXpath(), preferredDropdown, value);
	}
	
	public void selectChildren(int value){
		selectDropDown(getXpath(), flightOnewayChildren, String.valueOf(value));
	}
	
	public int getSelectedOptionValue(){
		String value = getDropDownValue(getXpath(), flightOnewayChildren);
		return Integer.parseInt(value);
	}
	
	
	public void selectOneOrMoreChildAges(int... children) throws Exception{
		
		int len = children.length;
		int noOfChildren = getSelectedOptionValue();
		if(len == noOfChildren){
			for (int i = 1; i <= children.length; i++) {
				selectDropDown(getXpath(), flightOnewayChildAgePart1+i+flightOnewayChildAgePart2, String.valueOf(children[i-1]));
			}
		}
		else{
			throw new Exception("Wrong input : No. Of Children and Individual child is not same > "+noOfChildren+" > "+len);
		}
	}
	
	
	public String getTextFromPage(String textLocator){
		
		return getName(getXpath(), textLocator);
	}
	
	public void autoCompleteFlyingFromTextField(String selectText, String partialText){
		
		enterDataIntoTextField(getXpath(), flyingFrom, partialText);
		autoCompleteText(getXpath(), typeAheadList, getTagName(), listAttribute, selectText);
	}
	
	public void autoCompleteFlyingToTextField(String selectText, String partialText){
		
		enterDataIntoTextField(getXpath(), flyingTo, partialText);
		autoCompleteText(getXpath(), typeAheadList, getTagName(), listAttribute, selectText);
	}
	
	public void verifyDestInNextPage(String dest){
		assertValue( getTextFromPage(nextPageText),"Select your departure to "+dest);
	}
	
	public void verifyNextPageByaddingHotel(){
		assertValue(getTextFromPage(nextPageTextWtAddingHotel),"Start by choosing your hotel");
	}
	
	public void verifyMsgAfterClickingAddAcarCheckBox(){
		assertValue(getTextFromPage(addingCarMessage), addingCarMsgText);
	}
	
	public void verifyErrMsgTitleAfterClickingAddAcarCheckBox(){
		assertValue(getTextFromPage(addingCarErroTitle), addingCarErrTitleText);
	}
	
	public void verifyErrMsgAfterClickingAddAcarCheckBox(){
		assertValue(getTextFromPage(addingCarErrorMsg), addingCarErrMsgText);
	}
	
	public void verifyAutoCompleteFlyingFrom(String expected){
		String selectedValue = getValueFromTextField(getXpath(), flyingFrom);
		assertValue(selectedValue, expected);
	}
	
	public void verifyAutoCompleteFlyingTo(String expected){
		String selectedValue = getValueFromTextField(getXpath(), flyingTo);
		assertValue(selectedValue, expected);
	}

}

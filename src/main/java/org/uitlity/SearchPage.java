package org.uitlity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BaseClas{

	public SearchPage() {
		
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css="input[type='submit']")
	private WebElement submit;
	
	public WebElement getSubmit() {
		return submit;
	}

	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}

	@FindBy(id="RequestorFirstName")
	private WebElement RequestorFirstName;
	
	@FindBy(id="RequestorLastName")
	private WebElement RequestorLastName;
	
	public WebElement getRequestorFirstName() {
		return RequestorFirstName;
	}

	public void setRequestorFirstName(WebElement requestorFirstName) {
		RequestorFirstName = requestorFirstName;
	}

	public WebElement getRequestorLastName() {
		return RequestorLastName;
	}

	public void setRequestorLastName(WebElement requestorLastName) {
		RequestorLastName = requestorLastName;
	}

	@FindBy(id="ProviderName")
	private WebElement ProviderName;
	
	@FindBy(id="Provider")
	private WebElement ProviderID;
	
	@FindBy(id="MembershipNumber")
	private WebElement MembershipNumber;
	
	@FindBy(id="LastName")
	private WebElement LastName;
	
	@FindBy(id="DateOfBirth")
	private WebElement DateOfBirth;
	
	@FindBy(id="ZipCode")
	private WebElement ZipCode;
	
	
	@FindBy(id="StartDateRange")
	private WebElement StartDateRange;
	
	@FindBy(id="EndDateRange")
	private WebElement EndDateRange;

	public WebElement getProviderName() {
		return ProviderName;
	}

	public void setProviderName(WebElement providerName) {
		ProviderName = providerName;
	}

	public WebElement getProviderID() {
		return ProviderID;
	}

	public void setProviderID(WebElement providerID) {
		ProviderID = providerID;
	}

	public WebElement getMembershipNumber() {
		return MembershipNumber;
	}

	public void setMembershipNumber(WebElement membershipNumber) {
		MembershipNumber = membershipNumber;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public void setLastName(WebElement lastName) {
		LastName = lastName;
	}

	public WebElement getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(WebElement dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public WebElement getZipCode() {
		return ZipCode;
	}

	public void setZipCode(WebElement zipCode) {
		ZipCode = zipCode;
	}

	public WebElement getStartDateRange() {
		return StartDateRange;
	}

	public void setStartDateRange(WebElement startDateRange) {
		StartDateRange = startDateRange;
	}

	public WebElement getEndDateRange() {
		return EndDateRange;
	}

	public void setEndDateRange(WebElement endDateRange) {
		EndDateRange = endDateRange;
	}
	
	
	
	
}

package org.uitlity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClas {
	
	
	public HomePage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="(//a[normalize-space()='Check Now'])[2]")
	private WebElement billStatus;


	public WebElement getBillStatus() {
		return billStatus;
	}


	public void setBillStatus(WebElement billStatus) {
		this.billStatus = billStatus;
	}
	

}

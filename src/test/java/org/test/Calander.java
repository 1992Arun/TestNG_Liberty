package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.uitlity.BaseClas;
import org.uitlity.HomePage;
import org.uitlity.SearchPage;
import org.uitlity.UtilityClass;

public class Calander extends BaseClas {

	
	@Test
	public void test() {
	
	browserLaunch("Chrome");
	
	UtilityClass u = new UtilityClass();
	
	HomePage h = new HomePage();
	
	SearchPage s = new SearchPage();
	
	getURL("https://provider.libertyhealthshare.org/");
	
	click(h.getBillStatus());
	
	click(s.getDateOfBirth());
	
	driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[1]"));
	
	String text = getText(driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[1]")));
	
	String[] split = text.split(" ");
	
	String month =split[0];
	
	String year = split[1];
	
	System.out.println(month+" "+year);
	
	if(Integer.parseInt(year)<Integer.parseInt(u.getProperty("Birthyear"))) {
		
		System.out.println("click next");
		
		driver.findElement(By.xpath("(//th[@class='datepicker-switch']/following::th)[1]")).click();
		
	} else {
		
		System.out.println("click previous");
		
		driver.findElement(By.xpath("(//th[@class='datepicker-switch']/preceding::th)[5]")).click();
		
	}
	
	List<WebElement> dates = driver.findElements(By.xpath("//table[@class='table-condensed']//tbody//td[@class='day']"));
	
	
	for(WebElement x:dates) {
		
		String text2 = x.getText();
		
		System.out.println(text2);
		
		if(text2.equalsIgnoreCase(u.getProperty("Birthday"))) {
			
			x.click();
		}
		
	}
	
	}
	
}

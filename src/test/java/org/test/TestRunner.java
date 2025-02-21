package org.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.uitlity.BaseClas;
import org.uitlity.HomePage;
import org.uitlity.Listene;
import org.uitlity.SearchPage;
import org.uitlity.UtilityClass;

@Listeners(Listene.class)
public class TestRunner extends BaseClas {
	
	public static HomePage h;
	
	public static SearchPage s;
	
	public static UtilityClass u;
	
	public static SoftAssert sa;
	
	
	@BeforeMethod
	public void setUp() {
		
		browserLaunch("Chrome");
		
		getURL("https://provider.libertyhealthshare.org/");
		
		h = new HomePage();
		
		s = new SearchPage();
		
		u = new UtilityClass();
		
		sa = new SoftAssert();
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		quit();
	}
	
	
	@Test(dataProvider="deatils")
	public void search(String first, String last, String providername, String taxID, String membershipID, String zip, String DOB ) {
		
		click(h.getBillStatus());
		
		sendKeys(s.getRequestorFirstName(), first);
		
		sendKeys(s.getRequestorLastName(), last);
		
		sendKeys(s.getProviderName(), providername);
		
		sendKeys(s.getLastName(), u.getProperty("LastName"));
		
		sendKeys(s.getProviderID(), taxID);
		
		sendKeys(s.getMembershipNumber(), membershipID);
		
		sendKeys(s.getZipCode(), zip);
		
		sendKeys(s.getDateOfBirth(), DOB);

		sendKeys(s.getStartDateRange(), u.getProperty("StartDate"));
		
		sendKeys(s.getEndDateRange(), u.getProperty("EndDate"));
	      
	     click(s.getSubmit());
		
	}
	
	@Parameters({"first","last"})
	@Test()
	public void search1(String first, String last) {
		
		click(h.getBillStatus());
		
		sendKeys(s.getRequestorFirstName(), first);
		
		sendKeys(s.getRequestorLastName(), last);
		
		sendKeys(s.getProviderName(),  u.getProperty("ProviderName"));
		
		sendKeys(s.getLastName(), u.getProperty("LastName"));
	
		sa.assertEquals(getAttribute(s.getLastName(), "value"), "Arun");
		
		sendKeys(s.getProviderID(), u.getProperty("TaxId"));
		
		sendKeys(s.getMembershipNumber(), u.getProperty("MemberShip"));
		
		sendKeys(s.getZipCode(), u.getProperty("ZipCode"));
		
		//sendKeys(s.getDateOfBirth(), DOB);
	
		sendKeys(s.getStartDateRange(), u.getProperty("StartDate"));
		
		sendKeys(s.getEndDateRange(), u.getProperty("EndDate"));
	      
	     click(s.getSubmit());
	     
	     sa.assertAll();
		
	}
	
	
	@DataProvider(name="deatils")
	public String[][] data() {
		
		
		String[][] data = {{"kevin","sp","Daniel","876291823","293789371","81716","09/19/2010"},
				
				{"arun","kumar","johnatha","083083083","293789371","29791","12/29/2010"},		
		                    };
		
		return data;
	}

}

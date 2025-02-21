package org.uitlity;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClas {

	public static WebDriver driver;



	public static void browserLaunch(String browser) {

//		if(driver==null) {
		
		ChromeOptions opt = new ChromeOptions();

		opt.addArguments("--headless");

		switch(browser){

		case "Chrome": driver = new ChromeDriver(opt);
		
	//	case "Chrome": driver = new ChromeDriver();

		break;

		case "Edge": driver = new EdgeDriver();

		break;

		case "Firefox": driver = new FirefoxDriver();

		break;



		}
		
		}

//	}


	public static String getURL(String url) {


		driver.get(url);

		driver.manage().window().maximize();

		return url;



	}


	public static void implicitWait(int sec) {


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));



	}


	public static void click(WebElement e){

		e.click();


	}

	public static void jClick(WebElement e){


		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("arguments[0].click();", e);


	}





	public static void sendKeys(WebElement e, String value){


		e.sendKeys(value);




	}


	public static void jSendKeys(WebElement e, String value){


		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("arguments[0].value='"+ value +"';", e);



	}

	public static void frameid(int index) {

		driver.switchTo().frame(index);


	}

	public static void frameName(String name) {

		driver.switchTo().frame(name);


	}


	public static void frameWeb(WebElement e) {

		driver.switchTo().frame(e);


	}

	public static void windowName(String name){

		Set<String> windowHandles = driver.getWindowHandles();

		String windowHandle = driver.getWindowHandle();

		for(String window: windowHandles) {

			if(!window.equalsIgnoreCase(name)) {

				driver.switchTo().window(window);

			}


		}

	}

	public static void windowNo(int num){

		Set<String> windowHandles = driver.getWindowHandles();

		int count =1;

		for(String window: windowHandles) {

			if(count ==num) {

				driver.switchTo().window(window);

			}

			count++;

		}


	}



	public static void selectByIndex(WebElement e, int index ){


		Select s = new Select(e);

		s.selectByIndex(index);


	}


	public static void selectByValue(WebElement e, String value ){


		Select s = new Select(e);

		s.selectByValue(value);


	}


	public static void selectByText(WebElement e, String text ){


		Select s = new Select(e);

		s.selectByVisibleText(text);


	}


	public static void doublClick(WebElement e){

		Actions a = new Actions(driver);

		a.doubleClick().perform();

	}


	public static String getText(WebElement e) {

		String text = e.getText();

		return text;
	}


	public static String getAttribute(WebElement e, String value) {

		String text = e.getAttribute(value);

		return text;

	}



	public static void dragAndDrop(WebElement e, WebElement b){


		Actions a = new Actions(driver);


		a.dragAndDrop(e, b).perform();


	}

	public static String time(){



		return new SimpleDateFormat("hh-mm-ss").format(new Date());


	}

	public static String takeScreenShots(String name ) throws IOException{

		TakesScreenshot ts =(TakesScreenshot)driver;

		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshotAs, new File(System.getProperty("user.dir")+"\\Screenshots\\"+name+".png"));

		//		String loc=".\\Screenshots\\"+name+".png";

		String loc = System.getProperty("user.dir")+"\\Screenshots\\"+name+".png";



		return loc;
	}


	public static String getcurrentURL(){

		String currentUrl = driver.getCurrentUrl();

		return currentUrl;


	}



	public static void enter() throws AWTException{

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);


	}
	
	public static void submit(WebElement e) {
		
		e.submit();
		
	}

	public static void sleep(int time){

		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void quit(){

		driver.quit();


	}

	public static void tabKey(int num) throws AWTException{

		Robot r = new Robot();


		for(int i=0; i<num; i++) {

			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);

		}
	}


	public static void downKey(int num) throws AWTException{

		Robot r = new Robot();


		for(int i=0; i<num; i++) {

			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);

		}
	}

	public static void aSendKeys(String value){

		Actions a = new Actions(driver);

		a.sendKeys(value).perform();


	}


	public static void leftKey(int num) throws AWTException{

		Robot r = new Robot();


		for(int i=0; i<num; i++) {

			r.keyPress(KeyEvent.VK_LEFT);
			r.keyRelease(KeyEvent.VK_LEFT);

		}
	}

	public static void spaceKey(int num) throws AWTException{

		Robot r = new Robot();


		for(int i=0; i<num; i++) {

			r.keyPress(KeyEvent.VK_SPACE);
			r.keyRelease(KeyEvent.VK_SPACE);

		}

	}



	public static String getCssValue(WebElement e, String name){

		String value = (String)((JavascriptExecutor)driver).executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('"+name+"');", e);

		return value;                                                                                                               


	}

	public static String getTitle(){



		return driver.getTitle();
	}


	public static void navigateBack(){

		driver.navigate().back();
	}

	public static void copy() throws AWTException{

		Robot r = new Robot();

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);

		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);


	}


}







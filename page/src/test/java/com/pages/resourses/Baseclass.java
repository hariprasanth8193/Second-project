package com.pages.resourses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public  class Baseclass {
	
	public static WebDriver driver;
	
	public static WebDriver browsers(String browser) {
		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\New folder\\Study\\Selenium\\src\\Driver\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
		}else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Eclipse\\SeleniumPractice\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						
		}else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Eclipse\\SeleniumPractice\\Driver\\IEDriverServer.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}else {
			
		
			
			System.out.println("Invalid driver");
			
			
		}		
		
		return driver;
	}
	// get URL
		public static void geturl(String url) {
		driver.get(url);
	}
		
	//Navigate
	public static void getnavigate(String navigate) {
		driver.get(navigate);
	}

	// Implicit wait
	public static void Implicitwait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	//explicit wait
		
	public static void untilvisibilityofElement(long Seconds,WebElement Element) {
		WebDriverWait wait = new WebDriverWait(driver,Seconds);
		
	}
	// is displayed
	public static boolean isDisplayed(WebElement element) {
		
		boolean Displayed =element.isDisplayed();
		return Displayed;
	}
	//Is Select
	public static boolean isSelected(WebElement element) {
		
		boolean Selected =element.isDisplayed();
		return Selected;
	}
	
	//IsEnable
	
	public static boolean isEnable(WebElement element) {
		
		boolean Enable =element.isDisplayed();
		return Enable;
	}
	
	//Clear,Sendkeys
	public static void Settext(WebElement element, CharSequence value) {
		try {
			//untilvisibilityofElement(5, element);
		if(isDisplayed (element)&&isEnable(element))
			
		{
			element.clear();
			element.sendKeys(value);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

			
	}
	
	//Dropdown
	
	public static void Select(String value,String option, WebElement element) {
		
		Select S = new Select(element);
		if (option.equals("Date")){
		S.selectByValue(value);
			}else if(option.equals("Index")){
		int parseInt =Integer.parseInt(value);
		S.selectByIndex(parseInt);
			}else if(option.equals("text")) {
		S.selectByVisibleText(value);
			}
		String text = S.getFirstSelectedOption().getText();
		List<WebElement> options = S.getOptions();
		for(WebElement X: options) {
			X.getText();
			X.getAttribute("value");
		}
}
	
	//get title
	
	public static String getTitle() {
		Implicitwait(5);
		String Title = driver.getTitle();
		return Title;
	}
	
	// get Current Url
	
	public static String getcurrenturl() {
		Implicitwait(5);
		String CurrentUrl = driver.getCurrentUrl();
		return CurrentUrl;
	}
	
	//ScreenShort
	//public static void takescreenshort(String amazonScreenshort,Object Screenshotas) {
		//TakesScreenshot tc =(TakesScreenshot)driver;
		//tc.getScreenshotAs(OutputType.FILE);
		//File fnew = new File("C:\\Eclipse\\SeleniumPractice\\Library\\"+ amazonScreenshort +".png");
		//FileUtils.copyFile(Screenshotas, fnew);
	//}
	
	public static void Scrollupdown(Object downscroll, Object UpScroll) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false);",downscroll);
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].scrollIntoView(true);",UpScroll);
	}
	
	//Mouseover
	public static void Mouseover(WebElement category) {
		Actions ac = new Actions(driver);
		ac.moveToElement(category).build().perform();

	}
	// DragandDrop
	
	public static void draganddrop(WebElement source, WebElement target) {
		try {
			Actions ac = new Actions(driver);
			ac.dragAndDrop(source, target).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Doubleclick
	public static void Doubleclick(WebElement element) {
		try {
			Actions ac = new Actions(driver);
			ac.doubleClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		} 
	

	//Navigation
	private static void Navigation(String options) {
		try {
			if(options.equals("refresh")) {
				driver.navigate().refresh();
			}else if (options.equals("forward")) {
				driver.navigate().forward();
			}else if (options.equals("backward")) {
				driver.navigate().back();
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
 	
		}
	
	  // Navigate URL
	private static void navigateurl(String url) {
		try {
			driver.navigate().to(url);
			}catch (Exception e) {
				e.printStackTrace();
			}
 	
		}
	
	//Gettext
	public static String gettext(WebElement element) {
		String text = null;
		try {
			text = element.getText();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}
	// get Attribute
	public static String getattributet(WebElement element, String options) {
		String attribute = null;
		try {
			attribute = element.getAttribute(options);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return attribute;
	}	
	
	

	
	//alert
	public void handleAlert(String alerttype, String options) throws Exception {
		Alert alert = driver.switchTo().alert();
		
		if(alerttype.equals("Sample")) {
			if(options.equals("accept")) {
				alert.accept();
			}else{
				
				throw new Exception("Not Valid Option");
			}
			}else if (alerttype.equals("Confirm"));{
			   if(options.equals("accept")){
				   alert.accept();
			   
			   }else if (options.equals("dismiss")){
				   alert.dismiss();
			   }else if(alerttype.equals("prompt")) {
				   if(options.equals("dismiss")) {
					   alert.dismiss();
				   }else {
					   alert.sendKeys(options);
					   alert.accept();
				   }
			   }
		
			   
			}

}	
	

		
	}    	

    	
    	

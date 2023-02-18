package bcrm_test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jdk.jfr.Timespan;


public class test1 {
	
	public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {

		String chromePath =System.getProperty("user.dir")+"\\src\\test\\resources\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromePath);
		driver = new ChromeDriver();
		driver.get("http://as2482aufal02:5555/Etisalat/main.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


		closePendingEmail();
		navigation("Reports","Sales","Orders");
		commandMenuClick("New");

	}
	
	
	public static void closePendingEmail() {
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("InlineDialog_Iframe");
			driver.findElement(By.xpath("//button[@id='butBegin']")).click();
			System.out.println("clicked on Button");
			System.out.println("****changes to git**********");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static void navigation(String topNav,String Flow,String subFlow) {
		
		try {
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//a[@title='"+topNav+"']")).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[@title='"+Flow+"']")).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[@title='"+subFlow+"']")).click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void commandMenuClick(String CommandValue) {
		
		try {
			driver.switchTo().defaultContent();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//div[@id='commandContainer1']//a//span[contains(.,'"+CommandValue+"')]")).click();

		} catch (Exception e) {
			
			e.printStackTrace();
		}		
	}
	


}



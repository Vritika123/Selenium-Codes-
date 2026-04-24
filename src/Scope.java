import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		
		// To find number of links in the page
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// To find number of links in the footer section
		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		//footerDriver is kind of mini driver we made and then find links in footer section
		
		 System.out.println(footerDriver.findElements(By.tagName("a")).size());
		 
		// To get count of links of first column only in footer section
		 
		WebElement columnDriver= footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		// Click on each link in the column and check pages are opening 
		
		// hasNext() tells whether next index is present or not and next() actually move to next index
 		for(int i=0;i<columnDriver.findElements(By.tagName("a")).size();i++) { 
			String cliclOnLinkTab=Keys.chord(Keys.COMMAND,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(cliclOnLinkTab);
			Thread.sleep(5000);
 		}  // For loop opens all the tabs 
 		
 		
			Set<String> abc=driver.getWindowHandles();
			Iterator<String> it = abc.iterator();
			
			while(it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
			
			
			
			
		}

	}



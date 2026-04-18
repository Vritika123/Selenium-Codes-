import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {
		
	   WebDriver driver = new ChromeDriver();
	   driver.get("https://www.spicejet.com/");
      Thread.sleep(3000);
	  driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
	  driver.findElement(By.xpath("//div[text()='Bengaluru']")).click();
	  driver.findElement(By.xpath("//div[text()='Hyderabad']")).click();
	// driver.findElement(By.cssSelector(".css-76zvg2.r-homxoj.r-ubezar.r-16dba41")).click();
	
	  
	  driver.findElement(By.xpath("(//div[@data-testid='undefined-calendar-day-26'])[1]")).click();
	  
	  System.out.println(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).getDomAttribute("style"));
	//Value before round trip button is clicked
	  
	  //  Click the round trip button
	  driver.findElement(By.xpath("(//div[@data-testid='round-trip-radio-button'])")).click();
	  
	//Value after round trip button is clicked
	  System.out.println(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).getDomAttribute("style"));
	  
	  
	
	  String afterValue= driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).getDomAttribute("style");
	   
	  
	  if(afterValue.contains("background-color")) {
		  System.out.println("Element is disabled");
          Assert.assertFalse(false);
	  }else {
		  System.out.println("Element is enabled");
		  Assert.assertTrue(true);
	  }
	
	//  Click the one way button
	 driver.findElement(By.xpath("(//div[@data-testid='one-way-radio-button'])")).click();
	 
	 driver.findElement(By.xpath("(//div[@data-testid='home-page-travellers'])")).click();
	 
	 WebElement plus=driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']"));
	 for(int i=1;i<5;i++) {
		 plus.click();
	 }
	 driver.findElement(By.xpath(" //div[text()='Currency'] ")).click();
	 driver.findElement(By.xpath("//div[text()='USD']")).click();
	 
	 driver.findElement(By.xpath("//div[text()='Students']")).click();
	 driver.findElement(By.xpath("(//div[@data-testid='home-page-flight-cta'])")).click();
	 
	 driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1otgn73']//div[@class='css-1dbjc4n r-zso239']//*[name()='svg']")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//div[text()='Continue']")).click();
	 
	 
	 
	}
	
	
	

	
	
}
 
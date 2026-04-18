import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

public class SpiceJetNew {

	public static void main(String[] args) throws InterruptedException {

	   WebDriver driver = new ChromeDriver();
	   driver.get("https://www.spicejet.com/");
      Thread.sleep(3000);
      //Click on from and select Bengaluru
	  driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
	  driver.findElement(By.xpath("//div[text()='Bengaluru']")).click();
	  
	  // Select destination
	  driver.findElement(By.xpath("//div[text()='Hyderabad']")).click();
	 //  After selecting destination Calender dialog box will automatically opens

  // Select the date
	  driver.findElement(By.xpath("(//div[@data-testid='undefined-calendar-day-26'])[1]")).click();

	  
	  // To check that when we select one way, the return date button is disabled
	  System.out.println(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).getDomAttribute("style"));
	//Value before round trip button is clicked

	  //  Click the round trip button
	  driver.findElement(By.xpath("(//div[@data-testid='round-trip-radio-button'])")).click();

	//Value after round trip button is clicked
	  System.out.println(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).getDomAttribute("style"));



	  String afterValue= driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).getDomAttribute("style");

  // If it container bg color means it is disable , else not
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

	 
	 // Select number of Passengers
	 WebElement plus=driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']"));
	 for(int i=1;i<5;i++) {
		 plus.click();
	 }
	 driver.findElement(By.xpath(" //div[text()='Currency'] ")).click();
	 driver.findElement(By.xpath("//div[text()='USD']")).click();

	 driver.findElement(By.xpath("//div[text()='Students']")).click();
    //	 Click on Search flight
	 driver.findElement(By.xpath("(//div[@data-testid='home-page-flight-cta'])")).click();
	 
	 
	 Thread.sleep(3000);
	 // Click on checkbox
	 driver.findElement(By.xpath("//div[contains(text(),'I have read')]/../..//*[@data-testid='svg-img']")).click();
	 
	 // Click on Continue
	 driver.findElement(By.xpath("//div[text()='Continue']/..")).click();

	
	 
	 
	 
	 

	}






}

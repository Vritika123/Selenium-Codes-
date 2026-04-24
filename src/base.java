import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//explicit wait 
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));
		// manage() means we are going to manage our driver object
		// timeouts() is one of the parameter
		
		String itemsNeeded[] = {"Cucumber","Brocolli","Beetroot","Carrot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		addItems(driver,itemsNeeded);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}
	
	public static void addItems(WebDriver driver,String itemsNeeded[]) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		int j=0;
		for(int i=0;i<products.size();i++) {
			
			// Brocolli - 1 Kg
			// Brocolli , 1 Kg
			String []name = products.get(i).getText().split("-");
			String formattedName= name[0].trim();
			
			
			// Convert array into arrayList for easy search
			// Check whether name you extracted is present in arrayList or not ?
			
			
			List itemsNeededList= Arrays.asList(itemsNeeded);
			if(itemsNeededList.contains(formattedName)) {
				j++;
				// Add to Cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsNeeded.length) {
					break;
				}
				
			}
		}
	}

}

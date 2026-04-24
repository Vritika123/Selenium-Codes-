import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAssignment {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		
		// Step 1: Click on Nested Frames link                                                                                                 
        driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
        
       // Step 2: Switch to the top frameset (contains left, middle, right)  
        driver.switchTo().frame("frame-top");
        
       // Step 3: Switch to the middle frame 
        driver.switchTo().frame("frame-middle");
        
       // Step 4: Capture and print the middle text
        String middleText = driver.findElement(By.id("content")).getText();
        System.out.println("Middle frame text: " + middleText);    
        
        // Come back to main page 
        driver.switchTo().defaultContent();
        
        driver.quit();
        
        


	}

}

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {

	public static void main(String[] args) {
		
			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			 driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
			 String label = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
			 System.out.println(label);
			 
			 WebElement dropdown= driver.findElement(By.id("dropdown-class-example"));
			 Select dp = new Select(dropdown);
			 dp.selectByVisibleText(label);
			 
			 
			 driver.findElement(By.id("name")).sendKeys(label);
			 driver.findElement(By.id("alertbtn")).click();
			 
			 Alert a = driver.switchTo().alert();
			String text= a.getText();
			
			if(text.contains(label)) {
				System.out.println("Succesfull message");
			}else {
				System.out.println("Wrong message");
			}
			
			a.accept();
			 
			 
			 
	}

}

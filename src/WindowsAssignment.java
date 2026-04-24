import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsAssignment {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");

		// Step 1: Click on Multiple Windows link
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();

		// Step 2: Click on "Click Here" which opens a new window
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		// Step 3: Get all window handles
		Set<String> windows = driver.getWindowHandles(); // [parentId, childId]
		System.out.println("Total number of windows: " + windows.size());
		Iterator<String> it = windows.iterator();

		String parentId = it.next();
		String childId = it.next();

		// Step 4: Switch to child window and capture text
		driver.switchTo().window(childId);
		String childText = driver.findElement(By.tagName("h3")).getText();
		System.out.println("Child window text: " + childText);

		// Step 5: Close child window and switch back to parent
		driver.close();
		driver.switchTo().window(parentId);

		// Step 6: Capture text from parent window
		String parentText = driver.findElement(By.tagName("h3")).getText();
		System.out.println("Parent window text: " + parentText);

		driver.quit();
	}

}

package vc_order_update;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class VC_Order_Update {

	@Test
	public void update() throws Exception {
		
		//driver initialization
		System.setProperty("webdriver.gecko.driver", "D:\\Govind Tyagi-HOB Data\\Softwares\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(2000);

		//initiate url
		String url = "https://manage.boddess.com/admin/admin/";
		driver.get(url);
		Thread.sleep(5000);

		//username
		WebElement uname = driver.findElement(By.xpath("//*[@id='username']"));
		uname.clear();
		uname.sendKeys("govind");

		// pw feed
		WebElement pw = driver.findElement(By.xpath("//*[@id='login']"));
		pw.clear();
		pw.sendKeys("Aspire@1005");

		// click login
		WebElement login = driver.findElement(By.xpath("//button"));
		login.click();
		Thread.sleep(5000);

		// order update loop
		for (int input = 1307981; input <= 1307984; input = input + 3) {
			try {
				String url1 = "https://manage.boddess.com/admin/sales/order/view/order_id/" + input + "/";
				driver.get(url1);
				Thread.sleep(5000);

				// find vc tab
				driver.findElement(By.xpath("//*[@title='Vinculum Order']")).click();
				Thread.sleep(5000);
			} catch (Exception e) {
				System.out.println("Something went wrong.");
			}
		}

		// sign out
		driver.findElement(By.xpath("//span[@class='admin-user-account-text']")).click();
		driver.findElement(By.xpath("//a[@title='Sign Out']")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}

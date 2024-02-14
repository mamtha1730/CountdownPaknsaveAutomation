package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageRepo.Countdownpage;
import PageRepo.PaknSavepage;


public class TC_001_price_cmp
{
	WebDriver driver;
	
	@Test
	public void prod_cmp()
	{
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("https://www.countdown.co.nz/");
		driver.manage().window().maximize();
		
		Countdownpage cp=new Countdownpage(driver);
		cp.setsearchText("Farmer Brown Eggs Colony Size 6");
		
		String count_price=cp.getPrice();
		System.out.println("countdown price is :"+count_price);
		double  cntdwn_price_final=Double.parseDouble(count_price.substring(1,6).trim());
		System.out.println("New price after removing characters:"+cntdwn_price_final);
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.paknsave.co.nz/");
		PaknSavepage pk=new PaknSavepage(driver);
		
		pk.setsearch("Farmer Brown Eggs Colony Size 6");
		String pak_price=pk.getPrice();
		System.out.println("Paknsave price:"+pak_price);
		
		driver.quit();
	}
}

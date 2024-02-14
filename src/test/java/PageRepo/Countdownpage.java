package PageRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Countdownpage extends Basepage
{

	public Countdownpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='search']")
	WebElement txtsearch;
	
	@FindBy(xpath="//h3[@id='product-238881-price']")
	WebElement pricetag1;
	
	public void setsearchText(String text)
	{
		txtsearch.sendKeys(text);
		Actions act=new Actions(driver);
		act.keyDown(Keys.ENTER).perform();
	}
	
	public String getPrice()
	{
		String p1=pricetag1.getAttribute("aria-label");
		//System.out.println("price"+p1);
		return p1;
	}
	
			
}

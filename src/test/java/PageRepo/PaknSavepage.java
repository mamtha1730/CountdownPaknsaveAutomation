package PageRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PaknSavepage extends Basepage 
{
	public PaknSavepage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//button[@aria-label=\"Close tooltip\"]//i[@class='c-icon c-icon--plus']")
	WebElement clkclose;
	
	@FindBy(xpath="//input[@aria-label='Search products']")
	WebElement txtsearch;
	
	@FindBy(xpath="//*[@id=\"main\"]/div/div[2]/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/p")
	WebElement price_prefix;
	
	@FindBy(xpath="//p[normalize-space()=\"90\"]")
	WebElement price_suffix;
	
	public void setsearch(String text)
	{
		txtsearch.clear();
		txtsearch.sendKeys(text);
		Actions act=new Actions(driver);
		act.keyDown(Keys.ENTER).perform();
	}
	
	public String getPrice()
	{
		String price=price_suffix.getText();
		String price_concat=price_prefix.getText().concat(price);
		return price_concat;
	}
	
}

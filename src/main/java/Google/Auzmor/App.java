package Google.Auzmor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
    	System.getProperty("webdriver.chrome.driver","E:\\Room mates work\\M.Selva1\\Softwares\\chromedriver.exe");
    	WebDriver wd= new ChromeDriver();
    	wd.get("http://www.google.com/");
    	WebElement searchbox= wd.findElement(By.xpath("//input[@type=\"text\"]"));
    	searchbox.sendKeys("Automation testing");
    	WebElement  button =wd.findElement(By.xpath("//input[@value=\"Google Search\"]"));
    	
    	
    
    }
}

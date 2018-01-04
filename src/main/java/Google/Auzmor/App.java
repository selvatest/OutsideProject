package Google.Auzmor;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class App 
{
	
	@Test(dataProvider="datasheet")
    public void main(String data)
    {
       // System.out.println( "Hello World!" );
    	System.setProperty("webdriver.chrome.driver","E:\\Room mates work\\M.Selva1\\Softwares\\chromedriver.exe");
    	WebDriver wd= new ChromeDriver();
    	wd.get("http://www.google.com/");
    	WebElement searchbox= wd.findElement(By.xpath("//input[@type=\"text\"]"));
    	searchbox.sendKeys(data);
    	searchbox.submit();
    	
     }
	

	@DataProvider(name="datasheet")
	
	public  static Object[][] data() throws IOException {
		
		//ExcelReader a= new ExcelReader();
		Object[][]data= ExcelReader.singledata();
		return data;
	}
	
}

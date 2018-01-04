package Google.Auzmor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class App 
{
	public static WebDriver wd = null;

	@BeforeTest
	public void browser()
	{
		
		System.setProperty("webdriver.chrome.driver","E:\\Room mates work\\M.Selva1\\Softwares\\chromedriver.exe");
    	 wd= new ChromeDriver();
    	wd.get("http://www.google.com/");
	}
	
	@Test(dataProvider="datasheet")
    public void main(String data) throws FileNotFoundException
    {
       // System.out.println( "Hello World!" );
    	
    	WebElement searchbox= wd.findElement(By.xpath("//input[@type=\"text\"]"));
    	searchbox.sendKeys(data);
    	searchbox.submit();
    	List<WebElement> alllinks =wd.findElements(By.xpath("(//h3//a)"));
    	System.out.println(alllinks.size());
    	for(WebElement a: alllinks)
    	{
    		String datqa=a.getText();
    		
    		//System.out.println(datqa);
    	}
    	List<WebElement> top5links =wd.findElements(By.xpath("(//h3//a)[position()>=1 and position()<=5]"));
    	System.out.println(top5links.size());
    	for(WebElement b: top5links)
    	{
    		String linktext=b.getText();
    		String path=System.getProperty("user.dir");
			System.out.println(path);
			FileInputStream fis = new FileInputStream(path+"\\InputData.xlsx");
			XSSFWorkbook wb =new XSSFWorkbook(fis);
			XSSFSheet sh=wb.getSheet("data");
    		System.out.println(linktext);
    	}
     }
	
	@DataProvider(name="datasheet")
	
	public  static Object[][] data() throws IOException {
		
		//ExcelReader a= new ExcelReader();
		Object[][]data= ExcelReader.singledata();
		return data;
	}
	@AfterSuite
	public void close()
	{
		
			wd.close();
		}
}

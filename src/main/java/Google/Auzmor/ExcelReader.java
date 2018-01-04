package Google.Auzmor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

		
			public static void main(String[] args) throws IOException {
				
				ExcelReader a= new ExcelReader();
				
				a.singledata();
			}
			
public static  Object[][] singledata() throws IOException
			//public static void main(String[] args) throws IOException 
			{
			String path=System.getProperty("user.dir");
			FileInputStream fis = new FileInputStream(path+"\\Testdata.xlsx");
			XSSFWorkbook wb =new XSSFWorkbook(fis);
			XSSFSheet sh=wb.getSheet("data");
			int rowcount=sh.getLastRowNum();
			int colcount=sh.getRow(0).getLastCellNum();
			Object[][] data= new Object[colcount][rowcount+1];
			//System.out.println(rowcount);
			for(int i=0;i<=rowcount;i++)
			{
				for(int j=0;j<colcount;j++)
				{
		        
				data[j][i]=sh.getRow(i).getCell(j).getStringCellValue();
				//String data=sh.getRow(i).getCell(j).getStringCellValue();
		/*   String data=sh.getRow(i).getCell(0).getStringCellValue();*/
		   System.out.println(data);
			}
			}
//			return null;
			return data;
			
			
			

			}	
			/*public static  Object[][] runtype() throws IOException
			
			{
			FileInputStream fis = new FileInputStream("C:\\Users\\PRAKASH\\workspace\\China\\Testdata.xlsx");
			XSSFWorkbook wb =new XSSFWorkbook(fis);
			XSSFSheet sh=wb.getSheet("data");
			int rowcount=sh.getLastRowNum();
			int colcount=sh.getRow(0).getLastCellNum();
		    Object[][] data= new Object[colcount][rowcount+1];
			//System.out.println(rowcount);
			for(int i=0;i<=rowcount;i++)
			{
		        
				data[1][i]=sh.getRow(i).getCell(1).getStringCellValue();
		  // String data=sh.getRow(i).getCell(0).getStringCellValue();
		   //System.out.println(data);
			}/
//			return null;
			return data;
			
			
			}	*/

			}
	
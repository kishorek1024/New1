package packone;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel {

	public static void main(String[] args) throws Exception{
		
		FileInputStream fileObj=new FileInputStream("C:\\Users\\DELL\\Desktop\\WD6\\abc.xlsx");
		
		XSSFWorkbook workbookObj=new XSSFWorkbook(fileObj);
		
		XSSFSheet sheetObj=workbookObj.getSheet("Sheet1");
		
		int rcount=sheetObj.getLastRowNum();
		
		int r;
		
		for(r=0; r<=rcount; r++){
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\WD730\\Jars\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("http://facebook.com");
			driver.manage().window().maximize();
			
			driver.findElement(By.id("email")).sendKeys(sheetObj.getRow(r).getCell(0).getStringCellValue());
			driver.findElement(By.id("pass")).sendKeys(sheetObj.getRow(r).getCell(1).getStringCellValue());
			System.out.println(driver.getTitle() + "-" + r);
			driver.close();
		}
		
		/*//System.out.println(rcount);
		
		int r;
		
		for(r=0; r<=rcount; r++){
			System.out.println(sheetObj.getRow(r).getCell(0).getStringCellValue());
			System.out.println(sheetObj.getRow(r).getCell(1).getStringCellValue());
		}*/
		
		
	}

}

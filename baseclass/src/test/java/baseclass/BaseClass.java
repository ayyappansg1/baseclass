package baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public void launchbrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}else {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	}
	public void geturl(String url) {
		driver.get(url);
	}
	public String readExcel(int rowno,int cellno) throws Exception {
		File file=new File("C:\\Users\\ADMIN\\Desktop\\Adactin.xlsx");
		FileInputStream fs=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(fs);
		Sheet sheet = workbook.getSheet("Adactin");
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		String cellvalue = cell.toString();
		workbook.close();
		return cellvalue;
	}
	public WebElement webElementReturn(String locatorvalue) {
		return driver.findElement(By.id(locatorvalue));
	}
	public void inputloginValues(WebElement ele,String inputvalue ) {
		ele.sendKeys(inputvalue);
	}
	public void selectValues(WebElement ele,String selectvalue) throws Exception {
		Select select=new Select(ele);
		select.selectByVisibleText(selectvalue.toString());
	}
	public void selectValuescard(int rowno,int cellno,String xpathvalue) throws Exception {
		List<WebElement> selectedvalues = driver.findElements(By.xpath(xpathvalue));
		String line=readExcel(rowno, cellno);
		for (WebElement each : selectedvalues) {
			if(line==each.getText()) {
			Select select=new Select(each);
			select.selectByValue(line);
			break;
		}
		}
	}
	public WebElement nameWebelement(String locatorvalue) {
		return driver.findElement(By.name(locatorvalue));
	}
	public void highlightWebElement(WebElement ele) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','border:3px solid blue');", ele);
	}
	public void selectbyValue(WebElement ele,String selectvalue) throws InterruptedException {
		Select select=new Select(ele);
		Thread.sleep(3000);
		select.selectByValue(selectvalue);
	}
	
	
	
	
	

}

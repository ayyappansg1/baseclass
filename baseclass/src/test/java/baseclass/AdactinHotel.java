package baseclass;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdactinHotel {
	public static void main(String[] args) throws Exception {
		BaseClass bs=new BaseClass();
		bs.launchbrowser(bs.readExcel(1,0));
		bs.geturl(bs.readExcel(4, 0));
		WebElement usernameBox = bs.webElementReturn(bs.readExcel(4, 1));
		bs.highlightWebElement(usernameBox);
		bs.inputloginValues(usernameBox, bs.readExcel(1, 1));
		WebElement passwordbox = bs.webElementReturn(bs.readExcel(4, 2));
		bs.highlightWebElement(passwordbox);
		bs.inputloginValues(passwordbox, bs.readExcel(1, 2));
		WebElement loginbutton = bs.webElementReturn(bs.readExcel(4, 3));
		bs.highlightWebElement(loginbutton);
		loginbutton.click();
		WebElement locationselect = bs.webElementReturn(bs.readExcel(4, 4));
		bs.highlightWebElement(locationselect);
		bs.selectValues(locationselect, bs.readExcel(1, 3));
		WebElement hotelSelect = bs.webElementReturn(bs.readExcel(4, 5));
		bs.highlightWebElement(hotelSelect);
		bs.selectValues(hotelSelect, bs.readExcel(1, 4));
		WebElement roomtypeselection = bs.webElementReturn(bs.readExcel(4, 6));
		bs.highlightWebElement(roomtypeselection);
		bs.selectValues(roomtypeselection, bs.readExcel(1, 5));
		WebElement searchbox = bs.webElementReturn(bs.readExcel(4, 7));
		bs.highlightWebElement(searchbox);
		searchbox.click();
		WebElement radiobtn = bs.webElementReturn(bs.readExcel(4, 8));
		bs.highlightWebElement(radiobtn);
		radiobtn.click();
		WebElement continues = bs.webElementReturn(bs.readExcel(4, 9));
		bs.highlightWebElement(continues);
		continues.click();
		WebElement firstname = bs.webElementReturn(bs.readExcel(4, 10));
		bs.highlightWebElement(firstname);
		bs.inputloginValues(firstname, bs.readExcel(1, 6));
		WebElement lastname = bs.webElementReturn(bs.readExcel(4, 11));
		bs.highlightWebElement(lastname);
		bs.inputloginValues(lastname, bs.readExcel(1, 7));
		WebElement address = bs.webElementReturn(bs.readExcel(4, 12));
		bs.highlightWebElement(address);
		bs.inputloginValues(address, bs.readExcel(1, 8));
		WebElement creditnumber = bs.webElementReturn(bs.readExcel(4, 13));
		bs.highlightWebElement(creditnumber);
		bs.inputloginValues(creditnumber, bs.readExcel(1, 9));
		
		WebElement expirymonth = bs.nameWebelement(bs.readExcel(4, 15));
		bs.highlightWebElement(expirymonth);
		bs.selectValues(expirymonth, bs.readExcel(1, 11));
		

		WebElement cvv = bs.webElementReturn(bs.readExcel(4, 17));
		bs.highlightWebElement(cvv);
		bs.inputloginValues(cvv, bs.readExcel(1, 13));
		
		WebElement expiryyear = BaseClass.driver.findElement(By.name("cc_exp_year"));
		bs.highlightWebElement(expiryyear);
		Select sangar=new Select(expiryyear);
		sangar.selectByValue("2022");
		
		WebElement cardtype =BaseClass.driver.findElement(By.name("cc_type"));
		bs.highlightWebElement(cardtype);
		Select sangar1=new Select(cardtype);
		sangar1.selectByValue("VISA");
		
		
		WebElement booknow = bs.webElementReturn(bs.readExcel(4, 18));
		bs.highlightWebElement(booknow);
		booknow.click();
		WebElement printid = bs.webElementReturn(bs.readExcel(4, 19));
		bs.highlightWebElement(printid);
		
		FileOutputStream fs=new FileOutputStream("C:\\Users\\ADMIN\\Desktop\\Adactin.xlsx");
		Workbook workbook=new XSSFWorkbook();
		Sheet sheet = workbook.getSheet("Adactin");
		Row createRow = sheet.createRow(5);
		Cell createCell = createRow.createCell(0);
		createCell.setCellValue(printid.getText());
		
	}
}

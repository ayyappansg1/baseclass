package adactintry;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Adactin {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("ayya199995");
		driver.findElement(By.id("password")).sendKeys("bharath-k1983");
		driver.findElement(By.id("login")).click();
		Select select=new Select(driver.findElement(By.id("location")));
		select.selectByVisibleText("Sydney");
		Select select1=new Select(driver.findElement(By.id("hotels")));
		select1.selectByVisibleText("Hotel Creek");
		Select select2=new Select(driver.findElement(By.id("room_type")));
		select2.selectByVisibleText("Standard");	
		driver.findElement(By.id("Submit")).click();
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("first_name")).sendKeys("Ayyappan");
		driver.findElement(By.id("last_name")).sendKeys("Gunasekaran");
		driver.findElement(By.id("address")).sendKeys("Mannargudi");
		driver.findElement(By.id("cc_num")).sendKeys("1234567890123456");
		driver.findElement(By.id("cc_cvv")).sendKeys("123");
		Select select3=new Select(driver.findElement(By.id("cc_type")));
		select3.selectByVisibleText("American Express");
		Select select4=new Select(driver.findElement(By.id("cc_exp_month")));
		select4.selectByVisibleText("March");	
		Select select5=new Select(driver.findElement(By.id("cc_exp_year")));
		select5.selectByVisibleText("2022");	
		

	}

}

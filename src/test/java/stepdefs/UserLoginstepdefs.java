package stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginstepdefs{
	
	WebDriver driver = Hooks.driver;
	

@Given("I have launched the medicare application")
public void i_have_launched_the_medicare_application() {
	
	driver.get("http://localhost:4444/medicare/home");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
}

@Given("I click on the Login Link")
public void i_click_on_the_Login_Link() {
	
	WebElement LoginLink = driver.findElement(By.xpath("//*[@id='login']/a"));
	LoginLink.click();
	
}

@When("I enter the username as {string} and Password as {string}")
public void i_enter_the_username_as_and_Password_as(String UserNameVal, String PwdVal) {
	 
	WebElement UserName = driver.findElement(By.xpath("//*[@id='username']"));
	UserName.sendKeys(UserNameVal);

	WebElement Password = driver.findElement(By.xpath("//*[@id='password']"));
	Password.sendKeys(PwdVal);
}

@Then("I click on the Login Button")
public void i_click_on_the_Login_Button() throws InterruptedException {
    
	WebElement LoginBtn = driver.findElement(By.xpath("//*[@id='loginForm']/div[3]/div/input[2]"));
	LoginBtn.click();
	
	Thread.sleep(2000);
	
	WebElement ViewProducts = driver.findElement(By.xpath("//*[@id='listProducts']/a"));
	ViewProducts.click();
	
	Thread.sleep(2000);
	
	Select prdentry = new Select(driver.findElement(By.xpath("//*[@id='productListTable_length']/label/select")));
	prdentry.selectByVisibleText("ALL");
	
	for (int j=1;j>5;j++) {
		
		
		WebElement ProductName = driver.findElement(By.xpath("//*[@id='productListTable']/tbody/tr[" + j + "]/td[2]"));
		String MedicineName = ProductName.getText();
		System.out.println("Medicine Name from UI:  " + MedicineName);
		System.out.println(MedicineName);
	}
	
	
   
}
}

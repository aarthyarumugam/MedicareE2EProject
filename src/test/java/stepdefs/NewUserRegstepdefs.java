package stepdefs;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;

public class NewUserRegstepdefs{
	
	WebDriver driver = Hooks.driver;

	@When("I click on signup link")
	public void i_click_on_signup_link()  {
	
	WebElement SignUp = driver.findElement(By.xpath("//*[@id='signup']/a"));
	SignUp.click();
}

@Then("I fill up the personal details for new user")
public void i_fill_up_the_personal_details_for_new_user() {
	
	WebElement FirstName = driver.findElement(By.xpath("//*[@id='firstName']"));
	FirstName.sendKeys("Aarthy");
	
	WebElement LastName = driver.findElement(By.xpath("//*[@id='lastName']"));
	LastName.sendKeys("Sunder");
	
	WebElement Email = driver.findElement(By.xpath("//*[@id='email']"));
	Email.sendKeys("aarthytest7@gmail.com");
	
	
	WebElement ContactNumber = driver.findElement(By.xpath("//*[@id='contactNumber']"));
	ContactNumber.sendKeys("9989889090");
	
	WebElement Password = driver.findElement(By.xpath("//*[@id='password']"));
	Password.sendKeys("test1234");
	
	WebElement ConfPassword = driver.findElement(By.xpath("//*[@id='confirmPassword']"));
	ConfPassword.sendKeys("test1234");
	
	WebElement Registerbtn = driver.findElement(By.xpath("//*[@id='registerForm']/div[8]/div/button"));
	Registerbtn.click();
	
}

@And("I fill up the address details for the new user and confirms")
public void i_fill_up_the_address_details_for_the_new_user_and_confirms() throws InterruptedException {
	
	WebElement AddrLine1 = driver.findElement(By.xpath("//*[@id='addressLineOne']"));
	AddrLine1.sendKeys("Address Line One");
	
	WebElement AddrLine2 = driver.findElement(By.xpath("//*[@id='addressLineTwo']"));
	AddrLine2.sendKeys("Address Line Two");
	
	WebElement City = driver.findElement(By.xpath("//*[@id='city']"));
	City.sendKeys("Bangalore");
	
	WebElement PostalCode = driver.findElement(By.xpath("//*[@id='postalCode']"));
	PostalCode.sendKeys("123456");
	
	WebElement State = driver.findElement(By.xpath("//*[@id='state']"));
	State.sendKeys("Karnataka");
	
	WebElement Country = driver.findElement(By.xpath("//*[@id='country']"));
	Country.sendKeys("India");
	
	WebElement NextConf =driver.findElement(By.xpath("//*[@id='billingForm']/div[7]/div/button[2]"));
	NextConf.click();
	
	Thread.sleep(3000);
	
    WebElement ConfRegisterbtn = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div/div/a[@class = 'btn btn-lg btn-primary']"));
    ConfRegisterbtn.click();

    Thread.sleep(2000);
    
    WebElement UserRegisterbtn = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div/a"));
    UserRegisterbtn.click();
	
}
@Then("I am able to see login button for new user login")
public void i_am_able_to_see_login_button_for_new_user_login() {
	
	WebElement EmailLoginLabel = driver.findElement(By.xpath("//*[@id='loginForm']/div[1]/label"));
	String EmailLabelAct = EmailLoginLabel.getText();
	Assert.assertEquals("Email:", EmailLabelAct);
	
	WebElement PasswordLabel = driver.findElement(By.xpath("//*[@id='loginForm']/div[2]/label"));
	String PwdLabelAct = PasswordLabel.getText();
	Assert.assertEquals("Password:", PwdLabelAct);
	
}
@Then("I enter email and password and login to medicare portal")
public void i_enter_email_and_password_and_login_to_medicare_portal() throws InterruptedException
{
	WebElement UserName = driver.findElement(By.xpath("//*[@id='username']"));
	UserName.sendKeys("aarthytest7@gmail.com");

	WebElement Password = driver.findElement(By.xpath("//*[@id='password']"));
	Password.sendKeys("test1234");
	
	Thread.sleep(2000);
	
	WebElement LoginBtn = driver.findElement(By.xpath("//*[@id='loginForm']/div[3]/div/input[2]"));
	LoginBtn.click();
}

@And("I am able to see newly added username in the welcome page")
public void i_am_able_to_see_newly_added_username_in_the_welcome_page() {
	
	WebElement MedicareHome = driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[1]/a[@class='navbar-brand']"));
	String HomeLabel = MedicareHome.getText();
	Assert.assertEquals("Medicare", HomeLabel);
	
	WebElement NameDropDown = driver.findElement(By.xpath("//*[@id='dropdownMenu1']"));
	String NameLabel = NameDropDown.getText().trim();
	Assert.assertEquals("Aarthy Sunder", NameLabel);
	
	
	
	
}


}
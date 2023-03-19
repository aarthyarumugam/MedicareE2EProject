package stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserPaymentstepdefs{
	
	WebDriver driver = Hooks.driver;
	
	@When("I click on View Products")
	public void i_click_on_View_Products() throws InterruptedException {
	    
		Thread.sleep(2000);
		WebElement ViewProducts = driver.findElement(By.xpath("//*[@id='listProducts']/a"));
		ViewProducts.click();
		Thread.sleep(1000);
	}

	@When("I select and add the products to the cart")
	public void i_select_and_add_the_products_to_the_cart() throws InterruptedException {
	   WebElement AmoxicillinToCart = driver.findElement(By.xpath("//*[@id='productListTable']/tbody/tr[5]/td[6]/a[2]"));
	   AmoxicillinToCart.click();   
	   Thread.sleep(1000);
	   WebElement ContinueShoppingBtn = driver.findElement(By.xpath("//*[@id='cart']/tfoot/tr[2]/td[1]/a"));
	   ContinueShoppingBtn.click();
	   Thread.sleep(1000);
	   WebElement AceclofenacToCart = driver.findElement(By.xpath("//*[@id='productListTable']/tbody/tr[4]/td[6]/a[2]"));
	   AceclofenacToCart.click();
	  
	   
	}

	@Then("I click on checkout")
	public void i_click_on_checkout() throws InterruptedException {
	    Thread.sleep(1000);
	    WebElement CheckOutBtn = driver.findElement(By.xpath("//*[@id='cart']/tfoot/tr[2]/td[4]/a[@class='btn btn-success btn-block']"));
	    CheckOutBtn.click();
	    Thread.sleep(1000);
	    WebElement AddrSelect = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/div/div/div/a[@class='btn btn-primary']"));
	    AddrSelect.click();
	    Thread.sleep(1000);
	}

	@Then("I enter payment details")
	public void i_enter_payment_details() throws InterruptedException {
		
		WebElement CardNumber= driver.findElement(By.xpath("//*[@id='cardNumber']"));
		CardNumber.sendKeys("123456789012345");
		Thread.sleep(1000);
		WebElement ExpMonth= driver.findElement(By.xpath("//*[@id='expityMonth']"));
		ExpMonth.sendKeys("04");
		WebElement ExpYear= driver.findElement(By.xpath("//*[@id='expityYear']"));
		ExpYear.sendKeys("2024");
		WebElement CVVCode =driver.findElement(By.xpath("//*[@id='cvCode']"));
		CVVCode.sendKeys("300");
		WebElement PaymentBtn = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/a[@class='btn btn-success btn-lg btn-block']"));
		PaymentBtn.click();
		Thread.sleep(2000);	
	    
	}

	@Then("I verify if I am able to see order confirmed message")
	public void i_verify_if_I_am_able_to_see_order_confirmed_message() {
	    WebElement MessageConf = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/h3[@class='text-center']"));
	    String Confmessage = MessageConf.getText();
	    Assert.assertEquals("Your Order is Confirmed!!", Confmessage);
	}

}
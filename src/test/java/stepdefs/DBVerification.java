package stepdefs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;

public class DBVerification {
	
	WebDriver driver = Hooks.driver;
	
	@Then("I click on Manage Product and Add new category")
	public void i_click_on_Manage_Product_and_Add_new_category() throws InterruptedException {
			
        Thread.sleep(2000);
		WebElement ManageProducts = driver.findElement(By.xpath("//*[@id='manageProduct']/a"));
		ManageProducts.click();
		
		Thread.sleep(2000);
		
		WebElement AddNewCategory = driver.findElement(By.xpath("//*[@id='product']/div[7]/div/div/button"));
		AddNewCategory.click();
			
		Thread.sleep(1000);
		
		WebElement CategoryName = driver.findElement(By.xpath("//input[@placeholder='Category Name']"));
		CategoryName.sendKeys("Test Name");
		
		WebElement CategoryDesc = driver.findElement(By.xpath("//textarea[@placeholder='Enter category description here!']"));
		CategoryDesc.sendKeys("Test Description");
		
		WebElement SaveBtn = driver.findElement(By.xpath("//*[@id='categoryForm']/div[3]/div/input"));
		SaveBtn.click();
		
	}

	@Then("I verify in DB if the new category is added")
	public void i_verify_in_DB_if_the_new_category_is_added() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicare","root","admin");
        Statement stm = con.createStatement();
        ResultSet result = stm.executeQuery("select * from category");
        while(result.next()) {
		System.out.println(result.getInt("id"));
		System.out.println(result.getString("name"));
        }
        stm.executeUpdate("delete from category where name='Test Name'");
	} 
	
	@Then("I verify in DB if new order is added")
	public void i_verify_in_DB_if_new_order_is_added() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicare","root","admin");
        Statement stm = con.createStatement();
        ResultSet result = stm.executeQuery("select * from order_detail");
        while(result.next()) {
    		System.out.println(result.getInt("id"));
    		System.out.println(result.getString("name"));
            }
	}
	}

package stepdefs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.support.ui.Select;

public class APITeststepdefs {
	
	WebDriver driver = Hooks.driver;	
	Response response;
    RequestSpecification request;
    
    Map<String,Object> EmpObj = new HashMap<String, Object>();

    

    @Given("The base URI is {string}")

    public void the_base_URI_is(String URI) {

        // Write code here that turns the phrase above into concrete actions

       

            request = RestAssured.given().baseUri(URI);

    }

    

    @When("I perform the Get Operation")

    public void i_perform_the_Get_Operation() {

        // Write code here that turns the phrase above into concrete actions

            response = request.get();
            
     

    }

          

    @Then("Response code should be {int} and product names are matching in UI")

    public void response_code_should_be_and_product_names_are_matching_in_UI(int expResponseCode) throws InterruptedException {

        // Write code here that turns the phrase above into concrete actions

            Assert.assertEquals(expResponseCode, response.getStatusCode());
            
            JsonPath jpath = response.jsonPath();
    		List<String> medicinenames = jpath.get("name");
    		
    		driver.get("http://localhost:4444/medicare/home");
    		driver.manage().window().maximize();
    		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    		
    		Thread.sleep(1000);
    		
    		WebElement ViewProducts = driver.findElement(By.xpath("//*[@id='listProducts']/a"));
    		ViewProducts.click();
    		
    		Thread.sleep(2000);
    		
    		Select prdentry = new Select(driver.findElement(By.xpath("//*[@id='productListTable_length']/label/select")));
    		prdentry.selectByVisibleText("ALL");
    		
    		for (int i=0;i<medicinenames.size();i++) {
    			
    		System.out.println("Medicine Name from API: " + medicinenames.get(i));
    			
    			for (int j=1;j==medicinenames.size();j++) {
    				    				
    				
    			WebElement ProductName = driver.findElement(By.xpath("//*[@id='productListTable']/tbody/tr[" + j + "]/td[2]"));
    			String MedicineName = ProductName.getText();
    			System.out.println("Medicine Name from UI:  " + MedicineName);
    			Assert.assertEquals(medicinenames.get(i), MedicineName);
    			
    		}
    }
    }	
}
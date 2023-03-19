package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	    WebDriver driver;
	    //**************Objects**************//
	    
	    @FindBy(linkText = "Login")
	    WebElement LoginLink;
	    
	    @FindBy(xpath = "//*[@id='username']")
	    WebElement UserName;
	    
	    @FindBy(xpath = "//*[@id='password']")
	    WebElement Password;
	    	    
	    @FindBy(xpath = "//*[@id='loginForm']/div[3]/div/input[2]")
	    WebElement LoginBtn;
	    
	    public LoginPage(WebDriver basedriver) {
	    	
	    	this.driver = basedriver;
	    	PageFactory.initElements(basedriver, this);
	    }
	
	    //**************Methods**************//
	    
	           public void Login(String UserNameVal, String PassVal) {
			        
		        //Step-2 Login to application       
		        LoginLink.click();

			   //Step-3 Login
			    UserName.sendKeys(UserNameVal); 
			    Password.sendKeys(PassVal);
			    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			    
			    
			   //Step-5 Click on Login  
			    LoginBtn.click();
	}

}

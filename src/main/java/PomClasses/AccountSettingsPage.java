package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSettingsPage {
	
	public  WebDriver driver;
	public AccountSettingsPage(WebDriver diver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[name()='svg' and @data-testid='LogoutIcon']")
	private WebElement logoutIcon;
	
	public WebElement getLogoutIcon()	{
		return logoutIcon;
		
	}
	@FindBy(xpath="//li[text()='My Profile']")
	private WebElement myProfileLink;
	
	public WebElement getmyProfileLink() {
		return myProfileLink;
	}

}

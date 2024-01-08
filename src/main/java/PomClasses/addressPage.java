package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addressPage {
	
	public WebDriver driver;
	public addressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='/addressform']")
	private WebElement addAddressForm;
	
	@FindBy(xpath="//strong[text()='LoveBirds']/../../..//input")
	private WebElement lovebirdsAddress;
	
	@FindBy(xpath="//button[text()='Proceed']")
	private WebElement proceedButton;
	
	public WebElement getProceedButton() {
		return proceedButton;
	}
	public WebElement getlovebirdsAddress() {
		return lovebirdsAddress;
	}
	
	public WebElement getaddAddressForm() {
		return addAddressForm;
	}

}

package TestCases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PomClasses.AccountSettingsPage;
import PomClasses.AddressFormPage;
import PomClasses.HomePage;
import PomClasses.MyAddress;
import PomClasses.MyProfilePage;
import PomClasses.PaymentMethod;
import PomClasses.TshirtPage;
import PomClasses.addToCartPage;
import PomClasses.addressPage;
import Utilities.BaseClass;


@Listeners(Utilities.ListenersUtility.class)

public class AddToCartTest extends BaseClass{
	
	
	@Test(dataProvider="dataProviderAddress")
	
	
	public void TC_AddAddress_001_Test(String home,String house_Office,String street,String landmark,String Country,String state,String city,String Dpin,String mobN) throws Throwable
	{
		System.out.println("Add Address");
		HomePage hp=new HomePage(driver);
//    	wdu.javaScriptClick(driver,hp.getsettingicon());
		hp.getsettingicon().click();
		Thread.sleep(2000);
		
		AccountSettingsPage asp=new AccountSettingsPage(driver);
		wdu.javaScriptClick(driver,asp.getmyProfileLink());
		asp.getmyProfileLink().click();
		Thread.sleep(2000);
		
		
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.shoppersstack.com/my-profile/my-profile-info");
		System.out.println("My Profile page is opened");
		Thread.sleep(2000);
		MyProfilePage mp=new MyProfilePage(driver);
		mp.getmyAddressLink().click();
		
		MyAddress ma=new MyAddress(driver);
		ma.getaddressformbutton().click();
		
		AddressFormPage afp=new AddressFormPage(driver);
		afp.getNameTextField().sendKeys(home);
		afp.getHouseOfficeInformationTextField().sendKeys(house_Office);
		afp.getStreetInformationTextField().sendKeys(street);
		afp.getLandmarkTextField().sendKeys(landmark);
		
		
		WebElement CountryDropDown=afp.getCountryDropDown();
		drpU.selectDropDownByVisibleText(Country ,CountryDropDown);
		
		WebElement StateDropDown=afp.getStateDropDown();
		drpU.selectDropDownByVisibleText(state, StateDropDown);
		
		WebElement CityDropDown=afp.getCityDropDown();
		drpU.selectDropDownByVisibleText(city,CityDropDown);
		
		afp.getPincodeTextField().sendKeys(Dpin);
		afp.getPhoneNumberTextField().sendKeys(mobN);
		afp.getAddAddressButton().click();
		
		//To check whether the address is added
		
		Assert.assertEquals(ma.getaddedAddress().getText(), home);
		System.out.println("The address-"+home+"  is added successfully");
				
	}
	
	
	
	 @DataProvider
     public Object[][] dataProviderAddress()
    		 {
	
    	 		 Object[][] ref=new Object[1][9];	
    	 		 ref[0][0]="LoveBirds";
    	 		 ref[0][1]="ambani building,2nd floor";
    	 		 ref[0][2]="ambani street";
    	 		 ref[0][3]="ambani point";
    	 		 ref[0][4]="India";
    	 		 ref[0][5]="Karnataka";
    	 		 ref[0][6]="Bengaluru";
    	 		 ref[0][7]="560054";
    	 		 ref[0][8]="9341070909";
    	 		 

    	 			
    	 		 ref[1][0]="AngryBirds";
    	 		 ref[1][1]="malya building,2nd floor";
    	 		 ref[1][2]="malya street";
    	 		 ref[1][3]="malya point";
    	 		 ref[1][4]="India";
    	 		 ref[1][5]="Karnataka";
    	 		 ref[1][6]="Bengaluru";
   	 		     ref[1][7]="560054";
    	 		 ref[1][8]="7019884526";
    	 		 
    	 		 return ref;
    		 }
	
	
	
	
	
	//Comment this Test Case for adding address
	 
		@Test(dependsOnMethods ="TC_AddAddress_001_Test")
	
	public void TC_AddToCart_002_Test()throws Throwable{
		Thread.sleep(3000);
		
		System.out.println("first test case");
	String titleHomePage=driver.getTitle();
		Assert.assertEquals(titleHomePage,"ShoppersStack |Home");
		
		HomePage hp=new HomePage(driver);
		Thread.sleep(5000);
		WebElement menLink=hp.getmenMenuLink();
		
		wu.mouseOverAction(driver,menLink);
		
		hp.getTshirtPopupLink().click();
		TshirtPage tsp=new TshirtPage(driver);
		String currentUrl=driver.getCurrentUrl();
		Assert.assertEquals(currentUrl,"https://www.shoppersstack.com/sub-category/men-tshirt");
		wu.mouseOverAction(driver,tsp.gettshirtTopLink());
		
		tsp.getlevisMensRegularfitproduct_AddToCartButton().click();
		hp.getaddToCartLink().click();
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.shoppersstack.com/cart");
		System.out.println("The cart page has opened");
		
		addToCartPage ac=new addToCartPage(driver);
		String levisProductTest=ac.getlevisProduct().getText();
		Assert.assertEquals(levisProductTest,"Levis Mens Regular Fit Tee");
		System.out.println("the product is added to cart");
		ac.buyNowButtonInAddToCartPage().click();
		String addressPageURL=driver.getCurrentUrl();
		Assert.assertEquals(addressPageURL, "https://www.shoppersstack.com/selectaddress");
		System.out.println("the address page is displayed");
		
		addressPage ap=new addressPage(driver);
		ap.getlovebirdsAddress().click();
		ap.getProceedButton().click();
		
		PaymentMethod pm=new PaymentMethod(driver);
		
		WebElement netbankingbutton pm.getNetBankingButton();
		
		wu.javaScript
		
	}
    
    	 		
	

	//@Test
	public void TC_AddToCart_003_Test()throws Throwable{
		Thread.sleep(5000);;
		System.out.println("Second test case");
	}

}

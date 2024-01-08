package Utilities;

import java.util.ArrayList;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtility {
	public void selectDropDownByVisibleText(String textOfOption,WebElement selectTagOfDropDown) {
		Select select=new Select(selectTagOfDropDown);
		select.selectByVisibleText(textOfOption);
	}
	public void selectDropDownByValueattributeValue(String ValueattributeValue,WebElement selectTagOfDropDown) {
		Select select=new Select(selectTagOfDropDown);
		select.selectByValue(ValueattributeValue);
	}
	public void selectDropDownByIndex(int index ,WebElement selectTagOfDropDown) {
		Select select=new Select(selectTagOfDropDown);
		select.selectByIndex(index);

}

public void deselectDropDownByvisibleText(String textOfOption ,WebElement selectTagOfDropDown) {
	Select select=new Select(selectTagOfDropDown);
	select.deselectByVisibleText(textOfOption);

}
public void deselectDropDownByValueattributeValue(String ValueattributeValue,WebElement selectTagOfDropDown) {
	Select select=new Select(selectTagOfDropDown);
	select.deselectByValue(ValueattributeValue);
}
public void deselectDropDownByIndex(int index ,WebElement selectTagOfDropDown) {
	Select select=new Select(selectTagOfDropDown);
	select.deselectByIndex(index);
}
public ArrayList<String> ToGetAllOptionsText(WebElement selectTagOfDropDown) {
	Select select=new Select(selectTagOfDropDown);
	 List<WebElement> allOptions = select.getOptions();
	
	ArrayList<String> allOptionsTexts=new ArrayList<String>();
	for(WebElement ele:allOptions) {
	allOptionsTexts.add(ele.getText());
}
 return allOptionsTexts;

}
public WebElement ToGetPerticularOptiononIndex(WebElement selectTagOfDropDown,int indexOfOptions)
{
	
Select select=new Select(selectTagOfDropDown);
List<WebElement> allOptions = select.getOptions();
WebElement perticularOptionWebElement=allOptions.get(indexOfOptions);
return perticularOptionWebElement;


}

}









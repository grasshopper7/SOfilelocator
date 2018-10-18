package sotest.po.properties;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import file.pagefactory.FileElementLocatorFactory;
import file.pagefactory.FileFieldDecorator;
import file.pagefactory.properties.FindByProperties;
import file.pagefactory.properties.PropertiesFile;
import file.pagefactory.properties.PropertiesFileProcessor;

@PropertiesFile(filePath = "src/test/resources/properties/HomePageLocator.properties")
public class SOHomePropertiesPO /*extends LoginPO*/ {

	@FindByProperties
	public WebElement name;
	
	@FindByProperties
	public WebElement email;
	
	@FindByProperties
	public WebElement password;
	
	@FindByProperties
	public List<WebElement> labels;
	
	@FindByProperties
	public WebElement search;
	
	@FindByProperties
	public WebElement soglobe;
	
	@FindByProperties
	public WebElement login;
	
	@FindByProperties
	public WebElement signup;
	
	@FindByProperties
	public WebElement tags;
	
	@FindByProperties
	public WebElement users;
	
	@FindBy(id="password")
	public WebElement passwordOldStyle;
	
	@FindBy(tagName="label")
	public List<WebElement> labelsOldStyle;
	
	@FindByProperties
	public List<WebElement> questions;
	
	@FindByProperties
	public WebElement firstQuesTitle;
	
	@FindByProperties
	public List<WebElement> notice;
	
	
	public SOHomePropertiesPO(WebDriver driver) throws InterruptedException {
		
		
		FileElementLocatorFactory felf = new FileElementLocatorFactory(driver, new PropertiesFileProcessor());
		FileFieldDecorator ffd = new FileFieldDecorator(felf);
		PageFactory.initElements(ffd, this);
		if(notice.size()==1)
			notice.get(0).click();
		//Use invisibility check
		Thread.sleep(2000);
	}
	
	public void viewFirstQuestionDetails() throws InterruptedException {
		firstQuesTitle.click();
	}
	
	public void viewTagDetails() throws InterruptedException {
		tags.click();
	}
	
}

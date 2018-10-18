package sotest.po.json;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import file.pagefactory.FileElementLocatorFactory;
import file.pagefactory.FileFieldDecorator;
import file.pagefactory.json.FindByJson;
import file.pagefactory.json.JsonFile;
import file.pagefactory.json.JsonFileProcessor;

@JsonFile(filePath = "src/test/resources/json/HomePageLocator.json")
public class SOHomeJsonPO {

	@FindByJson
	public WebElement name;
	
	@FindByJson
	public WebElement email;
	
	@FindByJson
	public WebElement password;
	
	@FindByJson
	public List<WebElement> labels;
	
	@FindByJson
	public WebElement search;
	
	@FindByJson
	public WebElement soglobe;
	
	@FindByJson
	public WebElement login;
	
	@FindByJson
	public WebElement signup;
	
	@FindByJson
	public WebElement tags;
	
	@FindByJson
	public WebElement users;
	
	@FindBy(id="password")
	public WebElement passwordOldStyle;
	
	@FindBy(tagName="label")
	public List<WebElement> labelsOldStyle;
	
	@FindByJson
	public List<WebElement> questions;
	
	@FindByJson
	public WebElement firstQuesTitle;
	
	@FindByJson
	public List<WebElement> notice;
	
	
	public SOHomeJsonPO(WebDriver driver) throws InterruptedException {
		
		
		FileElementLocatorFactory felf = new FileElementLocatorFactory(driver, new JsonFileProcessor());
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

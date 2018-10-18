package sotest.po.json;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import file.pagefactory.FileElementLocatorFactory;
import file.pagefactory.FileFieldDecorator;
import file.pagefactory.json.FindByJson;
import file.pagefactory.json.JsonFile;
import file.pagefactory.json.JsonFileProcessor;

@JsonFile(filePath = "src/test/resources/json/QuestionPageLocator.json")
public class SOQuestionJsonPO {

	@FindByJson
	public WebElement title;
	
	@FindByJson
	public WebElement vote;
	
	@FindByJson
	public List<WebElement> tags;
	
	@FindByJson
	public WebElement user;
	
	@FindByJson
	public WebElement rep;
	
	@FindByJson
	public List<WebElement> badges;
	
	
	public SOQuestionJsonPO(WebDriver driver) {

		FileElementLocatorFactory felf = new FileElementLocatorFactory(driver, new JsonFileProcessor());
		FileFieldDecorator ffd = new FileFieldDecorator(felf);
		PageFactory.initElements(ffd, this);
	}
	
}

package sotest.po.properties;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import file.pagefactory.FileElementLocatorFactory;
import file.pagefactory.FileFieldDecorator;
import file.pagefactory.properties.FindByProperties;
import file.pagefactory.properties.PropertiesFile;
import file.pagefactory.properties.PropertiesFileProcessor;

@PropertiesFile(filePath = "src/test/resources/properties/QuestionPageLocator.properties")
public class SOQuestionPropertiesPO {

	@FindByProperties
	public WebElement title;
	
	@FindByProperties
	public WebElement vote;
	
	@FindByProperties
	public List<WebElement> tags;
	
	@FindByProperties
	public WebElement user;
	
	@FindByProperties
	public WebElement rep;
	
	@FindByProperties
	public List<WebElement> badges;
	
	
	public SOQuestionPropertiesPO(WebDriver driver) {

		FileElementLocatorFactory felf = new FileElementLocatorFactory(driver, new PropertiesFileProcessor());
		FileFieldDecorator ffd = new FileFieldDecorator(felf);
		PageFactory.initElements(ffd, this);
	}
	
}

package sotest.po.properties;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import file.pagefactory.FileElementLocatorFactory;
import file.pagefactory.FileFieldDecorator;
import file.pagefactory.properties.FindByProperties;
import file.pagefactory.properties.PropertiesFile;
import file.pagefactory.properties.PropertiesFileProcessor;

@PropertiesFile(filePath = "src/test/resources/properties/TagPageLocator.properties")
public class SOTagPropertiesPO {
	
	@FindByProperties
	public WebElement filter;
	
	@FindByProperties
	public WebElement tagdef;
	
	@FindByProperties
	public List<WebElement> tagsdisp;
	
	@FindByProperties
	public List<WebElement> options;
	
	@FindByProperties
	public WebElement popularopt;
	
	@FindByProperties
	public WebElement nameopt;
	
	@FindByProperties
	public WebElement newopt;
	
	
	public SOTagPropertiesPO(WebDriver driver) {

		FileElementLocatorFactory felf = new FileElementLocatorFactory(driver, new PropertiesFileProcessor());
		FileFieldDecorator ffd = new FileFieldDecorator(felf);
		PageFactory.initElements(ffd, this);
	}
	
	public List<String> displayedTagsText() {
		List<String> texts = new ArrayList<>();
		tagsdisp.forEach(e -> texts.add(e.getText()));
		return texts;
	}
	
	public void selectNameOption() {
		nameopt.click();
	}
}

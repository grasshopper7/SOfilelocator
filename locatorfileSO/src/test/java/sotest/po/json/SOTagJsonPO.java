package sotest.po.json;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import file.pagefactory.FileElementLocatorFactory;
import file.pagefactory.FileFieldDecorator;
import file.pagefactory.json.FindByJson;
import file.pagefactory.json.JsonFile;
import file.pagefactory.json.JsonFileProcessor;

@JsonFile(filePath = "src/test/resources/json/TagPageLocator.json")
public class SOTagJsonPO {
	
	@FindByJson
	public WebElement filter;
	
	@FindByJson
	public WebElement tagdef;
	
	@FindByJson
	public List<WebElement> tagsdisp;
	
	@FindByJson
	public List<WebElement> options;
	
	@FindByJson
	public WebElement popularopt;
	
	@FindByJson
	public WebElement nameopt;
	
	@FindByJson
	public WebElement newopt;
	
	
	public SOTagJsonPO(WebDriver driver) {

		FileElementLocatorFactory felf = new FileElementLocatorFactory(driver, new JsonFileProcessor());
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

package sotest.po.excel;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import file.pagefactory.FileElementLocatorFactory;
import file.pagefactory.FileFieldDecorator;
import file.pagefactory.excel.ExcelFile;
import file.pagefactory.excel.ExcelFileProcessor;
import file.pagefactory.excel.FindByExcel;

@ExcelFile(filePath = "src/test/resources/excel/TagPageLocator.xlsx")
public class SOTagExcelPO {
	
	@FindByExcel
	public WebElement filter;
	
	@FindByExcel
	public WebElement tagdef;
	
	@FindByExcel
	public List<WebElement> tagsdisp;
	
	@FindByExcel
	public List<WebElement> options;
	
	@FindByExcel
	public WebElement popularopt;
	
	@FindByExcel
	public WebElement nameopt;
	
	@FindByExcel
	public WebElement newopt;
	
	
	public SOTagExcelPO(WebDriver driver) {

		FileElementLocatorFactory felf = new FileElementLocatorFactory(driver, new ExcelFileProcessor());
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

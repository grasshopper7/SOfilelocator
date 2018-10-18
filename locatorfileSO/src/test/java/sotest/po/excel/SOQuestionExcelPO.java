package sotest.po.excel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import file.pagefactory.FileElementLocatorFactory;
import file.pagefactory.FileFieldDecorator;
import file.pagefactory.excel.ExcelFile;
import file.pagefactory.excel.ExcelFileProcessor;
import file.pagefactory.excel.FindByExcel;

@ExcelFile(filePath = "src/test/resources/excel/QuestionPageLocator.xlsx")
public class SOQuestionExcelPO {

	@FindByExcel
	public WebElement title;
	
	@FindByExcel
	public WebElement vote;
	
	@FindByExcel
	public List<WebElement> tags;
	
	@FindByExcel
	public WebElement user;
	
	@FindByExcel
	public WebElement rep;
	
	@FindByExcel
	public List<WebElement> badges;
	
	
	public SOQuestionExcelPO(WebDriver driver) {

		FileElementLocatorFactory felf = new FileElementLocatorFactory(driver, new ExcelFileProcessor());
		FileFieldDecorator ffd = new FileFieldDecorator(felf);
		PageFactory.initElements(ffd, this);
	}
	
}

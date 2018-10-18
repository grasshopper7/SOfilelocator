package sotest.po.excel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import file.pagefactory.FileElementLocatorFactory;
import file.pagefactory.FileFieldDecorator;
import file.pagefactory.excel.ExcelFile;
import file.pagefactory.excel.ExcelFileProcessor;
import file.pagefactory.excel.FindByExcel;

@ExcelFile(filePath = "src/test/resources/excel/HomePageLocator.xlsx")
public class SOHomeExcelPO {

	@FindByExcel
	public WebElement name;
	
	@FindByExcel
	public WebElement email;
	
	@FindByExcel
	public WebElement password;
	
	@FindByExcel
	public List<WebElement> labels;
	
	@FindByExcel
	public WebElement search;
	
	@FindByExcel
	public WebElement soglobe;
	
	@FindByExcel
	public WebElement login;
	
	@FindByExcel
	public WebElement signup;
	
	@FindByExcel
	public WebElement tags;
	
	@FindByExcel
	public WebElement users;
	
	@FindBy(id="password")
	public WebElement passwordOldStyle;
	
	@FindBy(tagName="label")
	public List<WebElement> labelsOldStyle;
	
	@FindByExcel
	public List<WebElement> questions;
	
	@FindByExcel
	public WebElement firstQuesTitle;
	
	@FindByExcel
	public List<WebElement> notice;
	
	
	public SOHomeExcelPO(WebDriver driver) throws InterruptedException {

		FileElementLocatorFactory felf = new FileElementLocatorFactory(driver, new ExcelFileProcessor());
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

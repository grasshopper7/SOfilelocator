package sotest.test.excel;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import sotest.base.BaseTest;
import sotest.driver.ThreadWebDriver;
import sotest.po.excel.SOHomeExcelPO;

public class SOHomeExcelTest extends BaseTest {

	@Test
	public void testHomeElements() throws InterruptedException {
		ThreadWebDriver.get().manage().window().maximize();
		ThreadWebDriver.get().get("https://stackoverflow.com/");
		
		SOHomeExcelPO page = new SOHomeExcelPO(ThreadWebDriver.get());
		
		assertEquals("WebElement name tag is wrong.", "input", page.name.getTagName());
		assertEquals("WebElement name attribute name is wrong.", "inline-display-name", page.name.getAttribute("name"));
		assertEquals("WebElement name attribute class is wrong.", "f-input", page.name.getAttribute("class"));
		
		assertEquals("WebElement email tag is wrong.", "input", page.email.getTagName());
		assertEquals("WebElement email attribute name is wrong.", "inline-email", page.email.getAttribute("name"));
		assertEquals("WebElement email attribute class is wrong.", "f-input", page.email.getAttribute("class"));
		
		assertEquals("WebElement password tag is wrong.", "input", page.password.getTagName());
		assertEquals("WebElement password attribute name is wrong.", "inline-password", page.password.getAttribute("name"));
		assertEquals("WebElement password attribute class is wrong.", "js-inline-signup f-input", page.password.getAttribute("class"));
		
		assertEquals("WebElement labels size is wrong.", 3, page.labels.size());
		assertEquals("WebElement label tag is wrong.", "label", page.labels.get(0).getTagName());
		assertEquals("WebElement labels attribute class is wrong.", "g-col -fill", page.labels.get(0).getAttribute("class"));
		
		assertEquals("WebElement search tag is wrong.", "input", page.search.getTagName());
		assertEquals("WebElement search attribute class is wrong.", "f-input js-search-field ", page.search.getAttribute("class"));
		assertEquals("WebElement search attribute type is wrong.", "text", page.search.getAttribute("type"));
		
		assertEquals("WebElement soglobe tag is wrong.", "span", page.soglobe.getTagName());
		assertEquals("WebElement soglobe text is wrong.", "Stack Overflow", page.soglobe.getText());
		
		assertEquals("WebElement login tag is wrong.", "a", page.login.getTagName());
		assertEquals("WebElement login class is wrong.", "login-link s-btn btn-topbar-clear py8", page.login.getAttribute("class"));
		assertEquals("WebElement login text is wrong.", "Log In", page.login.getText());
		
		assertEquals("WebElement signup tag is wrong.", "a", page.signup.getTagName());
		assertEquals("WebElement signup class is wrong.", "login-link s-btn s-btn__primary py8 btn-topbar-primary", page.signup.getAttribute("class"));
		assertEquals("WebElement signup text is wrong.", "Sign Up", page.signup.getText());
		
		assertEquals("WebElement tags tag is wrong.", "a", page.tags.getTagName());
		assertEquals("WebElement tags class is wrong.", " js-gps-track nav-links--link", page.tags.getAttribute("class"));
		assertEquals("WebElement tags text is wrong.", "Tags", page.tags.getText().trim());
		
		assertEquals("WebElement users tag is wrong.", "a", page.users.getTagName());
		assertEquals("WebElement users class is wrong.", " js-gps-track nav-links--link", page.users.getAttribute("class"));
		assertEquals("WebElement users text is wrong.", "Users", page.users.getText());
		
		assertEquals("WebElement passwordOldStyle tag is wrong.", "input", page.passwordOldStyle.getTagName());
		assertEquals("WebElement passwordOldStyle attribute name is wrong.", "inline-password", page.passwordOldStyle.getAttribute("name"));
		assertEquals("WebElement passwordOldStyle attribute class is wrong.", "js-inline-signup f-input", page.passwordOldStyle.getAttribute("class"));
		
		assertEquals("WebElement labelsOldStyle size is wrong.", 3, page.labelsOldStyle.size());
		assertEquals("WebElement labelOldStyle tag is wrong.", "label", page.labelsOldStyle.get(0).getTagName());
		assertEquals("WebElement labelsOldStyle attribute class is wrong.", "g-col -fill", page.labelsOldStyle.get(0).getAttribute("class"));
		
		assertThat("WebElement questions size is wrong.", page.questions, hasSize(greaterThan(50)));
		
		assertEquals("WebElement firstQues tag is wrong.", "a", page.firstQuesTitle.getTagName());
		assertEquals("WebElement firstQues class is wrong.", "question-hyperlink", page.firstQuesTitle.getAttribute("class"));
	}
}

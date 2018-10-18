package sotest.test.properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import sotest.base.BaseTest;
import sotest.driver.ThreadWebDriver;
import sotest.po.properties.SOHomePropertiesPO;
import sotest.po.properties.SOQuestionPropertiesPO;

import static org.hamcrest.Matchers.*;

public class SOQuestionPropertiesTest extends BaseTest {

	@Test
	public void testQuestionElements() throws InterruptedException {
		ThreadWebDriver.get().manage().window().maximize();
		ThreadWebDriver.get().get("https://stackoverflow.com/");
		
		SOHomePropertiesPO homePage = new SOHomePropertiesPO(ThreadWebDriver.get());
		homePage.viewFirstQuestionDetails();
		
		SOQuestionPropertiesPO quesPage = new SOQuestionPropertiesPO(ThreadWebDriver.get());

		assertEquals("WebElement title tag is wrong.", "a", quesPage.title.getTagName());
		assertThat("Title cannot be empty or zero length.", quesPage.title.getText(), not(isEmptyString()));
		
		assertEquals("WebElement vote tag is wrong.", "span", quesPage.vote.getTagName());
		assertThat("Vote cannot be empty or zero length.", quesPage.vote.getText(), not(isEmptyString()));
		
		assertEquals("WebElement user tag is wrong.", "div", quesPage.user.getTagName());
		assertThat("User cannot be empty or zero length.", quesPage.user.getText(), not(isEmptyString()));
		
		assertEquals("WebElement rep tag is wrong.", "span", quesPage.rep.getTagName());
		assertThat("Reputation cannot be empty or zero length.", quesPage.rep.getText(), not(isEmptyString()));
		
		assertEquals("WebElement tags tag is wrong.", "a", quesPage.tags.get(0).getTagName());
		assertThat("Tag count should not be zero.", quesPage.tags, hasSize(greaterThan(0)));
		
		assertEquals("WebElement badges tag is wrong.", "span", quesPage.badges.get(0).getTagName());
		assertThat("Badges count should not be zero.", quesPage.badges, hasSize(greaterThan(0)));
		
	}
}

package sotest.test.properties;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import file.pagefactory.FieldByCache;
import sotest.base.BaseTest;
import sotest.driver.ThreadWebDriver;
import sotest.po.properties.SOHomePropertiesPO;
import sotest.po.properties.SOTagPropertiesPO;

public class SOTagPropertiesTest extends BaseTest {

	@Test
	public void testHomeElements() throws InterruptedException {
		ThreadWebDriver.get().manage().window().maximize();
		ThreadWebDriver.get().get("https://stackoverflow.com/");

		SOHomePropertiesPO homePage = new SOHomePropertiesPO(ThreadWebDriver.get());
		homePage.viewTagDetails();

		SOTagPropertiesPO tagPage = new SOTagPropertiesPO(ThreadWebDriver.get());

		assertThat("Definition of tag cannot be empty or zero length.", tagPage.tagdef.getText(), not(isEmptyString()));
		assertEquals("Definition of tag is wrong.",
				"A tag is a keyword or label that categorizes your question with other, similar questions. "
						+ "Using the right tags makes it easier for others to find and answer your question.",
				tagPage.tagdef.getText());

		assertThat("Number of displayed tags needs to be 36.", tagPage.tagsdisp, hasSize(36));
		assertThat("Tags should be present.", tagPage.displayedTagsText(), Matchers.hasItems("javascript", "java"));

		tagPage.selectNameOption();

		assertThat("Number of displayed tags needs to be 36.", tagPage.tagsdisp, hasSize(36));
		assertThat("Tags should be present.", tagPage.displayedTagsText(), Matchers.hasItems(".a", ".ajax"));
	}
}

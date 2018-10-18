package sotest.test.json;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import sotest.base.BaseTest;
import sotest.driver.ThreadWebDriver;
import sotest.po.json.SOHomeJsonPO;
import sotest.po.json.SOTagJsonPO;

public class SOTagJsonTest extends BaseTest {

	@Test
	public void testHomeElements() throws InterruptedException {
		ThreadWebDriver.get().manage().window().maximize();
		ThreadWebDriver.get().get("https://stackoverflow.com/");

		SOHomeJsonPO homePage = new SOHomeJsonPO(ThreadWebDriver.get());
		homePage.viewTagDetails();

		SOTagJsonPO tagPage = new SOTagJsonPO(ThreadWebDriver.get());

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

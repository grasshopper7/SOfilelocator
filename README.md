Refer here for a detailed explanation of the framework used - https://grasshopper.tech/220/

A sample implementation using the mechanism of storing an accessing locator data from files like excel, json and properties. This automates basic workflow of the StackOverflow (valid as of 22nd October 2018) website. All three file storage formats are implemented. It looks at the following three cases –

	navigates and tests components of the home page. (Xls PO and Test)
	navigates to home page and clicks on first available question to display details. (Xls PO and Test)
	navigates to home page clicks on tags menu to display details and sort tag names. (Xls PO and Test)

It is setup to run in parallel using Chrome. Feel free to change it to run serially or on your favorite browser by adding the desired driver location as system property to the surefire plugin configuration in pom.xml.



Refer here for repository details - [![Maven Central](https://maven-badges.herokuapp.com/maven-central/tech.grasshopper/findbyfilewebelement/badge.svg)](https://maven-badges.herokuapp.com/maven-central/tech.grasshopper/findbyfilewebelement)

Refer here for a detailed explanation of the framework - http://grasshopper.tech/220/

Refer here for source code - https://github.com/grasshopper7/findbyfilewebelement

package com.yt.scripts;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.Arrays;
import java.util.List;

public class InteractWithDropdowns {

	public static void main(String[] args) {
		
		String selectURL = "https://www.testmuai.com/selenium-playground/select-dropdown-demo/";
		String jqueryURL = "https://www.testmuai.com/selenium-playground/jquery-dropdown-search-demo/";
		
		// Launch Browser
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate(selectURL);
		Locator dayDropDownList = page.locator("select#select-demo");
		Locator result = page.locator("//p[@class='selected-value text-size-14']");
		
		// Select by value
		/*dayDropDownList.selectOption("Thursday");
		page.waitForTimeout(5000);
		assertThat(result).containsText("Thursday");
		page.waitForTimeout(3000);
		
		// Select by label
		dayDropDownList.selectOption(new SelectOption().setValue("Friday"));
		System.out.println(result.textContent());
		assertThat(result).containsText("Friday");
		page.waitForTimeout(3000);
		
		// Select by Index
		dayDropDownList.selectOption(new SelectOption().setIndex(06));*/
		
		// Select by multiple
		/*Locator states = page.locator("//select[@id='multi-select']");
		states.selectOption(new String[] {"New Jersey","Texas"});
		
		Locator options = states.locator("option");
		page.waitForTimeout(3000);
		System.out.println(options.count());
		List<String> allInnerTexts = options.allInnerTexts();
		allInnerTexts.forEach(option -> System.out.println(option));*/
		
		page.navigate(jqueryURL);
		Locator country = page.locator("span.select2-container").first();
		country.click();
		Locator list = page.locator("span.select2-results ul li",new Page.LocatorOptions().setHasText("Denmark"));
		list.click();
		page.waitForTimeout(3000);
		Locator files = page.locator("//select[@name='files']");
		files.selectOption("Java");
		page.waitForTimeout(3000);
		page.context().browser().close();
	}

}

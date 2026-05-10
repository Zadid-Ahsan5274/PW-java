package com.yt.scripts;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LaunchBrowser {
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		//Browser browser = playwright.chromium().launch();
		//Browser browser = playwright.firefox().launch();
		//Browser browser = playwright.webkit().launch();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		page.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
		Locator myAccount = page.locator("//a[@role='button']//span[@class='title'][normalize-space()='My account']");
		myAccount.hover();
		page.waitForTimeout(3000);
		page.click("//span[normalize-space()='Login']");
		assertThat(page).hasTitle("Account Login");
		page.getByPlaceholder("E-Mail Address").type("zadidahsan1@gmail.com");
		page.getByPlaceholder("Password").type("12345678");
		page.locator("//input[@type='submit']").click();
		assertThat(page).hasTitle("My Account");
		page.context().browser().close();
		playwright.close();
	}
}

package com.yt.scripts;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class InteractWithInputs {
	
	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		/*page.navigate("https://www.testmuai.com/selenium-playground/simple-form-demo/");
		page.waitForTimeout(5000);
		page.locator("//input[@id='user-message']").nth(0).type("Hey Tester",new Locator.TypeOptions().setTimeout(300));
		page.waitForTimeout(5000);
		page.locator("//button[@id='showInput']").nth(0).click();
		page.waitForTimeout(5000);
		String message = page.locator("//p[@id='message']").nth(0).textContent();
		System.out.println(message);
		assertThat(page.locator("//p[@id='message']")).containsText("Hey Tester");
		
		page.navigate("https://www.testmuai.com/selenium-playground/generate-file-to-download-demo/");
		page.click("//textarea[@id='textbox']");
		page.waitForTimeout(2000);
		page.fill("//textarea[@id='textbox']","Enter Data: 500 characters remaining");
		
		page.navigate("https://letcode.in/edit");
		page.waitForTimeout(3000);
		String inputValue = page.locator("input#getMe").inputValue();
		System.out.println(inputValue);
		String placeHolder = page.locator("input#fullName").getAttribute("placeholder");
		System.out.println(placeHolder);
		Locator fullNameLocator = page.locator("input#fullName");
		assertThat(fullNameLocator).hasAttribute("placeholder", "Enter first & last name");
		page.locator("#clearMe").clear();
		page.waitForTimeout(3000);*/
		
		page.navigate("https://www.testmuai.com/selenium-playground/checkbox-demo/");
		Locator isAge = page.getByRole(AriaRole.CHECKBOX).nth(0);
		assertThat(isAge).not().isChecked();
		isAge.check();
		page.waitForTimeout(3000);
		assertThat(isAge).not().isChecked();
		page.waitForTimeout(3000);
		page.context().browser().close();
	}
}

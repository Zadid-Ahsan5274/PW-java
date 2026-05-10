package com.yt.scripts;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LearnWindowHandling {
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.testmuai.com/selenium-playground/window-popup-modal-demo/");
		Page popup = page.waitForPopup(() -> {
			page.locator("//a[normalize-space()='Follow On Twitter']").click();
			
		}
		);
		popup.waitForLoadState();
		assertThat(page).hasTitle("LambdaTest (@lambdatesting) / Twitter");
		System.out.println(popup.title());
		
	}
}

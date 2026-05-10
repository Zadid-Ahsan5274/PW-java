package com.yt.scripts;

import java.nio.file.Paths;
import java.util.Arrays;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.options.ScreenshotCaret;

public class LearnScreenshots {

	public static void main(String[] args) {
		    Playwright playwright = Playwright.create();
			Browser browser = playwright.chromium().launch();
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://www.testmuai.com/selenium-playground/simple-form-demo/");
			
			// create Screenshot object
			ScreenshotOptions screenshotOptions = new ScreenshotOptions();
			
			// Taking specific screenshot
			page.screenshot(screenshotOptions.setPath(Paths.get("./snaps/scr.png")));
			
			// full page screenshot
			page.screenshot(screenshotOptions.setFullPage(true).setPath(Paths.get("./snaps/scr_fullPage.jpg")));
			
			// locator screenshot
			Locator bookButton = page.locator("//button[text()='Book a Demo']").nth(1);
			bookButton.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./snaps/scr_locator.jpg")));
			
			Locator header = page.locator("#chfw-header");
			header.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("./snaps/scr_region.jpg")));
			
			// Masking Locator
			Locator user_input_message = page.locator("#user-message").nth(0);
			user_input_message.type("something");
			user_input_message.scrollIntoViewIfNeeded();
			//page.screenshot(screenshotOptions.setFullPage(false).setMask(Arrays.asList(user_input_message).setPath(Paths.get("./snaps/scr_userinput.jpg"))));
			page.screenshot(new Page.ScreenshotOptions()
				    .setFullPage(false)
				    .setMask(Arrays.asList(user_input_message))
				    .setPath(Paths.get("./snaps/scr_userinput.jpg")));
			
			// Caret show/hide
			user_input_message.click();
			page.screenshot(new ScreenshotOptions().setCaret(ScreenshotCaret.HIDE).setPath(Paths.get("./snaps/scr_caretHIDE.jpg")));
			page.screenshot(new ScreenshotOptions().setCaret(ScreenshotCaret.INITIAL).setPath(Paths.get("./snaps/scr_caretINITIAL.jpg")));
			// Closing browser
			page.context().browser().close();
			playwright.close();

	}
	
}

package com.yt.scripts;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LearnFrames {
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		//Browser browser = playwright.firefox().launch();
		//Browser browser = playwright.webkit().launch();
		//Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		
		/*page.navigate("https://demo.automationtesting.in/Frames.html");
		FrameLocator frameLocator = page.frameLocator("//iframe[@id='singleframe']");
		Locator bodyLocator = frameLocator.locator("//input[@type='text']");
		bodyLocator.click();
		bodyLocator.clear();
		bodyLocator.fill("Hey inside frame");*/
		
		page.navigate("https://letcode.in/frame");
		List<Frame> frames = page.frames();
		System.out.println("Number of frames available: "+frames.size());
		//frames.forEach(frame -> System.out.println(frame.url()));
		FrameLocator firstFrame = page.frameLocator("#firstFr");
		firstFrame.getByPlaceholder("Enter name").type("Koushik");
		FrameLocator nestedFrame = firstFrame.frameLocator("iframe.has-background-white");
		nestedFrame.getByPlaceholder("Enter email").type("koushik@mail.com");
		//playwright.close();
	}
}

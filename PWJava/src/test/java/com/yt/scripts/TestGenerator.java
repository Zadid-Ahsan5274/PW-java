package com.yt.scripts;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;

import com.microsoft.playwright.options.*;

public class TestGenerator {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext(new Browser.NewContextOptions()
		                .setRecordVideoDir(Paths.get("./videos/")).setRecordVideoSize(new RecordVideoSize(1280, 720)));
		      Page page = context.newPage();
		      page.navigate("https://ecommerce-playground.lambdatest.io/");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("My account")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail Address")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("E-Mail Address")).fill("zadidahsan1@gmail.com");
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
		      page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("12345678");
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Edit Account")).click();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
		      page.getByText("Success: Your account has").click();
		      page.getByText("Success: Your account has").click();
		      page.getByText("Success: Your account has").click();
		      assertThat(page.getByText("Success: Your account has")).isVisible();
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("My account")).click();
		      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout").setExact(true)).click();
		    }
		
	}
}
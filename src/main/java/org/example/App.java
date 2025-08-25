package org.example;

import com.microsoft.playwright.*;
import java.nio.file.Paths;
public class App {
    public static void main(String[] args)
    {
        Playwright playwright = Playwright.create();
        Browser browser  = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

       // Page page = browser.newPage();
        BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                .setHttpCredentials("admin", "admin"));
        Page page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/basic_auth");
        page.onDialog(dialog -> System.out.println(dialog.message()));

        String title = page.title();
        System.out.println("Page Title:"+title);
        page.close();
        playwright.close();

    }
}
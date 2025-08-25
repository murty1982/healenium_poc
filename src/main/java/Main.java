import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.options.LoadState;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Main {
    @Test
    void test1(){
        System.out.println("Hello world!");




                try (Playwright playwright = Playwright.create()) {
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                BrowserContext context = browser.newContext();
                context.tracing().start(
                        new Tracing.StartOptions().setScreenshots(true)
                                .setSnapshots(true)
                                .setSources(true)
                );

                Page page = browser.newPage();
                page.navigate("https://www.youtube.com/shorts/NM52GebndjY");
                page.waitForLoadState(LoadState.DOMCONTENTLOADED);
                page.locator("(//button[@title='Play'])[1]").click();
                Thread.sleep(10000);
                browser.close();
                context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
                context.close();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


//            // Expect a title "to contain" a substring.
//            assertThat(page).hasTitle(Pattern.compile("Playwright"));
//
//            // create a locator
//            Locator getStarted = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get Started"));
//
//            // Expect an attribute "to be strictly equal" to the value.
//            assertThat(getStarted).hasAttribute("href", "/docs/intro");
//
//            // Click the get started link.
//            getStarted.click();
//
//            // Expects page to have a heading with the name of Installation.
//            assertThat(page.getByRole(AriaRole.HEADING,
//                    new Page.GetByRoleOptions().setName("Installation"))).isVisible();
//            browser.close();

    }
}
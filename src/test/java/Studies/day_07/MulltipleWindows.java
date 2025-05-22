package Studies.day_07;

import Studies.Pages.F4eAppPage;
import com.microsoft.playwright.*;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class MulltipleWindows {
    @Test
    public void test() throws InterruptedException {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        F4eAppPage f4eAppPage = new F4eAppPage(page);
        page.navigate("https://f4e.app/tr/");
        f4eAppPage.getAcceptButton().click();
        ReusableMethods.scrollToElement(f4eAppPage.getLinkedin());
        Page newPage = context.waitForPage(() -> {
            f4eAppPage.getLinkedin().click();
        });
        System.out.println("newPage.title() = " + newPage.title());
        Thread.sleep(1000);
        f4eAppPage.getLinkedin().click();
        Thread.sleep(1000);
        page.bringToFront();
        System.out.println("page.title() = " + page.title());
        Thread.sleep(1000);
        newPage.bringToFront();
        Thread.sleep(1000);
     //  newPage.close();
     //  Thread.sleep(1000);
     //  page.close();
     //  context.close();
     //  browser.close();


    }
}

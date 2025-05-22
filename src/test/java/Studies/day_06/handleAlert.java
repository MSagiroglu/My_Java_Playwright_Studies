package Studies.day_06;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class handleAlert {
    @Test
    public void handleAlertTest() throws InterruptedException {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.onDialog(dialog -> {
            String msg = dialog.message();
            System.out.println("msg = " + msg);
            Assert.assertTrue(msg.contains("I am a JS Alert"));
            dialog.accept();
        });
        page.locator("//button[normalize-space(text())='Click for JS Alert']").click();


        String result = page.locator("id=result").textContent();
        System.out.println("result = " + result);
        Assert.assertEquals(result, "You successfully clicked an alert");

        Thread.sleep(3000);

    }

    @Test
    public void handleAlertTest2() throws InterruptedException {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.onDialog(dialog -> {
            String message = dialog.message();
            System.out.println("msg = " + message);
            Assert.assertTrue(message.contains("I am a JS Confirm"));
            dialog.accept();
        });
        page.locator("//button[normalize-space(text())='Click for JS Confirm']").click();
    }

    @Test
    public void handleAlertTest3() throws InterruptedException {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        page.onDialog(dialog -> {
            String message2 = dialog.message();
            System.out.println("msg = " + message2);
            Assert.assertTrue(message2.contains("I am a JS Confirm"));
            dialog.dismiss();
        });
        page.locator("//button[normalize-space(text())='Click for JS Confirm']").click();
        Thread.sleep(3000);
        String result2 = page.locator("id=result").textContent();
        System.out.println("result = " + result2);
        Assert.assertEquals(result2, "You clicked: Cancel");
    }
    @Test
    public void handleAlertTest4() throws InterruptedException {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        String txt ="Mustafa SAĞIROĞLU is the best QA Engineer";
        page.onDialog(dialog -> {
            String message2 = dialog.message();
            System.out.println("msg = " + message2);
            Assert.assertTrue(message2.contains("I am a JS prompt"));
            dialog.accept(txt);
        });
        page.locator("//button[normalize-space(text())='Click for JS Prompt']").click();
        Thread.sleep(3000);
        String result2 = page.locator("id=result").textContent();
        System.out.println("result = " + result2);
        Assert.assertEquals(result2, "You entered: " +txt);
    }
}

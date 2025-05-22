package Studies.day_06;

import Studies.Pages.HerOkuAppPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class HandleAlertsReusableMethods {
    @Test
    public void handleAlertTest() throws InterruptedException {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();
        HerOkuAppPage herOkuAppPage = new HerOkuAppPage(page);
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        ReusableMethods.acceptAlert(page, herOkuAppPage.getJSAlert(), "I am a JS Alert");
        Thread.sleep(3000);
        String result =herOkuAppPage.getJSResult().innerText();
        System.out.println("result = " + result);
        Assert.assertEquals(result, "You successfully clicked an alert");

    }
    @Test
    public void handleAlertTest2() throws InterruptedException {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();
        HerOkuAppPage herOkuAppPage = new HerOkuAppPage(page);
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        ReusableMethods.dismissAlert(page, herOkuAppPage.getJSConfirm(), "I am a JS Confirm");
        Thread.sleep(3000);
        String result =herOkuAppPage.getJSResult().innerText();
        System.out.println("result = " + result);
        Assert.assertEquals(result, "You clicked: Cancel");
    }

    @Test
    public void handleAlertTest3() throws InterruptedException {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();
        HerOkuAppPage herOkuAppPage = new HerOkuAppPage(page);
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        String txt ="Mustafa SAĞIROĞLU is the best QA Engineer";
        ReusableMethods.promptAlert(page, herOkuAppPage.getJSPrompt(), "I am a JS prompt", txt);
        Thread.sleep(3000);
        String result =herOkuAppPage.getJSResult().innerText();
        System.out.println("result = " + result);
        Assert.assertEquals(result, "You entered: " +txt);
    }



}

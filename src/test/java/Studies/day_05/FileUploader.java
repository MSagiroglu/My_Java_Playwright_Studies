package Studies.day_05;


import Studies.Pages.GooglePage;
import Studies.Pages.HerOkuAppPage;
import com.github.javafaker.Faker;
import com.microsoft.playwright.*;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.nio.file.Path;

public class FileUploader {

   @Test
    public void test() throws InterruptedException {
       Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
       Page page = browser.newPage();
       page.navigate("https://demoqa.com/upload-download");
       page.locator("#uploadFile").setInputFiles(Path.of(System.getProperty("user.dir")+"/src/UploadFiles/Ekran görüntüsü 2025-04-30 133242.png"));
       Thread.sleep(3000);
       System.out.println("Test Sonucu Başarılıdır.");
       page.close();
       browser.close();
   }
    @Test
    public void test2() throws InterruptedException {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/upload");
        page.locator("#file-upload").setInputFiles(Path.of(System.getProperty("user.dir")+"/src/UploadFiles/Ekran görüntüsü 2025-04-30 133242.png"));
        Thread.sleep(3000);
        System.out.println("Test Sonucu Başarılıdır.");
        page.close();
        browser.close();
    }
    @Test
    public void test3() throws InterruptedException {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();
        HerOkuAppPage herOkuAppPage = new HerOkuAppPage(page);
        page.navigate("https://the-internet.herokuapp.com/upload");
        ReusableMethods.uploadFile(herOkuAppPage.getdosyaSec(), "Ekran görüntüsü 2025-04-30 133242.png");
        Thread.sleep(3000);
        System.out.println("Test Sonucu Başarılıdır.");
        page.close();
        browser.close();
    }
    @Test
    public void test4() throws InterruptedException {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();
        HerOkuAppPage herOkuAppPage = new HerOkuAppPage(page);
        page.navigate("https://the-internet.herokuapp.com/upload");
        Path [] files = {
                Path.of(System.getProperty("user.dir")+"/src/UploadFiles/Ekran görüntüsü 2025-04-30 133242.png")

        };
        ReusableMethods.uploadFile(herOkuAppPage.getdosyaSec(), files);
        Thread.sleep(3000);
        ReusableMethods.clearFiles(herOkuAppPage.getdosyaSec());
        System.out.println("Test Sonucu Başarılıdır.");
        page.close();
        browser.close();
    }




}

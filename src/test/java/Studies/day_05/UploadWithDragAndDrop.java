package Studies.day_05;

import Studies.Pages.HerOkuAppPage;
import com.microsoft.playwright.*;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadWithDragAndDrop {
    @Test
    public void test() throws InterruptedException {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();
        HerOkuAppPage herOkuAppPage = new HerOkuAppPage(page);
        page.navigate("https://the-internet.herokuapp.com/upload");
        FileChooser fileChooser = page.waitForFileChooser(() -> herOkuAppPage.getUploadFilesArea().click());
        fileChooser.setFiles(Paths.get(System.getProperty("user.dir") + "/src/UploadFiles/Ekran görüntüsü 2025-04-30 133242.png"));
        Thread.sleep(3000);
        System.out.println("Test Sonucu Başarılıdır.");
        page.close();
        browser.close();
    }

    @Test
    public void test2() throws InterruptedException {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();
        HerOkuAppPage herOkuAppPage = new HerOkuAppPage(page);
        page.navigate("https://the-internet.herokuapp.com/upload");
        ReusableMethods.dragAndDropUploadFile(page, herOkuAppPage.getUploadFilesArea(), "Ekran görüntüsü 2025-04-30 133242.png");
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
        Path[] files = {
                Paths.get(System.getProperty("user.dir") + "/src/UploadFiles/Ekran görüntüsü 2025-04-30 133242.png"),
                Paths.get(System.getProperty("user.dir") + "/src/UploadFiles/Ekran görüntüsü 2025-04-30 1332422.png"),
                Paths.get(System.getProperty("user.dir") + "/src/UploadFiles/Ekran görüntüsü 2025-04-30 13324222.png")
        };

        FileChooser fileChooser = page.waitForFileChooser(() -> herOkuAppPage.getUploadFilesArea().click());

        fileChooser.setFiles(files);
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
        Path[] files = {
                Paths.get(System.getProperty("user.dir") + "/src/UploadFiles/Ekran görüntüsü 2025-04-30 133242.png"),
                Paths.get(System.getProperty("user.dir") + "/src/UploadFiles/Ekran görüntüsü 2025-04-30 1332422.png"),
                Paths.get(System.getProperty("user.dir") + "/src/UploadFiles/Ekran görüntüsü 2025-04-30 13324222.png")
        };

        ReusableMethods.dragAndDropUploadFile(page, herOkuAppPage.getUploadFilesArea(), files);
        Thread.sleep(3000);
        System.out.println("Test Sonucu Başarılıdır.");
        page.close();
        browser.close();
    }
}

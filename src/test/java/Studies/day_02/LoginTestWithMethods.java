package Studies.day_02;

import Studies.Pages.LoginPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import utilities.ConfigReader;

public class LoginTestWithMethods {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <4 ; i++) {


        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        Page page = browser.newPage();

        // LoginPage sınıfını kullanarak işlemleri çağır
        LoginPage loginPage = new LoginPage(page);

        // Sayfaya git
        page.navigate(ConfigReader.getProperty("baseUrl"));
        //page.waitForLoadState();// sayfa yüklendikten sonra devam etmesi için


        // Login işlemleri
        loginPage.enterUsername(ConfigReader.getProperty("username"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        loginPage.clickLogin();

        // Şirket seçme işlemi
        loginPage.selectCompany();

        // İkinci şifre giriş ekranı
        loginPage.enterSecondPassword(ConfigReader.getProperty("password"));
        loginPage.confirmLogin();
        Thread.sleep(2000);

        // Sayfayı kapat
        page.close();
        browser.close();
        pw.close();
    }
    }
}

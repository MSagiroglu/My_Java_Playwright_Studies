package Studies.day_03;

import Studies.Pages.LoginPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class GetTextAndAssert {
    @Test
    public void getTextAndAssert() {
        Playwright pw = Playwright.create();
        Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        Page page = browser.newPage();

        // LoginPage sınıfını kullanarak işlemleri çağır
        LoginPage loginPage = new LoginPage(page);

        // Sayfaya git
        page.navigate(ConfigReader.getProperty("baseUrl"));
        //page.waitForLoadState();// sayfa yüklendikten sonra devam etmesi için


        // Login işlemleri
        System.out.println("Email Text: "+ReusableMethods.getElementText1(loginPage.getUsernameField()));
        loginPage.enterUsername(ConfigReader.getProperty("username"));
        System.out.println("Password Text: "+ReusableMethods.getElementText1(loginPage.getPasswordField()));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        ReusableMethods.assertThat(loginPage.getLoginButton(),ConfigReader.getProperty("LoginButtonText"));

        loginPage.clickLogin();

        // Şirket seçme işlemi
        System.out.println("Company Text: "+ReusableMethods.getElementText1(loginPage.getCompanyDropdown()));
        loginPage.selectCompany();
        ReusableMethods.assertThat(loginPage.getQaCompanyOption(),ConfigReader.getProperty("QaCompanyText"));

        // İkinci şifre giriş ekranı
        loginPage.enterSecondPassword(ConfigReader.getProperty("password"));
        loginPage.confirmLogin();

        // Sayfayı kapat
        page.close();
        browser.close();
        pw.close();
    }
}

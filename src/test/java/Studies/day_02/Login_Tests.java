package Studies.day_02;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

public class Login_Tests {
    public static void main(String[] args) {
            // Playwright'i başlat
            Playwright pw = Playwright.create();
            Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            Page page = browser.newPage();

            // Sayfaya git
            page.navigate("https://www.feedback4e.com/Login");

            // Kullanıcı adı ve şifreyi gir
            fillText(page.locator("xpath=(//input[@id='UserName'])[1]"), "mustafasagiroglu@feedback4e.com");
            fillText(page.locator("xpath=//*[@id=\"Password\"]"), "Admin_01");

            // Giriş butonuna tıkla
            clickButton(page.locator("id=emailLoginSubmitButton"));

            // Şirket seçimi dropdown'unu aç
            clickButton(page.locator("xpath=//div[@class='custom-dropdown']"));

            // "QA COMPANY" seçeneğini seç
            selectDropdownOption(page.locator("xpath=//div[normalize-space(text())='QA COMPANY']"));

            // İkinci şifre giriş ekranında şifreyi tekrar gir
            fillText(page.locator("id=Password"), "Admin_01");

            // Şifre ile giriş yap butonuna tıkla
            clickButton(page.locator("xpath=//button[@id='passwordLoginSubmitButton']"));

            // Sayfayı ve tarayıcıyı kapat
            page.close();
            browser.close();
            pw.close();
        }

        // Metin kutusuna veri girme metodu (Sadece element alır)
        public static void fillText(Locator element, String value) {
            element.fill(value);
        }

        // Dropdown'dan eleman seçme metodu (Sadece element alır)
        public static void selectDropdownOption(Locator element) {
            element.click();
        }

        // Butona tıklama metodu (Sadece element alır)
        public static void clickButton(Locator element) {
            element.click();
        }


}

package Studies.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utilities.ReusableMethods;

public class LoginPage {
    private final Page page;

    public Locator getUsernameField() {
        return usernameField;
    }

    public Locator getPasswordField() {
        return passwordField;
    }

    public Locator getLoginButton() {
        return loginButton;
    }

    public Locator getQaCompanyOption() {
        return qaCompanyOption;
    }

    public Locator getCompanyDropdown() {
        return companyDropdown;
    }

    public Locator getSecondPasswordField() {
        return secondPasswordField;
    }

    public Locator getPasswordLoginButton() {
        return passwordLoginButton;
    }

    // **Sayfa içindeki HTML elementlerini temsil eden Locator değişkenleri**
    private final Locator usernameField; // Kullanıcı adı giriş alanı
    private final Locator passwordField; // Şifre giriş alanı
    private final Locator loginButton; // Giriş butonu
    private final Locator companyDropdown; // Şirket seçimi dropdown elementi
    private final Locator qaCompanyOption; // Dropdown içindeki "QA COMPANY" seçeneği
    private final Locator secondPasswordField; // İkinci şifre giriş alanı (Şirket seçimi sonrası)
    private final Locator passwordLoginButton; // İkinci şifre girişinden sonra giriş butonu

    // **Constructor: Sayfa yüklenirken tüm locator nesnelerini başlatıyoruz**
    public LoginPage(Page page) {
        this.page = page;

        // Kullanıcı adı giriş alanını belirtiyoruz (XPath ile)
        this.usernameField = page.locator("xpath=(//input[@id='UserName'])[1]");

        // Şifre giriş alanını belirtiyoruz
        this.passwordField = page.locator("xpath=//*[@id=\"Password\"]");

        // İlk giriş ekranındaki "Giriş Yap" butonu
        this.loginButton = page.locator("id=emailLoginSubmitButton");

        // Şirket seçimi için kullanılan dropdown elementi
        this.companyDropdown = page.locator("xpath=//div[@class='custom-dropdown']");

        // Dropdown içinde "QA COMPANY" seçeneğini temsil eden locator
        this.qaCompanyOption = page.locator("xpath=//div[normalize-space(text())='QA COMPANY']");

        // Şirket seçimi sonrası gelen ikinci şifre alanı
        this.secondPasswordField = page.locator("id=Password");

        // İkinci şifre ekranındaki giriş butonu
        this.passwordLoginButton = page.locator("xpath=//button[@id='passwordLoginSubmitButton']");
    }

    // **Metin kutusuna veri girme metodu**
    // Kullanıcı adı alanına girilen metni doldurur
    public void enterUsername(String username) {
        ReusableMethods.enterText(usernameField, username);
    }

    // Şifre alanına girilen metni doldurur
    public void enterPassword(String password) {
        ReusableMethods.enterText(passwordField, password);
    }

    // **Butona tıklama metodları**
    // Kullanıcının ilk giriş ekranındaki "Giriş Yap" butonuna tıklamasını sağlar
    public void clickLogin() {
        ReusableMethods.clickElement(loginButton);
    }

    // Dropdown'u açıp "QA COMPANY" seçeneğini seçer
    public void selectCompany() {
        ReusableMethods.selectDropdown(companyDropdown, qaCompanyOption);
    }

    // İkinci şifre giriş alanına veri girer
    public void enterSecondPassword(String password) {
        ReusableMethods.enterText(secondPasswordField, password);
    }

    // İkinci şifre ekranındaki giriş butonuna tıklar
    public void confirmLogin() {
        ReusableMethods.clickElement(passwordLoginButton);
    }}

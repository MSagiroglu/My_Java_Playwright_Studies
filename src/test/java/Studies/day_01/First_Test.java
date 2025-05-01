package Studies.day_01;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class First_Test {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create(); // Bir Playwright nesnesi oluşturun
        BrowserType browserType = playwright.chromium(); // playwright nesnesinin bir tarayıcı türü oluşturun ve browser değişkenine atayın
        //Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge").setSlowMo(50));// Tarayıcıyı başlatın ve browser değişkenine atayın headless false olarak ayarlanmış ve slowMo 50 olarak ayarlanmış ve msedge olarak ayarlanmış
        //Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setSlowMo(50)); // Tarayıcıyı başlatın ve browser değişkenine atayın headless false olarak ayarlanmış ve slowMo 50 olarak ayarlanmış ve chrome olarak ayarlanmış
        //Browser browser = browserType.launch(); // Tarayıcıyı başlatın ve browser değişkenine atayın
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));// Tarayıcıyı başlatın ve browser değişkenine atayın headless false olarak ayarlanmış ve slowMo 50 olarak ayarlanmış
        Page page = browser.newPage(); // Yeni bir sayfa oluşturun ve page değişkenine atayın
        page.navigate("https://www.feedback4e.com/Login"); // Sayfayı açın ve https://playwright.dev/ adresine gidin
        String title = page.title(); // Sayfanın başlığını alın ve title değişkenine atayın
        System.out.println("Sayfanın başlığı: " + title);
        page.close(); // Sayfayı kapatın
        browser.close(); // Tarayıcıyı kapatın
        playwright.close(); // Playwright nesnesini kapatın

    }
}

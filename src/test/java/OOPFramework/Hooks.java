package OOPFramework;
import com.microsoft.playwright.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.nio.file.Paths;

    public class Hooks {

        public static Playwright playwright;
        public static Browser browser;
        public static BrowserContext context;
        public static Page page;

        @BeforeTest
        public void setupAuthenticatedSession() {
            playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            // Oturum bilgilerini login.json'dan yükle
            context = browser.newContext(new Browser.NewContextOptions()
                    .setStorageStatePath(Paths.get("login.json")));

            page = context.newPage();
            page.navigate("https://www.feedback4e.com/Main#/homepagedashboard"); // login sonrası yönlendirilecek sayfa
        }
        @AfterTest
        public void tearDown() {
            context.close();
            browser.close();
            playwright.close();
        }

    }



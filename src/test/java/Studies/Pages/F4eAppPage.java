package Studies.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class F4eAppPage {
    private final Page page;
    private final Locator Linkedin;
    private final Locator AcceptButton;
    private final Locator HomePage;

    public F4eAppPage(Page page) {
        this.page = page;
        this.Linkedin = page.locator("//a[@href='https://www.linkedin.com/company/feedback4e/']");
        this.AcceptButton= page.locator("//button[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]");
        this.HomePage = page.locator("//a[@id=\"ember344\"]");
    }

    public Locator getLinkedin() {
        return Linkedin;
    }

    public Locator getAcceptButton() {
        return AcceptButton;
    }

    public Locator getHomePage() {
        return HomePage;
    }
}

package Studies.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class GooglePage {
    private final Page page;
    private final Locator searchBox;
    private final Locator AutoSuggestion;

    public GooglePage(Page page) {
        this.page = page;
        this.searchBox = page.locator(".gLFyf");
        this.AutoSuggestion = page.locator("//ul[@role='listbox']//li");
    }

    public Locator getSearchBox() {
        return searchBox;
    }

    public Locator getAutoSuggestion() {
        return AutoSuggestion;
    }
}

package Studies.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HerOkuAppPage {
    private final Page page;
    private final Locator dosyaSec;
    private final Locator uploadFilesArea;
    private final Locator JSAlert;
    private final Locator JSConfirm;
    private final Locator JSPrompt;
    private final Locator JSResult;

    public HerOkuAppPage(Page page) {
        this.page = page;
        this.dosyaSec = page.locator("#file-upload");
        this.uploadFilesArea = page.locator("#drag-drop-upload");
        this.JSAlert = page.locator("//button[normalize-space(text())='Click for JS Alert']");
        this.JSConfirm = page.locator("//button[normalize-space(text())='Click for JS Confirm']");
        this.JSPrompt = page.locator("//button[normalize-space(text())='Click for JS Prompt']");
        this.JSResult = page.locator("#result");

    }

    public Locator getdosyaSec() {
        return dosyaSec;
    }

    public Locator getUploadFilesArea() {
        return uploadFilesArea;
    }

    public Locator getJSAlert() {
        return JSAlert;
    }

    public Locator getJSConfirm() {
        return JSConfirm;
    }

    public Locator getJSPrompt() {
        return JSPrompt;
    }

    public Locator getJSResult() {
        return JSResult;
    }


}

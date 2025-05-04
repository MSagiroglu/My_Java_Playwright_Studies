package Studies.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HerOkuAppPage {
    private final Page page;
    private final Locator dosyaSec;
    private final Locator uploadFilesArea;

    public HerOkuAppPage(Page page) {
        this.page = page;
        this.dosyaSec = page.locator("#file-upload");
        this.uploadFilesArea = page.locator("#drag-drop-upload");

    }

    public Locator getdosyaSec() {
        return dosyaSec;
    }

    public Locator getUploadFilesArea() {
        return uploadFilesArea;
    }


}

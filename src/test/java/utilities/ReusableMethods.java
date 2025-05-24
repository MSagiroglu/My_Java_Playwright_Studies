package utilities;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.Assert;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class ReusableMethods {
    // Metin kutusuna veri girme metodu (Önce elementin görünmesini bekleyip sonra text girer)
    public static void enterText(Locator element, String text) {
        element.waitFor(); // Elementin görünmesini bekle
        element.fill(text);
    }

    // Butona tıklama metodu (Önce elementin görünmesini bekleyip sonra tıklar)
    public static void clickElement(Locator element) {
        element.waitFor(); // Elementin görünmesini bekle
        element.click();
    }

    // Dropdown'dan eleman seçme metodu (Önce dropdown'u açıp, ardından ilgili seçeneği seçer)
    public static void selectDropdown(Locator dropdownElement, Locator optionElement) {
        dropdownElement.waitFor(); // Dropdown'un yüklenmesini bekle
        dropdownElement.click(); // Dropdown'u aç
        optionElement.waitFor(); // Seçeneğin yüklenmesini bekle
        optionElement.click(); // Seçeneği seç
    }

    // Elemente ait text alma metodu 1
    public static String getElementText1(Locator element) {
        String text = element.textContent();
        return text;
    }

    // Elemente ait text alma metodu 2
    public static String getElementText2(Locator element) {
        String text = element.innerText();
        return text;
    }

    // JS ile elemente ait text alma metodu
    public static String getElementText3(Locator element) {
        String text = (String) element.evaluate("el => el.textContent");
        return text;
    }

    // Playwright'de assertThat kullanımı --> 5 sanıyeye kadar bekler sonra hata verir
    public static void assertThat(Locator element,String expectedText) {
        PlaywrightAssertions.assertThat(element).containsText(expectedText);
    }

    //Playwright de partial assert kullanımı
    public static void assertThatPartial(Locator element,String expectedText) {
        PlaywrightAssertions.assertThat(element).containsText(Pattern.compile(expectedText));
    }

    //Dosya Yükleme Metodu
    public static void uploadFile(Locator element, String filePath) {
        element.setInputFiles(Path.of(System.getProperty("user.dir")+"/src/UploadFiles/"+filePath));
    }
    //Dosya Yükleme Metodu 2
    public static void uploadFile(Locator element, Path [] files) {
        element.setInputFiles(files);
    }

    // Yüklenen dosyaları silme metodu
    public static void clearFiles(Locator element) {
        element.setInputFiles(new Path[0]);
    }

    //DragAndDrop ile Tek Dosya Yükleme Metodu
    public static void dragAndDropUploadFile(Page page, Locator element, String filePath) {
        FileChooser fileChooser = page.waitForFileChooser(() -> element.click());
        fileChooser.setFiles(Paths.get(System.getProperty("user.dir")+"/src/UploadFiles/"+filePath));

    }
    //DragAndDrop ile Çoklu Dosya Yükleme Metodu
    public static void dragAndDropUploadFile(Page page, Locator element, Path [] files) {
        FileChooser fileChooser = page.waitForFileChooser(() -> element.click());
        fileChooser.setFiles(files);
    }

    //Accept Alert Metodu
    public static void acceptAlert(Page page, Locator element,String expectedText) {
        page.onDialog(dialog -> {
            String message = dialog.message();
            System.out.println("msg = " + message);
            Assert.assertTrue(message.contains(expectedText));
            dialog.accept();
        });
        element.click();
    }
    //Dismiss Alert Metodu
    public static void dismissAlert(Page page, Locator element,String expectedText) {
        page.onDialog(dialog -> {
            String message = dialog.message();
            System.out.println("msg = " + message);
            Assert.assertTrue(message.contains(expectedText));
            dialog.dismiss();
        });
        element.click();
    }
    //Prompt Alert Metodu
    public static void promptAlert(Page page, Locator element,String expectedText,String text) {
        page.onDialog(dialog -> {
            String message = dialog.message();
            System.out.println("msg = " + message);
            Assert.assertTrue(message.contains(expectedText));
            dialog.accept(text);
        });
        element.click();
    }
    // Elemente Scroll Metodu
    public static void scrollToElement(Locator element) {
        element.scrollIntoViewIfNeeded();
    }
    // Yeni sekmenin açılmasını bekler ve tıklama işlemini yapar
    public static Page clickAndWaitForNewPage(Page currentPage, Locator elementToClick) {
        // Yeni sekmenin açılmasını bekler ve tıklama işlemini yapar
        Page newPage = currentPage.context().waitForPage(() -> {
            elementToClick.click();
        });
        // Yeni açılan sekmeyi ön plana getir
        newPage.bringToFront();
        return newPage;
    }




}

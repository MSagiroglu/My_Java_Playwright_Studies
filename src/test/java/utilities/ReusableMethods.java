package utilities;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

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


}

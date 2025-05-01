package Studies.day_04;

import Studies.Pages.GooglePage;
import com.github.javafaker.Faker;
import com.microsoft.playwright.*;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class HandleAutoSuggestions {
    Faker faker = new Faker();

    @Test
    public void test() throws InterruptedException {
        Browser browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
        Page page = browser.newPage();
        GooglePage googlePage = new GooglePage(page);

        page.navigate("https://www.google.com.tr/");
        String searchText = faker.country().name().toLowerCase();
        ReusableMethods.enterText(googlePage.getSearchBox(), searchText);
        int count = googlePage.getAutoSuggestion().count();
        System.out.println(count);
        for (int i = 0;i <count ; i++) {
            System.out.println(googlePage.getAutoSuggestion().nth(i).innerText());
            if (googlePage.getAutoSuggestion().nth(i).innerText().contains(searchText)) {
                System.out.println("Mustafa Playwright Öğrenmeye devam ediyor");

            }

        }
        page.close();
        browser.close();
    }
}

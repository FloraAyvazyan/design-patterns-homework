import ge.tbc.testautomation.pages.DemoqaPages.BooksPage;
import ge.tbc.testautomation.pages.TelerikSteps.DemosPage;
import ge.tbc.testautomation.steps.DemoqaSteps.BooksSteps;
import ge.tbc.testautomation.steps.TelerikSteps.DemosSteps;
import ge.tbc.testautomation.steps.TelerikSteps.PricingPageSteps;
import ge.tbc.testautomation.steps.TelerikSteps.YourOrderSteps;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;
@Test(groups = {"Selenide 2"})
public class SelenideTests2 extends ConfigTest {
    BooksSteps booksSteps = new BooksSteps();
    BooksPage booksPage = new BooksPage();
    DemosSteps demosSteps = new DemosSteps();
    DemosPage demosPage = new DemosPage();
    PricingPageSteps navigateToSteps = new PricingPageSteps();
    YourOrderSteps yourOrderSteps = new YourOrderSteps();

    @Test
    public void validateDemosDesign() {
        open("https://www.telerik.com/support/demos");
        List<String> expectedTitles = List.of(
                APPSTORE_DOWNLOAD,
                GOOGLEPLAY_DOWNLOAD,
                MICROSOFT_DOWNLOAD
        );

        demosSteps
                .scrollToWebSection()
                .validatePurpleOverlay(demosPage.webSections)
                .containsText(KENDO_UI_LIST, UI_FOR_VUE_VALUES);
        demosSteps.availableOnMicrosoftStore(demosPage.desktopSection, TITLE_ATTRIBUTE, MICROSOFT_DOWNLOAD)
                .mobileSectionAvailableApps(expectedTitles)
                .linksRemainFixedAtTheTop()
                .validateSectionLinkGetsActive()
                .validateLinksTakeTheUserToCorrectSections();

    }

    @Test
    public void validateOrderMechanics(){
        open("https://www.telerik.com/support/demos");
        navigateToSteps
                .goToPricingPage()
                .goToYourOrderPage();
        yourOrderSteps.closePopup()
                .validateUnitPrice(VALIDATE_PRICE)
                .chooseYear(CHOOSE_YEAR)
                .validateTermPrice(TERM_PRICE)
                .validateTotalPrice()
                .validateTotalDiscount()
                .validateLicenses(LICENSE_VALUE, LICENSE_NUMBER, HOVER_LABEL, HOVER_VALUE)
                .continueLogin()
                .fillForm(FULL_NAME, FULL_NAME, EMAIL, COMPANY, PHONE,
                        CURRENT_ADDRESS, COUNTY, CURRENT_ADDRESS, ZIP_CODE)
                .nextPage()
                .validateData(FULL_NAME, FULL_NAME,EMAIL, COMPANY, PHONE, CURRENT_ADDRESS,  ZIP_CODE );

    }



    @Test
    public void chainedLocatorsTest(){
        open("https://demoqa.com/books");
        booksSteps
                .scrollToBooks()
                .findAllBooksWithPublisher(booksPage.allBooks, PUBLISHER, TITLE)
                .imageAreNotEmpty(booksPage.allBooks);

    }

    @Test
    public void softAssertTest(){
        open("https://demoqa.com/books");
        booksSteps
                .findAllBooksWithPublisherWithFindAll(booksPage.allBooks, PUBLISHER, TITLE)
                .failedAssertion()
                .firstBookTitle(GIT_GUIDE)
                .assertAll();

    }
}

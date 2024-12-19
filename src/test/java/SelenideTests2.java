import ge.tbc.testautomation.pages.DemoqaPages.BooksPage;
import ge.tbc.testautomation.pages.TelerikSteps.DemosPage;
import ge.tbc.testautomation.steps.DemoqaSteps.BooksSteps;
import ge.tbc.testautomation.steps.TelerikSteps.DemosSteps;
import ge.tbc.testautomation.steps.TelerikSteps.PricingPageSteps;
import ge.tbc.testautomation.steps.TelerikSteps.YourOrderSteps;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;


@Epic("UI and Order Mechanics Testing")
@Test(groups = {"Selenide 2"})
public class SelenideTests2 extends ConfigTest {
    BooksSteps booksSteps = new BooksSteps();
    BooksPage booksPage = new BooksPage();
    DemosSteps demosSteps = new DemosSteps();
    DemosPage demosPage = new DemosPage();
    PricingPageSteps navigateToSteps = new PricingPageSteps();
    YourOrderSteps yourOrderSteps = new YourOrderSteps();

    @Test
    @Feature("Demos Page UI")
    @Story("Validate Demos Page Design and Interactions")
    @Description("This test validates the design of the Demos page, ensuring that the purple overlay," +
            " section links, and mobile app download options are correctly displayed and functional.")
    @Severity(SeverityLevel.BLOCKER)
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
    @Feature("Order Process")
    @Story("Validate Order Mechanics and Pricing")
    @Description("This test ensures that the order mechanics," +
            " including unit prices, total prices, discounts, and license information, are correctly displayed and validated on the order page.")
    @Severity(SeverityLevel.MINOR)
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
    @Feature("Books Page")
    @Story("Validate Book Listings and Image Presence")
    @Description("This test checks the visibility of book listings" +
            " on the Books page and ensures that each listing has an associated image that is not empty.")
    @Severity(SeverityLevel.NORMAL)
    public void chainedLocatorsTest(){
        open("https://demoqa.com/books");
        booksSteps
                .scrollToBooks()
                .findAllBooksWithPublisher(booksPage.allBooks, PUBLISHER, TITLE)
                .imageAreNotEmpty(booksPage.allBooks);

    }

    @Test
    @Feature("Books Page")
    @Story("Validate Book Listings with Soft Assertions")
    @Description("This test uses soft assertions to check the correctness of book listings, " +
            "such as publisher names and titles, and verifies that assertions do not stop the execution of subsequent checks.")
    @Severity(SeverityLevel.TRIVIAL)
    public void softAssertTest(){
        open("https://demoqa.com/books");
        booksSteps
                .findAllBooksWithPublisherWithFindAll(booksPage.allBooks, PUBLISHER, TITLE)
                .failedAssertion()
                .firstBookTitle(GIT_GUIDE)
                .assertAll();

    }
}

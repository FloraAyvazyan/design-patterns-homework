import ge.tbc.testautomation.pages.TelerikSteps.ProductBundlesPage;
import ge.tbc.testautomation.steps.DemoqaSteps.TextBoxSteps;
import ge.tbc.testautomation.steps.HerokuappSteps.CheckBoxSteps;
import ge.tbc.testautomation.steps.HerokuappSteps.DropDownSteps;
import ge.tbc.testautomation.steps.TelerikSteps.IndividualProductsSteps;
import ge.tbc.testautomation.steps.TelerikSteps.PricingPageSteps;
import ge.tbc.testautomation.steps.TelerikSteps.ProductBundlesSteps;
import org.testng.annotations.Test;
import java.util.List;
import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;

@Test(groups = {"Selenide 1"})
public class SelenideTests extends ConfigTest{
    PricingPageSteps navigateToSteps = new PricingPageSteps();
    IndividualProductsSteps individualProductsSteps = new IndividualProductsSteps();
    CheckBoxSteps checkBoxSteps = new CheckBoxSteps();
    DropDownSteps dropDownSteps = new DropDownSteps();
    TextBoxSteps textBoxSteps = new TextBoxSteps();
    ProductBundlesSteps productBundlesSteps = new ProductBundlesSteps();
    ProductBundlesPage productBundlesPage = new ProductBundlesPage();


    @Test(priority = 5)
    public void validateBundleOffers() {
        open("https://www.telerik.com/support/demos");
        navigateToSteps.goToPricingPage();
        productBundlesSteps
                .isNotSupportedOnCollection(MOCKING_SOLUTION_FOR_REPAID_UNIT_TESTING, productBundlesPage.DevCraftUI)
                .isSupportedOnCollection(END_TO_END_REPORT_MANAGEMENT_SOLUTION, productBundlesPage.DevCraftUltimate)
                .isNotSupportedOnCollection(END_TO_END_REPORT_MANAGEMENT_SOLUTION, productBundlesPage.DevCraftUI)
                .isNotSupportedOnCollection(END_TO_END_REPORT_MANAGEMENT_SOLUTION, productBundlesPage.DevCraftComplete)
                .validateNotAvailableWithDot(TELERIK_TEST_STUDIO_DEV_EDITION, DEVCRAFT_UI)
                .validateNotAvailableWithDot(TELERIK_TEST_STUDIO_DEV_EDITION, DEVCRAFT_UI)
                .validateNotAvailableWithDot(TELERIK_TEST_STUDIO_DEV_EDITION, DEVCRAFT_COMPLETE)
                .validateAvailableWithDot(TELERIK_TEST_STUDIO_DEV_EDITION, DEVCRAFT_ULTIMATE)
                .validateAvailableWithDot(KENDO_UI_FOR_JQUERY, DEVCRAFT_UI)
                .validateAvailableWithDot(KENDO_UI_FOR_JQUERY, DEVCRAFT_COMPLETE)
                .validateAvailableWithDot(KENDO_UI_FOR_JQUERY, DEVCRAFT_ULTIMATE)
                .validateNotAvailableWithDot(TELERIK_REPORTING, DEVCRAFT_UI)
                .validateAvailableWithDot(TELERIK_REPORTING, DEVCRAFT_COMPLETE)
                .validateAvailableWithDot(TELERIK_REPORTING, DEVCRAFT_ULTIMATE)
                .validateAvailableWithDot(ACCESS_TO_ON_DEMAND_VIDEOS, DEVCRAFT_UI)
                .validateAvailableWithDot(ACCESS_TO_ON_DEMAND_VIDEOS, DEVCRAFT_COMPLETE)
                .validateAvailableWithDot(ACCESS_TO_ON_DEMAND_VIDEOS, DEVCRAFT_ULTIMATE)
                .stickyElement(productBundlesPage.stickyHeader)
                .isNotSupported(productBundlesPage.DevCraftUI_LiteSupport, ISSUE_ESCALATION)
                .isNotSupported(productBundlesPage.DevCraftComplete_PrioritySupport, ISSUE_ESCALATION)
                .isSupported(productBundlesPage.DevCraftUltimate_UltimateSupport, ISSUE_ESCALATION);


    }

    @Test(priority = 4)
    public void validateIndividualOffers(){
        open("https://www.telerik.com/support/demos");
        navigateToSteps.goToPricingPage();
        individualProductsSteps
                .navigateToIndividualPage()
                .firstOfferShouldBeVisible()
                .firstOfferScrollAndHover()
                .firstNinjaShouldBeVisible()
                .secondOfferHover()
                .secondNinjaShouldBeVisible()
                .firstOfferDropDownText(PRIORITY_SUPPORT)
                .secondOfferDropDownText(PRIORITY_SUPPORT)
                .supportedPriceKindoUi(KENDOUI_PRICE)
                .supportPriceKindoReact(KENDOREACT_PRICE);


    }


    @Test(groups = {"CheckBoxes-FrontEnd"}, priority = 2)
    public void checkBoxTest() {
        open("http://the-internet.herokuapp.com/checkboxes");
        checkBoxSteps
                .setFirstCheckBoxSelected()
                .checkBoxesShouldHaveType(CHECKBOX_TYPE);

    }


    @Test(groups = {"dropDown-FrontEnd"}, priority = 3)
    public void dropDownTest(){
        open("http://the-internet.herokuapp.com/dropdown");
        dropDownSteps
                .dropdownSelectedOptionShouldHave(SELECTED_TEXT)
                .dropdownSelectOption(OPTION2)
                .dropdownSelectedOptionShouldHave(OPTION2);

    }

    @Test(priority = 6)
    public void collectionsTest(){
        open("https://demoqa.com/text-box");
        List<String> result = List.of(
                VALIDATE_NAME,
                VALIDATE_EMAIL,
                VALIDATE_CURRENT_ADDRESS,
                VALIDATE_PERMANENT_ADDRESS
        );
        textBoxSteps
                .textBoxScrollTo().fillFullName(FULL_NAME)
                .fillEmail(EMAIL)
                .fullCurrentAddress(CURRENT_ADDRESS)
                .fillPermanentAddress(PERMANENT_ADDRESS)
                .submitButtonScrollToAndClick()
                .validateRealResult(result);
    }

}

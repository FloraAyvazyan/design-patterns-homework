import ge.tbc.testautomation.steps.DemoqaSteps.TextBoxSteps;
import ge.tbc.testautomation.steps.HerokuappSteps.CheckBoxSteps;
import ge.tbc.testautomation.steps.HerokuappSteps.DropDownSteps;
import ge.tbc.testautomation.steps.TelerikSteps.IndividualProductsSteps;
import ge.tbc.testautomation.steps.TelerikSteps.NavigateToSteps;
import org.testng.annotations.Test;
import java.util.List;
import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.Constants.*;

public class SelenideTests extends ConfigTest{

    NavigateToSteps navigateToSteps = new NavigateToSteps();
    IndividualProductsSteps individualProductsSteps = new IndividualProductsSteps();
    CheckBoxSteps checkBoxSteps = new CheckBoxSteps();
    DropDownSteps dropDownSteps = new DropDownSteps();
    TextBoxSteps textBoxSteps = new TextBoxSteps();


    @Test
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


    @Test
    public void checkBoxTest() {
        open("http://the-internet.herokuapp.com/checkboxes");
        checkBoxSteps
                .setFirstCheckBoxSelected()
                .checkBoxesShouldHaveType(CHECKBOX_TYPE);

    }


    @Test
    public void dropDownTest(){
        open("http://the-internet.herokuapp.com/dropdown");
        dropDownSteps
                .dropdownSelectedOptionShouldHave(SELECTED_TEXT)
                .dropdownSelectOption(OPTION2)
                .dropdownSelectedOptionShouldHave(OPTION2);

    }

    @Test
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

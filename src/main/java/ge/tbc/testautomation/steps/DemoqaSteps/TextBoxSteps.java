package ge.tbc.testautomation.steps.DemoqaSteps;
import ge.tbc.testautomation.pages.DemoqaPages.TextBoxPage;
import io.qameta.allure.Step;

import java.util.List;
import static com.codeborne.selenide.CollectionCondition.exactTexts;

public class TextBoxSteps extends TextBoxPage {
    @Step("Scroll to the text box section")
    public TextBoxSteps textBoxScrollTo() {
        textBox.scrollTo();
        return this;
    }

    @Step("Fill in the full name field with '{name}'")
    public TextBoxSteps fillFullName(String name) {
        fullName.setValue(name);
        return this;
    }

    @Step("Fill in the email field with '{em}'")
    public TextBoxSteps fillEmail(String em) {
        email.setValue(em);
        return this;
    }

    @Step("Fill in the current address field with '{address}'")
    public TextBoxSteps fullCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }


    @Step("Fill in the permanent address field with '{address}'")
    public TextBoxSteps fillPermanentAddress(String address) {
        permanentAddress.setValue(address);
        return this;
    }

    @Step("Validate the form results: {result}")
    public TextBoxSteps validateRealResult(List<String> result) {
        realResult.shouldHave(exactTexts(result));
        return this;
    }

    @Step("Scroll to the submit button and click it")
    public TextBoxSteps submitButtonScrollToAndClick() {
        submitButton.scrollTo().click();
        return this;
    }
}

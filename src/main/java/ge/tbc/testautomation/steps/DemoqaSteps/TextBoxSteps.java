package ge.tbc.testautomation.steps.DemoqaSteps;
import ge.tbc.testautomation.pages.DemoqaPages.TextBoxPage;
import java.util.List;
import static com.codeborne.selenide.CollectionCondition.exactTexts;

public class TextBoxSteps extends TextBoxPage {
    public TextBoxSteps textBoxScrollTo() {
        textBox.scrollTo();
        return this;
    }

    public TextBoxSteps fillFullName(String name) {
        fullName.setValue(name);
        return this;
    }

    public TextBoxSteps fillEmail(String em) {
        email.setValue(em);
        return this;
    }

    public TextBoxSteps fullCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }

    public TextBoxSteps fillPermanentAddress(String address) {
        permanentAddress.setValue(address);
        return this;
    }

    public TextBoxSteps validateRealResult(List<String> result) {
        realResult.shouldHave(exactTexts(result));
        return this;
    }

    public TextBoxSteps submitButtonScrollToAndClick() {
        submitButton.scrollTo().click();
        return this;
    }
}

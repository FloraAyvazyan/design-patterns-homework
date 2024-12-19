package ge.tbc.testautomation.steps.HerokuappSteps;
import ge.tbc.testautomation.pages.HerokuappPages.DropDownPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class DropDownSteps extends DropDownPage {

    @Step("Verify that the selected dropdown option is '{selectedOption}'")
    public DropDownSteps dropdownSelectedOptionShouldHave(String selectedOption){
        dropDown.getSelectedOption().shouldHave(text(selectedOption));
        return this;
    }

    @Step("Select the dropdown option '{option}'")
    public DropDownSteps dropdownSelectOption(String option){
        dropDown.selectOption(option);
        return this;
    }

}

package ge.tbc.testautomation.steps.HerokuappSteps;
import ge.tbc.testautomation.pages.HerokuappPages.DropDownPage;
import static com.codeborne.selenide.Condition.text;

public class DropDownSteps extends DropDownPage {
    public DropDownSteps dropdownSelectedOptionShouldHave(String selectedOption){
        dropDown.getSelectedOption().shouldHave(text(selectedOption));
        return this;
    }

    public DropDownSteps dropdownSelectOption(String option){
        dropDown.selectOption(option);
        return this;
    }

}

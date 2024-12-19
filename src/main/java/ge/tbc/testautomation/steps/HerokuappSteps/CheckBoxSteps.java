package ge.tbc.testautomation.steps.HerokuappSteps;
import ge.tbc.testautomation.pages.HerokuappPages.CheckboxesPages;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.type;

public class CheckBoxSteps extends CheckboxesPages {
    @Step("Set the first checkbox to selected state")
    public CheckBoxSteps setFirstCheckBoxSelected(){
        firstCheckBox.setSelected(true);
        return this;
    }

    @Step("Verify that all checkboxes have the type: {checkboxType}")
    public CheckBoxSteps checkBoxesShouldHaveType(String checkboxType){
        checkBoxes.forEach(el -> el.shouldHave(type(checkboxType)));
        return this;
    }

}

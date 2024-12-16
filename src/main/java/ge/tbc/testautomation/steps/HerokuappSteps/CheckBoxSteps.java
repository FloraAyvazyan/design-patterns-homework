package ge.tbc.testautomation.steps.HerokuappSteps;
import ge.tbc.testautomation.pages.HerokuappPages.CheckboxesPages;
import static com.codeborne.selenide.Condition.type;

public class CheckBoxSteps extends CheckboxesPages {
    public CheckBoxSteps setFirstCheckBoxSelected(){
        firstCheckBox.setSelected(true);
        return this;
    }

    public CheckBoxSteps checkBoxesShouldHaveType(String checkboxType){
        checkBoxes.forEach(el -> el.shouldHave(type(checkboxType)));
        return this;
    }

}

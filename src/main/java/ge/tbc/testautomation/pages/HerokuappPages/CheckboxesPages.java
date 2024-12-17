package ge.tbc.testautomation.pages.HerokuappPages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckboxesPages {
    public SelenideElement firstCheckBox = $(by("type", "checkbox"));
    public ElementsCollection checkBoxes =  $$("#checkboxes input");
}

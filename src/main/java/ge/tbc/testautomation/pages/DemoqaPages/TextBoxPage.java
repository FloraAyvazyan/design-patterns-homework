package ge.tbc.testautomation.pages.DemoqaPages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TextBoxPage {
    public SelenideElement
            textBox = $(byText("Text Box")),
            fullName = $("#userName"),
            email = $(by("type", "email")),
            currentAddress = $("textarea[placeholder = 'Current Address']"),
            permanentAddress = $("textarea", 1),
            submitButton = $("#submit");

    public ElementsCollection realResult = $$(".mb-1");
}

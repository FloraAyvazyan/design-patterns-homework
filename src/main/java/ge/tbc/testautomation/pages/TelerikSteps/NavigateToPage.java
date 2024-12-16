package ge.tbc.testautomation.pages.TelerikSteps;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class NavigateToPage {
    public SelenideElement pricingButton = $(byText("Pricing"));
}

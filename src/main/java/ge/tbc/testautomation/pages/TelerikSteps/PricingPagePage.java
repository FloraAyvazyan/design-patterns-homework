package ge.tbc.testautomation.pages.TelerikSteps;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PricingPagePage {
    public SelenideElement
            pricingButton = $(byText("Pricing")),
            buyButton = $("th[class='Complete'] a[class='Btn Btn--prim4 u-db']"),
            DevCraftComplete = $("//th[contains(@class, 'Complete')]//span[contains(@class, 'u-dib')]");


}


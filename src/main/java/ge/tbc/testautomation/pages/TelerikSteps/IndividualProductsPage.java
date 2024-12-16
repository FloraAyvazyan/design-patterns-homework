package ge.tbc.testautomation.pages.TelerikSteps;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class IndividualProductsPage {
    public SelenideElement
            individualPricing = $(byText("Individual Products")),
            firstOffer = $(by("data-opti-expid", "Kendo UI")),
            secondOffer = $(by("data-opti-expid", "KendoReact")),
            firstNinja = $("img[title='Kendo Ui Ninja']"),
            secondNinja = $("img[title='Kendo React Ninja']"),
            firstOfferDropDown = $x("//a[@href = '#' and @data-track-instance = '1']"),
            secondOfferDropDown = $x("//a[@href = \"#\" and @data-track-instance = '2']"),
            priceOfSecondPrioritySupport = secondOffer.$(".js-price"),
            priceOfFirstPrioritySupport = firstOffer.$(".js-price");
}

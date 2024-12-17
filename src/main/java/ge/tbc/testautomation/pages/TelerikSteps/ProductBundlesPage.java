package ge.tbc.testautomation.pages.TelerikSteps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.*;

public class ProductBundlesPage {
   public ElementsCollection
           DevCraftUI = $$x("//th[@class='UI is-active']//child::ul/li"),
           DevCraftComplete = $$x("//th[@class='Complete']//child::ul/li"),
           DevCraftUltimate = $$x("//th[@class='Ultimate']//child::ul/li");

   public SelenideElement
           DevCraftUI_LiteSupport = $(byCssSelector("tr.Pricings-support")).$(byCssSelector("th.UI.is-active")),
           DevCraftComplete_PrioritySupport =$(byCssSelector("tr.Pricings-support")).$(byCssSelector("th.Complete")),
           DevCraftUltimate_UltimateSupport = $(byCssSelector("tr.Pricings-support")).$(byCssSelector("th.Ultimate")),
           featureTable = $(byCssSelector("table.PricingTable")),
           stickyHeader = $("#js-sticky-head");

}

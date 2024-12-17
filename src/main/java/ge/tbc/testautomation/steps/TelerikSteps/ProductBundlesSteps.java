package ge.tbc.testautomation.steps.TelerikSteps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.TelerikSteps.ProductBundlesPage;
import ge.tbc.testautomation.util.TableHandler;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ProductBundlesSteps extends ProductBundlesPage {
    public ProductBundlesSteps  isSupportedOnCollection(String feature,  ElementsCollection elements){
       elements.shouldHave(CollectionCondition.itemWithText(feature));
        return this;
    }

    public ProductBundlesSteps isNotSupportedOnCollection(String feature , ElementsCollection elements){
        for(SelenideElement offerItem: elements){
            offerItem.shouldNotHave(text(feature));
        }
        return this;
    }

    public ProductBundlesSteps isSupported(SelenideElement element, String feature){
        element.shouldHave(text(feature));
        return this;
    }

    public ProductBundlesSteps isNotSupported(SelenideElement element, String feature ){
        element.shouldNotHave(text(feature));
        return this;
    }

    public ProductBundlesSteps validateAvailableWithDot(String forFeature, String inBundle){
        SelenideElement dotCell = TableHandler.findCellByLabels(
                forFeature,
                inBundle,
                featureTable);
        dotCell.scrollTo().shouldHave(innerText("●"));
        return this;
    }

    public ProductBundlesSteps validateNotAvailableWithDot(String forFeature, String inBundle){
        SelenideElement dotCell = TableHandler.findCellByLabels(
                forFeature,
                inBundle,
                featureTable);
        dotCell.scrollTo().shouldNotHave(innerText("●"));
        return this;
    }

    public ProductBundlesSteps stickyElement(SelenideElement element){
        executeJavaScript("window.scrollBy(0, 2000);");
        element.shouldHave(cssClass("is-fixed"));
        return this;
    }



}

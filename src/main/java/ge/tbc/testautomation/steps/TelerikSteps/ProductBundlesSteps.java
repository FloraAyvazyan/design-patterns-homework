package ge.tbc.testautomation.steps.TelerikSteps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.TelerikSteps.ProductBundlesPage;
import ge.tbc.testautomation.util.TableHandler;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ProductBundlesSteps extends ProductBundlesPage {
    @Step("Verify that the feature '{feature}' is supported in the collection")
    public ProductBundlesSteps  isSupportedOnCollection(String feature,  ElementsCollection elements){
       elements.shouldHave(CollectionCondition.itemWithText(feature));
        return this;
    }

    @Step("Verify that the feature '{feature}' is not supported in the collection")
    public ProductBundlesSteps isNotSupportedOnCollection(String feature , ElementsCollection elements){
        for(SelenideElement offerItem: elements){
            offerItem.shouldNotHave(text(feature));
        }
        return this;
    }

    @Step("Verify that the feature '{feature}' is supported in the element")
    public ProductBundlesSteps isSupported(SelenideElement element, String feature){
        element.shouldHave(text(feature));
        return this;
    }


    @Step("Verify that the feature '{feature}' is not supported in the element")
    public ProductBundlesSteps isNotSupported(SelenideElement element, String feature ){
        element.shouldNotHave(text(feature));
        return this;
    }

    @Step("Validate that the feature '{forFeature}' is available with a dot in the bundle '{inBundle}'")
    public ProductBundlesSteps validateAvailableWithDot(String forFeature, String inBundle){
        SelenideElement dotCell = TableHandler.findCellByLabels(
                forFeature,
                inBundle,
                featureTable);
        dotCell.scrollTo().shouldHave(innerText("●"));
        return this;
    }


    @Step("Validate that the feature '{forFeature}' is not available with a dot in the bundle '{inBundle}'")
    public ProductBundlesSteps validateNotAvailableWithDot(String forFeature, String inBundle){
        SelenideElement dotCell = TableHandler.findCellByLabels(
                forFeature,
                inBundle,
                featureTable);
        dotCell.scrollTo().shouldNotHave(innerText("●"));
        return this;
    }

    @Step("Verify that the element remains sticky when scrolling")
    public ProductBundlesSteps stickyElement(SelenideElement element){
        executeJavaScript("window.scrollBy(0, 2000);");
        element.shouldHave(cssClass("is-fixed"));
        return this;
    }



}

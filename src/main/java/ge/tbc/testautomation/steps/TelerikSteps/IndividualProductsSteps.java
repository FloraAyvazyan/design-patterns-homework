package ge.tbc.testautomation.steps.TelerikSteps;
import ge.tbc.testautomation.pages.TelerikSteps.IndividualProductsPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class IndividualProductsSteps extends IndividualProductsPage {
    @Step("Navigate to the individual pricing page")
    public IndividualProductsSteps navigateToIndividualPage(){
        individualPricing.click();
        return this;
    }
    @Step("Verify that the first offer is visible")
    public IndividualProductsSteps firstOfferShouldBeVisible(){
        firstOffer.shouldBe(visible);
        return this;
    }

    @Step("Scroll to the first offer and hover over it")
    public IndividualProductsSteps firstOfferScrollAndHover(){
        firstOffer.scrollTo().hover();
        return this;
    }

    @Step("Verify that the first ninja is visible")
    public IndividualProductsSteps firstNinjaShouldBeVisible(){
        firstNinja.shouldBe(visible);
        return this;
    }

    @Step("Hover over the second offer")
    public IndividualProductsSteps secondOfferHover(){
        secondOffer.hover();
        return this;
    }

    @Step("Verify that the second ninja is visible")
    public IndividualProductsSteps secondNinjaShouldBeVisible(){
        secondNinja.shouldBe(visible);
        return this;
    }

    @Step("Verify that the dropdown text for the first offer is '{textSupport}'")
    public IndividualProductsSteps firstOfferDropDownText(String textSupport){
        firstOfferDropDown.shouldHave(text(textSupport));
        return this;
    }

    @Step("Verify that the dropdown text for the second offer is '{textSupport}'")
    public IndividualProductsSteps secondOfferDropDownText(String textSupport){
        secondOfferDropDown.shouldHave(text(textSupport));
        return this;
    }

    @Step("Verify that the price for second-priority support is '{price}' in KendoReact")
    public IndividualProductsSteps supportPriceKindoReact(String price){
        priceOfSecondPrioritySupport.shouldHave(text(price));
        return  this;
    }

    @Step("Verify that the price for first-priority support is '{price}' in Kendo UI")
    public IndividualProductsSteps supportedPriceKindoUi(String price){
        priceOfFirstPrioritySupport.shouldHave(text(price));
        return  this;
    }

}

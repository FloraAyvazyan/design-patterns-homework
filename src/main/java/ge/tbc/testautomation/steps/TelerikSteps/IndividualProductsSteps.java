package ge.tbc.testautomation.steps.TelerikSteps;
import ge.tbc.testautomation.pages.TelerikSteps.IndividualProductsPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class IndividualProductsSteps extends IndividualProductsPage {
    public IndividualProductsSteps navigateToIndividualPage(){
        individualPricing.click();
        return this;
    }

    public IndividualProductsSteps firstOfferShouldBeVisible(){
        firstOffer.shouldBe(visible);
        return this;
    }

    public IndividualProductsSteps firstOfferScrollAndHover(){
        firstOffer.scrollTo().hover();
        return this;
    }
    public IndividualProductsSteps firstNinjaShouldBeVisible(){
        firstNinja.shouldBe(visible);
        return this;
    }

    public IndividualProductsSteps secondOfferHover(){
        secondOffer.hover();
        return this;
    }

    public IndividualProductsSteps secondNinjaShouldBeVisible(){
        secondNinja.shouldBe(visible);
        return this;
    }

    public IndividualProductsSteps firstOfferDropDownText(String textSupport){
        firstOfferDropDown.shouldHave(text(textSupport));
        return this;
    }

    public IndividualProductsSteps secondOfferDropDownText(String textSupport){
        secondOfferDropDown.shouldHave(text(textSupport));
        return this;
    }

    public IndividualProductsSteps supportPriceKindoReact(String price){
        priceOfSecondPrioritySupport.shouldHave(text(price));
        return  this;
    }

    public IndividualProductsSteps supportedPriceKindoUi(String price){
        priceOfFirstPrioritySupport.shouldHave(text(price));
        return  this;
    }

}

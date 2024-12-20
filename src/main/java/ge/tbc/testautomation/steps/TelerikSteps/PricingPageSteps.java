package ge.tbc.testautomation.steps.TelerikSteps;
import ge.tbc.testautomation.pages.TelerikSteps.PricingPagePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PricingPageSteps extends PricingPagePage {
    @Step("Navigate to the pricing page")
    public PricingPageSteps goToPricingPage(){
        pricingButton.click();
        return this;
    }


    @Step("Navigate to the order page after scrolling down")
    public PricingPageSteps goToYourOrderPage(){
        executeJavaScript("window.scrollBy(0, 500);");
        buyButton.click();
        return this;
    }



}

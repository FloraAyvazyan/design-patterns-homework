package ge.tbc.testautomation.steps.TelerikSteps;
import ge.tbc.testautomation.pages.TelerikSteps.PricingPagePage;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PricingPageSteps extends PricingPagePage {
    public PricingPageSteps goToPricingPage(){
        pricingButton.click();
        return this;
    }

    public PricingPageSteps goToYourOrderPage(){
        executeJavaScript("window.scrollBy(0, 500);");
        buyButton.click();
        return this;
    }



}

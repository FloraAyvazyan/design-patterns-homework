package ge.tbc.testautomation.steps.TelerikSteps;
import ge.tbc.testautomation.pages.TelerikSteps.NavigateToPage;

public class NavigateToSteps extends NavigateToPage {
    public NavigateToSteps goToPricingPage(){
        pricingButton.click();
        return this;
    }

}

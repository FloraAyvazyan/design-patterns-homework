package ge.tbc.testautomation.steps.TelerikSteps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.TelerikSteps.DemosPage;
import org.openqa.selenium.By;
import java.util.List;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DemosSteps extends DemosPage {

    public DemosSteps scrollToWebSection(){
        webSectionTitle.scrollTo();
        return this;
    }

    public DemosSteps validatePurpleOverlay(ElementsCollection webSection){
        for (SelenideElement section : webSection) {
            section.scrollTo();
            section.hover();
            section.shouldHave(cssValue("background-color", "rgba(40, 46, 137, 0.75)"));

        }
        return this;
    }

    public  DemosPage  containsText(String title, String itemWith) {
        SelenideElement hoverElement = $(byTitle(title)).parent();
        hoverElement.scrollTo().hover();
        ElementsCollection overlay = hoverElement.$$(By.tagName("a"));
        overlay.shouldHave(CollectionCondition.itemWithText(itemWith));
        return this;

    }

    public DemosSteps availableOnMicrosoftStore(ElementsCollection section, String title, String exceptedValue){
         section = desktopSection
                .filterBy(Condition.attribute(title, exceptedValue));
        return this;
    }

    public DemosSteps mobileSectionAvailableApps(List<String> expectedTitles){
        mobileSectionImg.shouldHave(CollectionCondition.anyMatch(
                "At least one element has one of the required titles",
                el -> expectedTitles.contains(el.getAttribute("title"))
        ));
        return this;
    }

    public DemosSteps linksRemainFixedAtTheTop(){
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
        navSection.shouldHave(cssClass("is-fixed"));
        return this;
    }

    public DemosSteps validateSectionLinkGetsActive() {
        for (int i = 0; i < sectionLinks.size(); i++) {
            sectionLinks.get(i).click();
            sectionLinks.get(i)
                    .shouldHave(Condition.cssValue("background-color", "rgba(246, 247, 250, 1)"));

        }
        return this;
    }

    //ამის გაერთიანება შესაძლებელი იყო ზედა ფუნქციასთანაც, უბრალოდ ცალკე რასკი როა და მერე შესაძლებელია ამის
    //გადაკეთება მოგვიწიოს, დავტოვე ასე
    public DemosSteps validateLinksTakeTheUserToCorrectSections() {
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
        for (int i = 0; i < sectionLinks.size(); i++) {
            sectionLinks.get(i).click();
           // sectionTitles.get(i).shouldNotBe(not(visible));
        }
        return this;
    }
}

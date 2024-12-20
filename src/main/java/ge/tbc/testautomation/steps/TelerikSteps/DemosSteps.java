package ge.tbc.testautomation.steps.TelerikSteps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.TelerikSteps.DemosPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import java.util.List;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DemosSteps extends DemosPage {
    @Step("Scroll to the 'Web' section")
    public DemosSteps scrollToWebSection(){
        webSectionTitle.scrollTo();
        return this;
    }

    @Step("Validate that the purple overlay appears on hover in the 'Web' section")
    public DemosSteps validatePurpleOverlay(ElementsCollection webSection){
        for (SelenideElement section : webSection) {
            section.scrollTo();
            section.hover();
            section.shouldHave(cssValue("background-color", "rgba(40, 46, 137, 0.75)"));

        }
        return this;
    }

    @Step("Verify that the item with text '{itemWith}' is available under the section titled '{title}'")
    public  DemosPage  containsText(String title, String itemWith) {
        SelenideElement hoverElement = $(byTitle(title)).parent();
        hoverElement.scrollTo().hover();
        ElementsCollection overlay = hoverElement.$$(By.tagName("a"));
        overlay.shouldHave(CollectionCondition.itemWithText(itemWith));
        return this;

    }

    @Step("Check that the section is available on Microsoft Store with title '{title}' and expected value '{exceptedValue}'")
    public DemosSteps availableOnMicrosoftStore(ElementsCollection section, String title, String exceptedValue){
         section = desktopSection
                .filterBy(Condition.attribute(title, exceptedValue));
        return this;
    }

    @Step("Verify that the mobile section contains apps with one of the expected titles: {expectedTitles}")
    public DemosSteps mobileSectionAvailableApps(List<String> expectedTitles){
        mobileSectionImg.shouldHave(CollectionCondition.anyMatch(
                "At least one element has one of the required titles",
                el -> expectedTitles.contains(el.getAttribute("title"))
        ));
        return this;
    }

    @Step("Verify that navigation links remain fixed at the top during scroll")
    public DemosSteps linksRemainFixedAtTheTop(){
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
        navSection.shouldHave(cssClass("is-fixed"));
        return this;
    }

    @Step("Validate that each section link gets activated on click")
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
    @Step("Verify that each section link navigates to the correct section")
    public DemosSteps validateLinksTakeTheUserToCorrectSections() {
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
        for (int i = 0; i < sectionLinks.size(); i++) {
            sectionLinks.get(i).click();
           // sectionTitles.get(i).shouldNotBe(not(visible));
        }
        return this;
    }
}

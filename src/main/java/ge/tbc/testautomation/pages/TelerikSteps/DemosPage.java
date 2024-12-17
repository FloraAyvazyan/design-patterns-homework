package ge.tbc.testautomation.pages.TelerikSteps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class DemosPage {
    public SelenideElement
            webSectionTitle = $("#web"),
            navSection = $x("//nav[@data-tlrk-plugin='fixit']");

    public ElementsCollection
            webSections = $$x("//div[contains(@class, 'row')]//div[contains(@id, '329')]//div[contains(@class, 'HoverImg')]"),
            desktopSection = $$x("//div[contains(@class, 'row')]//div[contains(@id, '337')]//a//img"),
            mobileSectionImg = $$x("//div[contains(@class, 'row')]//div[contains(@id, '340')]//a//img"),
            sectionLinks = $$x("//div[@class='container']//a"),
            sectionTitles = $$("//h2[@class = 'u-mb0 h3']");

}

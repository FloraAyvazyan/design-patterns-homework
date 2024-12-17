package ge.tbc.testautomation.pages.DemoqaPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BooksPage {
    public SelenideElement
            bookPage = $(".rt-thead.-header"),
            booksBody = $(".rt-tbody");

    public ElementsCollection
            allBooks = $$(".rt-tr-group"),
            withImg = $$(".rt-tr-group img");
}

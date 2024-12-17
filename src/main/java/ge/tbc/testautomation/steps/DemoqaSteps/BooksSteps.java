package ge.tbc.testautomation.steps.DemoqaSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.DemoqaPages.BooksPage;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Condition.attribute;

public class BooksSteps extends BooksPage {
    SoftAssert sfa = new SoftAssert();

    public BooksSteps scrollToBooks() {
        bookPage.scrollTo();
        return this;
    }

    public BooksSteps findAllBooksWithPublisher(ElementsCollection elements, String publisher, String title) {
        elements =  allBooks.filterBy(Condition.innerText(publisher))
                .filterBy(Condition.partialText(title));
       // System.out.println(elements.size()); შემოწმებაა
        return this;

    }
    public BooksSteps findAllBooksWithPublisherWithFindAll(ElementsCollection elements, String publisher, String title){
         elements = booksBody
                .findAll(".rt-tr-group")
                .filterBy(Condition.innerText(publisher))
                .filterBy(Condition.partialText(title));
         //System.out.println(elements.size());
         return this;

    }

    public BooksPage imageAreNotEmpty(ElementsCollection elements) {
        for (SelenideElement book : withImg) {
            book.shouldHave(attribute("src"));
        }
        return this;

    }

    public BooksSteps failedAssertion(){
        sfa.assertEquals(allBooks.size(), 10);
        return this;
    }

    public BooksSteps firstBookTitle(String title){
        sfa.assertEquals(allBooks.get(0).getText(),  title);
        return this;
    }
    public BooksSteps assertAll(){
        sfa.assertAll();
        return this;
    }


}

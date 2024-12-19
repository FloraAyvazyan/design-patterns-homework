package ge.tbc.testautomation.steps.DemoqaSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.DemoqaPages.BooksPage;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Condition.attribute;

public class BooksSteps extends BooksPage {
    SoftAssert sfa = new SoftAssert();


    @Step("Scroll to the books section on the page")
    public BooksSteps scrollToBooks() {
        bookPage.scrollTo();
        return this;
    }

    @Step("Find all books by publisher: {publisher} and containing title: {title}")
    public BooksSteps findAllBooksWithPublisher(ElementsCollection elements, String publisher, String title) {
        elements =  allBooks.filterBy(Condition.innerText(publisher))
                .filterBy(Condition.partialText(title));
       // System.out.println(elements.size()); შემოწმებაა
        return this;

    }

    @Step("Find all books by publisher: {publisher} and title: {title} using 'findAll'")
    public BooksSteps findAllBooksWithPublisherWithFindAll(ElementsCollection elements, String publisher, String title){
         elements = booksBody
                .findAll(".rt-tr-group")
                .filterBy(Condition.innerText(publisher))
                .filterBy(Condition.partialText(title));
         //System.out.println(elements.size());
         return this;

    }

    @Step("Verify that all book images are not empty")
    public BooksPage imageAreNotEmpty(ElementsCollection elements) {
        for (SelenideElement book : withImg) {
            book.shouldHave(attribute("src"));
        }
        return this;

    }

    @Step("Perform a failed assertion to check the size of the book list")
    public BooksSteps failedAssertion(){
        sfa.assertEquals(allBooks.size(), 10);
        return this;
    }

    @Step("Verify that the title of the first book is '{title}'")
    public BooksSteps firstBookTitle(String title){
        sfa.assertEquals(allBooks.get(0).getText(),  title);
        return this;
    }

    @Step("Assert all collected assertions")
    public BooksSteps assertAll(){
        sfa.assertAll();
        return this;
    }


}

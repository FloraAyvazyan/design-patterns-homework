package ge.tbc.testautomation.steps.TelerikSteps;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.TelerikSteps.YourOrderPage;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class YourOrderSteps extends YourOrderPage {
    public YourOrderSteps closePopup() {
        popupCloseButton.click();
        return this;
    }


    public YourOrderSteps validateUnitPrice(String price) {
        assertEquals(unitPrice.getText(), price);
        return this;
    }

    public YourOrderSteps chooseYear(String year) {
        quantityDropDown.click();
        quantityDropDown.sendKeys(year);
        quantityDropDown.sendKeys(Keys.ENTER);
        return this;

    }

    public YourOrderSteps validateTermPrice(String price) {
        assertEquals(termPrice.getText(), price);
        return this;
    }

    public YourOrderSteps validateTotalPrice() {
        String totalPriceText = totalPriceElement.getText();
        String numericPrice = totalPriceText.replaceAll("[^\\d.]", "");
        double totalPrice = Double.parseDouble(numericPrice);
        double expectedPrice = 3261.16;
        assertEquals(expectedPrice, totalPrice);
        return this;

    }

    public YourOrderSteps validateTotalDiscount() {
        executeJavaScript("window.scrollTo(0, 200)");
        totalDiscounts.hover();
        afterHover.shouldBe(visible);
        return this;

    }

    public YourOrderSteps validateLicenses(String value, String LicenseNumber, String HoverLabel, String HoverValue) {
        license.shouldHave(text(value));
        licenseNumber.shouldHave(text(LicenseNumber));
        hoverLabel.shouldHave(text(HoverLabel));
        hoverValue.shouldHave(text(HoverValue));


        return this;
    }

    public YourOrderSteps continueLogin() {
        acceptCookies.click();
        continueBtn.click();
        return this;
    }

    public YourOrderSteps fillForm(String name, String surName, String Email, String Company, String phone,
                                   String Address, String County, String City, String ZipCode) {
        fistName.setValue(name);
        lastName.setValue(surName);
        email.setValue(Email);
        companyName.setValue(Company);
        phoneNumber.setValue(phone);
        address.setValue(Address);
        executeJavaScript("window.scrollTo(0, 200)");
        country.click();
        dropdownList.findAll("li").findBy(text(County)).click();
        city.setValue(City);
        zipCode.setValue(ZipCode);

        return this;


    }

    public YourOrderSteps nextPage() {
        getNextButton.scrollIntoView(true);
        getNextButton.click();
        return this;
    }

    public YourOrderSteps continueAndValidateData() {
        SelenideElement backButton = $x("//span[@class = 'loader-holder loader-container']");
        backButton.scrollTo();
        backButton.click();
    return this;
    }

    public  YourOrderSteps validateData(String name, String surName, String Email, String Company, String phone,
                                         String City, String ZipCode){

        fistName.shouldHave(value(name));
        lastName.shouldHave(value(surName));
        email.shouldHave(value(Email));
        companyName.shouldHave(value(Company));
        phoneNumber.shouldHave(value(phone));

        city.shouldHave(value(City));
        zipCode.shouldHave(value(ZipCode));
        return this;
    }
}

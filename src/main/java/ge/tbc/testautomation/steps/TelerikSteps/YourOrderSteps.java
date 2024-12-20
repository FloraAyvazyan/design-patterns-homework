package ge.tbc.testautomation.steps.TelerikSteps;
import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.TelerikSteps.YourOrderPage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class YourOrderSteps extends YourOrderPage {
    @Step("Close the popup window")
    public YourOrderSteps closePopup() {
        popupCloseButton.click();
        return this;
    }

    @Step("Validate the unit price is '{price}'")
    public YourOrderSteps validateUnitPrice(String price) {
        assertEquals(unitPrice.getText(), price);
        return this;
    }

    @Step("Choose subscription duration: '{year}' years")
    public YourOrderSteps chooseYear(String year) {
        quantityDropDown.click();
        quantityDropDown.sendKeys(year);
        quantityDropDown.sendKeys(Keys.ENTER);
        return this;

    }

    @Step("Validate the term price is '{price}'")
    public YourOrderSteps validateTermPrice(String price) {
        assertEquals(termPrice.getText(), price);
        return this;
    }

    @Step("Validate the total price is as expected")
    public YourOrderSteps validateTotalPrice() {
        String totalPriceText = totalPriceElement.getText();
        String numericPrice = totalPriceText.replaceAll("[^\\d.]", "");
        double totalPrice = Double.parseDouble(numericPrice);
        double expectedPrice = 3261.16;
        assertEquals(expectedPrice, totalPrice);
        return this;

    }

    @Step("Validate total discounts after hover")
    public YourOrderSteps validateTotalDiscount() {
        executeJavaScript("window.scrollTo(0, 200)");
        totalDiscounts.hover();
        afterHover.shouldBe(visible);
        return this;

    }

    @Step("Validate licenses details: Value='{value}', License Number='{LicenseNumber}', Hover Label='{HoverLabel}', Hover Value='{HoverValue}'")
    public YourOrderSteps validateLicenses(String value, String LicenseNumber, String HoverLabel, String HoverValue) {
        license.shouldHave(text(value));
        licenseNumber.shouldHave(text(LicenseNumber));
        hoverLabel.shouldHave(text(HoverLabel));
        hoverValue.shouldHave(text(HoverValue));


        return this;
    }

    @Step("Accept cookies and continue to login")
    public YourOrderSteps continueLogin() {
        acceptCookies.click();
        continueBtn.click();
        return this;
    }


    @Step("Fill order form with provided details")
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

    @Step("Navigate to the next page")
    public YourOrderSteps nextPage() {
        getNextButton.scrollIntoView(true);
        getNextButton.click();
        return this;
    }

    @Step("Continue and validate the loaded data")
    public YourOrderSteps continueAndValidateData() {
        SelenideElement backButton = $x("//span[@class = 'loader-holder loader-container']");
        backButton.scrollTo();
        backButton.click();
    return this;
    }


    @Step("Validate filled data: Name='{name}', Surname='{surName}', Email='{Email}', Company='{Company}', Phone='{phone}', City='{City}', ZipCode='{ZipCode}'")
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

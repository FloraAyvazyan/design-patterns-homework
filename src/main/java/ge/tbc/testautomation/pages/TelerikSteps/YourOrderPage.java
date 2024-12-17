package ge.tbc.testautomation.pages.TelerikSteps;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class YourOrderPage {
    public SelenideElement
            acceptCookies = $(withText("Accept Cookies")),
            popupCloseButton = $(".far.fa-times.label.u-cp"),
            unitPrice = $(".e2e-price-per-license"),
            quantityDropDown = $("period-select kendo-dropdownlist"),
            termPrice = $("span.u-db.e2e-price-per-license.page-body--success"),
            totalPriceElement = $x("//h4[contains(@class, 'e2e-total-price')]"),
            totalDiscounts = $(".e2e-total-discounts-label"),
            afterHover = $(".tooltip-info.tooltip-info--font-l.tooltip-info--no-after"),
            license = $(".e2e-licenses-discounts-label"),
            licenseNumber = $(".u-fr.e2e-licenses-price"),
            hoverLabel = afterHover.$(".e2e-tooltip-ms-discounts-label"),
            hoverValue = afterHover.$(".e2e-ms-discounts"),
            continueBtn = $("button.e2e-continue"),
            fistName = $("#biFirstName"),
            lastName = $("#biLastName"),
            email = $("#biEmail"),
            companyName = $("#biCompany"),
            phoneNumber = $("#biPhone"),
            address = $("#biAddress"),
            country = $("kendo-combobox#biCountry").find(".k-input-button"),
            dropdownList = $(".k-list-container"),
            city = $("#biCity"),
            zipCode = $("#biZipCode"),
            getNextButton = $(".btn.btn-primary.e2e-continue.sm-width-100.loader-button");


}

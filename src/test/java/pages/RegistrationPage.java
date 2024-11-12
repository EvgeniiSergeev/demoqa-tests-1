package pages;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    public static String firstNameLocator = "first_name";

    public void setFirstName(String value) {
        $(firstNameLocator).sendKeys(value);

    }


}

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeTestsForm {


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void automationPracticeTests() {

        open("/automation-practice-form");

        $("#firstName").setValue("Alex");

        $("#lastName").setValue("Alexeev");

        $("#userEmail").setValue("emain@email.com");

        $("[for='gender-radio-1']").click();

        //userNumber
        $("#userNumber").setValue("8002000500");

        //dateOfBirthInput
        $("#dateOfBirthInput").click();
        $("[class='react-datepicker__month-select']").selectOption("June");
        $("[class='react-datepicker__year-select']").selectOption("1992");
        $("[class='react-datepicker__day react-datepicker__day--025']").click();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("photo.jpg");

        $("#currentAddress").setValue("Current Address");

        $("#state").click();
        $(new ByText("NCR")).click();

        $("#city").click();
        $(new ByText("Delhi")).click();

        $("#submit").click();

        $("[class='modal-header']").shouldBe(text("Thanks for submitting the form"));
        $("[class='table-responsive'").shouldHave(text("Alex"), text("Alexeev"), text("emain@email.com"), text("25 June,1992"),
                text("Chemistry"), text("Sports"), text("Sports"), text("photo.jpg"), text("Current Address"), text("NCR Delhi"));

    }

}

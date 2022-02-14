import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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

        $("#gender-radio-1");
        $(byText("Male")).click();

        $("#userNumber").setValue("8002000500");

        $("#dateOfBirthInput").click();
        $("[class='react-datepicker__month-select']").selectOption("June");
        $("[class='react-datepicker__year-select']").selectOption("1992");
        $("[class='react-datepicker__day react-datepicker__day--025']").click();

        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#hobbies-checkbox-1");
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("photo.jpg");
        $("#currentAddress").setValue("Current Address");

        $("#state").click();
        $(new ByText("NCR")).click();

        $("#city").click();
        $(new ByText("Delhi")).click();

        $("#submit").click();

        $("[class='modal-header']").shouldBe(text("Thanks for submitting the form"));

        $$(".table-responsive tr").filterBy(text("Student Name")).shouldBe(texts("Alex Alexeev"));
        $$(".table-responsive tr").filterBy(text("Student Email")).shouldBe(texts("emain@email.com"));
        $$(".table-responsive tr").filterBy(text("Gender")).shouldBe(texts("Male"));
        $$(".table-responsive tr").filterBy(text("Mobile")).shouldBe(texts("8002000500"));
        $$(".table-responsive tr").filterBy(text("Date of Birth")).shouldBe(texts("25 June,1992"));
        $$(".table-responsive tr").filterBy(text("Subjects")).shouldBe(texts("Chemistry"));
        $$(".table-responsive tr").filterBy(text("Hobbies")).shouldBe(texts("Sports"));
        $$(".table-responsive tr").filterBy(text("Picture")).shouldBe(texts("photo.jpg"));
        $$(".table-responsive tr").filterBy(text("Address")).shouldBe(texts("Current Address"));
        $$(".table-responsive tr").filterBy(text("State and City")).shouldBe(texts("NCR Delhi"));

    }

}

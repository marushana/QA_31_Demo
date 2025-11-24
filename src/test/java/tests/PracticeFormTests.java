package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegFormPositiveTest(){
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.SPORTS);
        hobbies.add(Hobbies.READING);
        Student student = new Student("Marina", "Suovich",
                "tyure@yandex.ru", Gender.FEMALE,
                "0456123789", "13 Apr 1986",
                "Math,Physics,Chemistry",
                hobbies, "", "address 1",
                StateCity.UTTAR_PRADESH.getState(),
                StateCity.UTTAR_PRADESH.getCity()[1]);
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPraccticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
        Assert.assertTrue(new PracticeFormPage(getDriver())
                .validateMessage("Thanks for submitting the form"));

    }

}

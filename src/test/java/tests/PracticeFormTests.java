package tests;

import dto.Student;
import enums.Gender;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegFormPositiveTest(){
        Student student = new Student("Marina", "Suovich",
                "tyure@yandex.ru", Gender.FEMALE,
                "0456123789", "13 Apr 1986",
                "Math,Physics,Chemistry",
                "Music", "", "address 1",
                "NCR", "Delhi");
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPraccticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);

    }

}

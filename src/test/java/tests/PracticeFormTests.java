package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;


public class PracticeFormTests extends AppManager {
    SoftAssert softAssert = new SoftAssert();
    @Test(groups = "smoke")
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
//        Assert.assertTrue(new PracticeFormPage(getDriver())
//                .validateMessage("Wrong text"));

        System.out.println("Test pass");

        Assert.assertTrue(new PracticeFormPage(getDriver())
                .validateMessage("Thanks for submitting the form"));

    }

    @Test
    public void studentRegFormPositiveTestWithSoftAssert(){
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
        softAssert.assertTrue(new PracticeFormPage(getDriver())
                .validateMessage("Wrong text"), "validate Wrong message");

        System.out.println("Test pass");

        softAssert.assertTrue(new PracticeFormPage(getDriver())
                .validateMessage("Thanks for submitting the form"), "validate right message");
        softAssert.assertAll();

    }

    @Test
    public void studentRegFormPositiveTestWithSoftAssert_CheckFields(){
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
        softAssert.assertTrue(new PracticeFormPage(getDriver())
                .validateMessage("Thanks for submitting the form"), "validate right message");
        softAssert.assertTrue(getDriver().findElement(By.xpath("//tbody/tr/td[2]")).getText()
                .contains(student.getLastName()),"validate last name");
        softAssert.assertTrue(getDriver().findElement(By.xpath("//tbody/tr/td[2]")).getText()
                .contains(student.getName()),"validate name");
        softAssert.assertEquals(getDriver().findElement(By.xpath("//tbody/tr[2]/td[2]"))
                .getText(), student.getEmail(), "validate email");
        softAssert.assertAll();

    }

}

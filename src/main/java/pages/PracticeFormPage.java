package pages;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class PracticeFormPage extends BasePage{
    public PracticeFormPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements
                (new AjaxElementLocatorFactory(driver,
                        10), this);

    }

    @FindBy(xpath = "//input[@placeholder = 'First Name']")
    WebElement inputName;
    @FindBy(xpath = "//*[@id = 'lastName']")
    WebElement inputLastName;
    @FindBy(id = "userEmail")
    WebElement inputEmail;
    @FindBy(id = "userNumber")
    WebElement inputMobile;
    @FindBy(id = "dateOfBirthInput")
    WebElement filledDateOfBirth;
    @FindBy(id = "subjectsInput")
    WebElement inputSubject;
    @FindBy(xpath = "//*[@placeholder='Current Address']")
    WebElement inputAddress;
    @FindBy(id = "react-select-3-input")
    WebElement inputState;
    @FindBy(id = "react-select-4-input")
    WebElement inputCity;
    @FindBy(id = "submit")
    WebElement btnSubmit;
    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalMessage;



    public void typePracticeForm(Student student){
        hideBanner();
        hideFooter();
        inputName.sendKeys(student.getName());
        inputLastName.sendKeys(student.getLastName());
        inputEmail.sendKeys(student.getEmail());
        typeGender(student.getGender());
        inputMobile.sendKeys(student.getMobile());
        typeDateOfBirth(student.getDateOfBirth());
        typeSubjects(student.getSubject());
        typeHobbies(student.getHobbies());
        inputAddress.sendKeys(student.getAddress());
        typeStateCity(student.getState(), student.getCity());
        btnSubmit.click();

    }

    public boolean validateMessage(String text){
        return validateTextElement(modalMessage,text);
    }

    private void typeStateCity(String state, String city){
        inputState.sendKeys(state);
        inputState.sendKeys(Keys.ENTER);

        inputCity.sendKeys(city);
        inputCity.sendKeys(Keys.ENTER);
    }

    private void typeHobbies(List<Hobbies> hobbies){
        for (Hobbies h: hobbies){
            switch (h){
                case MUSIC:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
                case SPORTS:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
                case READING:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
            }
        }
    }

    private void typeSubjects(String subjects){
        inputSubject.click();
        String[] arr = subjects.split(",");
        for (String s: arr){
            inputSubject.sendKeys(s);
            inputSubject.sendKeys(Keys.ENTER);
        }
    }

    private void typeGender(Gender gender){
        WebElement btnGender = driver.findElement(By.xpath(gender.getLocator()));
        btnGender.click();
    }

    private void typeDateOfBirth(String dateOfBirth){
        filledDateOfBirth.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println(operationSystem);
        if(operationSystem.startsWith("Win"))
            filledDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        else  if(operationSystem.startsWith("Mac"))
            filledDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        filledDateOfBirth.sendKeys(dateOfBirth);
        filledDateOfBirth.sendKeys(Keys.ENTER);

    }

}

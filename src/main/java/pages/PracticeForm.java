package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PracticeForm extends BasePage{
    public PracticeForm(WebDriver driver){
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

    public void typePracticeForm(){
        hideBanner();
        hideFooter();
        inputName.sendKeys("Daria");
        inputLastName.sendKeys("Artiushin");
        inputEmail.sendKeys("marushana@yandex.ru");
        inputMobile.sendKeys("0123456789");
    }
}

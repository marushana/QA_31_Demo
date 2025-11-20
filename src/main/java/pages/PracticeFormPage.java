package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

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

    public void typePracticeForm(){
        hideBanner();
        hideFooter();
        inputName.sendKeys("Daria");
        inputLastName.sendKeys("Artiushin");
        inputEmail.sendKeys("marushana@yandex.ru");
        inputMobile.sendKeys("0123456789");
    }

    public static class ElementsPage extends BasePage {
        public ElementsPage(WebDriver driver){
            setDriver(driver);
            PageFactory.initElements
                    (new AjaxElementLocatorFactory(driver,
                            10), this);

        }

        @FindBy(xpath = "//span[text() = 'Text Box']")
        WebElement btnTextBox;

        public void clickBtnTextBox(){
            btnTextBox.click();
        }
    }

    public static class TextBoxPage extends BasePage {
        public TextBoxPage(WebDriver driver){
            setDriver(driver);
            PageFactory.initElements
                    (new AjaxElementLocatorFactory(driver,
                            10), this);

        }

        @FindBy(id = "userName")
        WebElement inputFullName;
        @FindBy(id = "userEmail")
        WebElement inputUserEmail;
        @FindBy(xpath = "//textarea[@placeholder='Current Address']")
        WebElement inputCurrentAddress;
        @FindBy(xpath = "//div[@id = 'permanentAddress-wrapper']/div[2]")
        WebElement inputPermanentAddress;

        public void typeTextBox(){
            hideBanner();
            hideFooter();
            inputFullName.sendKeys("Darya Rtiushun");
            inputUserEmail.sendKeys("marushana@mail.ru");
            inputCurrentAddress.sendKeys("Israel, Haifa, Sderot Sinai. 4A");
            inputPermanentAddress.sendKeys("Israel, Haifa, Alexander Yannay, 22");
        }

    }
}

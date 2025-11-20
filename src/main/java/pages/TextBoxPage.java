package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
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
    @FindBy(xpath = "//*[@id = 'permanentAddress']")
    WebElement inputPermanentAddress;

    public void typeTextBox() {
        hideBanner();
        hideFooter();
        inputFullName.sendKeys("Darya Artiushun");
        inputUserEmail.sendKeys("marushana@mail.ru");
        inputCurrentAddress.sendKeys("Israel, Haifa, Sderot Sinai. 4A");
        inputPermanentAddress.sendKeys("Israel, Haifa, Alexander Yannay, 22");
    }

}

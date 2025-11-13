package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XpathSelectors {
    WebDriver wd = new ChromeDriver();

    @Test
    public void selectorsRadiobuttonPage(){
        wd.get("https://demoqa.com/radio-button");
        wd.manage().window().maximize();
        pause(3);
//        WebElement radiobuttonYes = wd.findElement(By.cssSelector("label[for = 'yesRadio']"));
//        radiobuttonYes.click();
        WebElement radiobuttonYes = wd.findElement(By.xpath("//label[@for = 'yesRadio']"));
        radiobuttonYes.click();
        WebElement radiobuttonImpressive = wd.findElement(By.xpath("//*[@for = 'impressiveRadio']"));
        radiobuttonImpressive.click();
        WebElement btnTextBox = wd.findElement(By.xpath("//span[text()='Text Box']"));
        btnTextBox.click();
        WebElement fieldFullName = wd.findElement(By.xpath("//input[@placeholder = 'Full Name']"));
        fieldFullName.sendKeys("Daria");
        WebElement fieldEmail = wd.findElement(By.xpath("//input[@id = 'userEmail']"));
        fieldEmail.sendKeys("Marushana@yandex.ru");
        hideBanner();
        hideFooter();
        WebElement fieldCurrentElement = wd.findElement(By.xpath("//*[text() = 'Current Address']/../..//textarea"));
        fieldCurrentElement.sendKeys("address");
        WebElement textAreaPerAddress = wd.findElement(By.xpath("//*[@id = 'permanentAddress-wrapper']//textarea"));
        textAreaPerAddress.sendKeys("avenue 1");
        WebElement btnSubmit = wd.findElement(By.xpath("//button[text() = 'Submit']"));
        btnSubmit.click();
        WebElement output = wd.findElement(By.id("output"));
        System.out.println(output.getText());



        pause(3);
        wd.quit();

    }

    public void pause(int time){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void hideBanner(){
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#fixedban').style.display='none'");

    }public void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('footer').style.display='none'");

    }

}

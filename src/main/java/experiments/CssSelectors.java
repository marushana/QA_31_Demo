package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CssSelectors {
    WebDriver wd = new ChromeDriver();

    @Test
    public void selectorsHomePage() {
        wd.get("https://demoqa.com/");
        //wd.navigate().to("https://demoqa.com/");
        wd.manage().window().maximize();
        pause(3);
        wd.navigate().to("https://demoqa.com/elements");
        pause(3);
        wd.navigate().back();
        pause(3);
        wd.navigate().refresh();
        pause(3);
        //wd.close();//close just one active window
        wd.quit();//close browser
    }

    @Test
    public void selectorsHomePageNext(){
        wd.get("https://demoqa.com/");
        wd.manage().window().maximize();
        WebElement footer = wd.findElement(By.tagName("footer"));
        System.out.println(footer.getTagName());
        WebElement divElements = wd.findElement(By.cssSelector(".card-up"));
        divElements.click();
        WebElement radioButton = wd.findElement(By.cssSelector("#item-2"));
        radioButton.click();
        WebElement radioButtonYes = wd.findElement(By.id("yesRadio"));
//        radioButtonYes.click();
        WebElement radioButtonYesLabel = wd.findElement(By.cssSelector("label[for = 'yesRadio']"));
        radioButtonYesLabel.click();
        wd.navigate().back();
        wd.navigate().back();
        WebElement divWigets1 = wd.findElement(By.cssSelector("div[class='category-cards'] [class='card mt-4 top-card']:nth-child(4)"));
        divWigets1.click();
        pause(3);
        wd.navigate().back();
        pause(3);
        hideBanner();
        hideFooter();
        WebElement divBookStore = wd.findElement(By.cssSelector("div[class='category-cards'] [class='card mt-4 top-card']:last-child"));
        divBookStore.click();
        hideFooter();
        pause(3);
        wd.quit();



    }

    public void hideBanner(){
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#fixedban').style.display='none'");

    }public void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('footer').style.display='none'");

    }


    public void pause(int time){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

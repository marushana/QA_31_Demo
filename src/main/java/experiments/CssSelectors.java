package experiments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void pause(int time){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

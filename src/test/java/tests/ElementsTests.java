package tests;

import manager.AppManager;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

public class ElementsTests extends AppManager {
    @Test
    public void textBoxPositiveTest(){
        new HomePage(getDriver()).clickBtnElements();
        //new ElementsPage(getDriver()).clickBtnTextBox();
        //new TextBoxPage(getDriver()).typeTextBox();
    }

}

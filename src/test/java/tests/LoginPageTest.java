package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.LoginPage;
import pages.PageBase;

public class LoginPageTest extends TestBase{

    @Test
    public void loginPositiveTest(){
        String language = System.clearProperty("language");
        LoginPage myLoginPage = new LoginPage(driver);
        ContactsPage contactsPage = myLoginPage.login("test@gmail.com", "test@gmail.com");
        //sleep();
        contactsPage.selectLanguage(language);
       // sleep();
        Assert.assertEquals(contactsPage.getContacts(language).getText(), ContactsPage.getContactWord(language));
    }
}















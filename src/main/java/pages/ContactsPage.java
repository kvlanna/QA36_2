package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends PageBase {
    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class=\"btn btn-outline-warning text-white\"  and @xpath=\"2\"]")
    WebElement logOutButton;




    public LoginPage logout(){
        logOutButton.click();
        return new LoginPage(driver);
    }



    public WebElement getLogOutButton() {
        return logOutButton;
    }
    public WebElement getContacts(String lang){
        String contactWord = getContactWord(lang);
        WebElement contacts = driver.findElement(By.xpath("//a[contacts(text(),' " + contactWord + ")]"));
        return contacts;
    }
    public static String getContactWord(String lang){
        String contactWord = null;
        if (lang.equals("English")){
            contactWord = "Contacts";
        } else if (lang.equals("Russian")) {
            contactWord = "Контакты";
        }
          else if (lang.equals("German")) {
            contactWord = "Kontakte";
        }
          else if (lang.equals("Ukraine")) {
            contactWord = "Контакти";
        }
          else  {
              throw  new RuntimeException("Language is not supported: " + lang);
        }
          return contactWord;
    }

    public ContactsPage selectLanguage(String lang){
        click(selectLang);
        WebElement language = driver.findElement(By.xpath("//option[contains(text(), +lang+)]"));
        click(language);
        return this;
    }
}

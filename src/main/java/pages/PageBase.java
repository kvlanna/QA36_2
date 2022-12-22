package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class PageBase {

   WebDriver driver;

   public PageBase(WebDriver driver) {
      this.driver = driver;
      PageFactory.initElements(driver, this );
   }
   public static void sleep() {
      try {
         Thread.sleep(3000);
      } catch (InterruptedException e){
         throw new RuntimeException(e);
      }
   }

   public void click(WebElement element){
      element.click();
   }

   public void type(WebElement element, String text){
      if (text != null) {
         click(element);
         element.clear();
         element.sendKeys(text);
      }
   }
}

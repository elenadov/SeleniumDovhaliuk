package libs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class ActionWithWebElements {

    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    //we will create object and give him webdriver value
    public ActionWithWebElements (WebDriver webDriver){
        this.webDriver = webDriver;
    }

    //will work with some web element
    public void enterTextToTextField(By element, String text){
        try {
            webDriver.findElement(element).clear();
            webDriver.findElement(element).sendKeys();
            logger.info("");
        }
        catch(Exception ex){
            ex.printStackTrace();
            logger.error("");
        }

    }

    public void clickButton(By element) {
        try {
            webDriver.findElement(element).click();
            logger.info("");

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("");
        }
    }

    public boolean isElemenDisplayed(By element){
        try{
            return webDriver.findElement(element).isDisplayed();

        } catch(Exception e){
            e.printStackTrace();
            logger.error("");
            return false;
        }
    }

    public void setCheckBox(By element, boolean state){
        try{
            if (webDriver.findElement(element).isSelected() == state){
            }
            else{
                webDriver.findElement(element).click();
            }
            logger.info("The checkbox is");

        }catch(Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    private void selectElementFromDropDown(By element, String itemName){
        Select dropDownValue = new Select(webDriver.findElement(element));
        try{
            dropDownValue.selectByVisibleText(itemName);

        }catch(Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

}


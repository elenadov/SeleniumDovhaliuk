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
    public void enterTextToTextField(WebElement element, String text){
        try {
//            webDriver.findElement(element).clear();
//            webDriver.findElement(element).sendKeys();
            element.clear();
            element.sendKeys();
            logger.info("Success");
        }
        catch(Exception ex){
            ex.printStackTrace();
            logger.error("Can't enter Text");
        }

    }

    public void clickButton(WebElement element) {
        try {
//            webDriver.findElement(element).click();
            element.click();
            logger.info("");

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("");
        }
    }

    public boolean isElemenDisplayed(WebElement element){
        try{
            return element.isDisplayed(); //webDriver.findElement(element).isDisplayed();

        } catch(Exception e){
            e.printStackTrace();
            logger.error("");
            return false;
        }
    }

    public void setCheckBox(WebElement element, boolean state){
        try{
            if (element.isSelected() == state){//(webDriver.findElement(element).isSelected() == state){
            }
            else{
//                webDriver.findElement(element).click();
                element.click();
            }
            logger.info("The checkbox is");

        }catch(Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

    private void selectElementFromDropDown(WebElement element, String itemName){
        Select dropDownValue = new Select (element);//(webDriver.findElement(element));
        try{
            dropDownValue.selectByVisibleText(itemName);

        }catch(Exception e){
            e.printStackTrace();
            logger.error("");
        }
    }

}


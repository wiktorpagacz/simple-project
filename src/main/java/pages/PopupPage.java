package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopupPage extends BasePage {


    By title = By.cssSelector(".ant-modal-confirm-title");
    By message = By.cssSelector(".ant-modal-confirm-content");
    By iconData = By.cssSelector(".anticon-check-circle svg");
    By singleButton = By.cssSelector(".ant-modal-confirm-btns span");

    public PopupPage(WebDriver driver) {
        super(driver);
    }

    public String getPopupTitle() {
        waitForElementToAppear(title);
        return driver.findElement(title).getText();
    }

    public String getPopupMessage() {
        waitForElementToAppear(message);
        return driver.findElement(message).getText();
    }

    public String getPopupIcon() {
        waitForElementToAppear(iconData);
        return driver.findElement(iconData).getAttribute("data-icon");
    }

    public String getButton() {
        waitForElementToAppear(singleButton);
        return driver.findElement(singleButton).getText();
    }

    public Popup getPopup() {
        Popup popup = new Popup();
        popup.setTitle(getPopupTitle());
        popup.setMessage(getPopupMessage());
        popup.setIconData(getPopupIcon());
        popup.setButton(getButton());
        return popup;
    }

}

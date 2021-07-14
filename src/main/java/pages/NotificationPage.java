package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificationPage extends BasePage {

    By notificationBox = By.cssSelector(".ant-notification-notice");
    By message = By.cssSelector(".ant-notification-notice-message");
    By description = By.cssSelector(".ant-notification-notice-description");
    By iconData = By.cssSelector(".ant-notification-notice-with-icon svg");

    public NotificationPage(WebDriver driver) {
        super(driver);
    }

    public String getNotificationMessage() {
        waitForElementToAppear(message);
        return driver.findElement(message).getText();
    }

    public String getNotificationDescription() {
        waitForElementToAppear(description);
        return driver.findElement(description).getText();
    }

    public String getNotificationIcon() {
        waitForElementToAppear(iconData);
        return driver.findElement(iconData).getAttribute("data-icon");
    }

    public Notification getNotification() {
        Notification notification = new Notification();
        notification.setMessage(getNotificationMessage());
        notification.setDescription(getNotificationDescription());
        notification.setIconData(getNotificationIcon());
        return notification;
    }
}

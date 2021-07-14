package pages;

import common.NewsletterType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NewsletterPage extends BasePage {
    private static final String agreementLink = "https://google.pl/";

    By emailInput = By.id("newsletter_email");
    By firstNameInput = By.id("newsletter_name");
    By surnameInput = By.id("newsletter_surname");
    By newsletterTypeList = By.id("newsletter_newsType");
    By newsletterTypeListPlaceholder = By.cssSelector(".ant-select-selection__rendered .ant-select-selection__placeholder");
    By calendarBox = By.className("ant-calendar-body");
    By newsletterStartDateInput = By.cssSelector("#newsletter_startDate input");
    By newsletterEndDateInput = By.cssSelector("#newsletter_endDate input");
    By maleSexRadio = By.cssSelector("#newsletter_Sex input[value = male]");
    By femaleSexRadio = By.cssSelector("#newsletter_Sex input[value = female]");
    By agreementCheckbox = By.id("newsletter_agreement");
    By newsletterAgreementLink = By.cssSelector("span a");
    By submitButton = By.tagName("button");
    By sexRadioButton = By.cssSelector(".ant-radio-checked ~ span");
    By errorInputLabel = By.cssSelector(".has-error > div");

    public NewsletterPage(WebDriver driver) {
        super(driver);
    }

    public void fillNewsletterFields(NewsletterForm newsletterForm) {
        setNewsLetterEmail(newsletterForm.getEmail());
        setFirstName(newsletterForm.getFirstName());
        setSurname(newsletterForm.getSurname());
        selectNewsLetterType(newsletterForm.getNewsletterType());
        setStartingDate(newsletterForm.getStartingDate());
        setEndingDate(newsletterForm.getEndingDate());
        setSex(newsletterForm.getSex());
        setAgreementAccept(newsletterForm.getAgreement());
    }

    public void setNewsLetterEmail(String emailAddress) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(emailAddress);
    }

    public static String getExpectedAgreementLink() {
        return agreementLink;
    }

    public String getNewsletterEmail() {
        return driver.findElement(emailInput).getAttribute("value");
    }

    public String getEmailPlaceholder() {
        return driver.findElement(emailInput).getAttribute("placeholder");
    }

    public String getFirstNamePlaceholder() {
        return driver.findElement(firstNameInput).getAttribute("placeholder");
    }

    public String getSurnamePlaceholder() {
        return driver.findElement(surnameInput).getAttribute("placeholder");
    }

    public String getTypePlaceholder() {
        return driver.findElement(newsletterTypeListPlaceholder).getText();
    }

    public String getStartingDatePlaceholder() {
        return driver.findElement(newsletterStartDateInput).getAttribute("placeholder");
    }

    public String getEndingDatePlaceholder() {
        return driver.findElement(newsletterEndDateInput).getAttribute("placeholder");
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public String getFirstName() {
        return driver.findElement(firstNameInput).getAttribute("value");
    }

    public void clearFirstName() {
        clearInput(firstNameInput);
        waitForElementToAppear(errorInputLabel);
    }

    public void clearSurname() {
        clearInput(surnameInput);
        waitForElementToAppear(errorInputLabel);
    }

    public NewsletterForm getNewsletter(NewsletterForm actualNewsletter) {
        actualNewsletter.setEmail(getNewsletterEmail());
        actualNewsletter.setFirstName(getFirstName());
        actualNewsletter.setSurname(getSurname());
        actualNewsletter.setNewsletterType(getNewsletterType());
        actualNewsletter.setStartingDate(getStartDate());
        actualNewsletter.setEndingDate(getEndingDate());
        actualNewsletter.setSex(getSex());
        actualNewsletter.setAgreement(getAgreementAccept());
        return actualNewsletter;
    }

    public NewsletterForm getNewsletterPlaceholders(NewsletterForm actualNewsletter) {
        actualNewsletter.setEmailPlaceholder(getEmailPlaceholder());
        actualNewsletter.setFirstNamePlaceholder(getFirstNamePlaceholder());
        actualNewsletter.setSurnamePlaceholder(getSurnamePlaceholder());
        actualNewsletter.setTypePlaceholder(getTypePlaceholder());
        actualNewsletter.setStartingDatePlaceholder(getStartingDatePlaceholder());
        actualNewsletter.setEndingDatePlaceholder(getEndingDatePlaceholder());
        return actualNewsletter;
    }

    public NewsletterType getNewsletterType() {
        String typeText = driver.findElement(newsletterTypeList).getText();
        return NewsletterType.getByName(typeText);
    }

    public int getFieldErrorAmount() {
        return driver.findElements(errorInputLabel).size();
    }

    public String getFieldErrorText() {
        return driver.findElement(errorInputLabel).getText();
    }

    public void clearEmail() {
        clearInput(emailInput);
        waitForElementToAppear(errorInputLabel);
    }

    public void clearStartDate() {
        driver.findElement(By.cssSelector("#newsletter_startDate input ~ i:nth-of-type(2)")).click();
        waitForElementToAppear(errorInputLabel);
    }

    public void clearEndingDate() {
        driver.findElement(By.cssSelector("#newsletter_endDate input ~ i:nth-of-type(2)")).click();
    }

    public List<WebElement> getErrorValidationLabels() {
        waitForElementsToAppear(driver.findElements(errorInputLabel));
        return driver.findElements(errorInputLabel);
    }

    public List<WebElement> getErrorLabels() {
        waitForElementsToAppear(driver.findElements(errorInputLabel));
        return driver.findElements(errorInputLabel);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameInput).clear();
        driver.findElement(surnameInput).sendKeys(surname);
    }

    public String getSurname() {
        return driver.findElement(surnameInput).getAttribute("value");
    }

    public void openStartDateCalendar() {
        waitForElementToAppear(newsletterStartDateInput);
        driver.findElement(newsletterStartDateInput).click();
        waitForElementToAppear(calendarBox);
    }

    public void openEndDateCalendar() {
        waitForElementToAppear(newsletterEndDateInput);
        driver.findElement(newsletterEndDateInput).click();
        waitForElementToAppear(calendarBox);
    }

    public void setStartingDate(Date date) {
        if (date != null) {
            openStartDateCalendar();
            SimpleDateFormat dt = new SimpleDateFormat("MMMM d, yyyy", Locale.US);
//            SimpleDateFormat dti = new SimpleDateFormat("yyyy-MM-dd");
            driver.findElement(By.cssSelector("td[title=\"" + dt.format(date) + "\"]")).click();
            waitForElementToDisappear(calendarBox);
        }
    }

    public Date getStartDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date startingDate = null;
        try {
            startingDate = formatter.parse(driver.findElement(newsletterStartDateInput).getAttribute("value"));
        } catch (ParseException e) {
            System.out.println("Exception - wrong data format");
        }
        return startingDate;
    }

    public Date getEndingDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date endingDate = null;
        try {
            endingDate = formatter.parse(driver.findElement(newsletterEndDateInput).getAttribute("value"));
        } catch (ParseException e) {
            System.out.println("Exception - wrong data format");
        }
        return endingDate;
    }


    public void setAgreementAccept(boolean accept) {
        if (accept)
            driver.findElement(agreementCheckbox).click();
    }

    public boolean getAgreementAccept() {
        return driver.findElement(agreementCheckbox).isSelected();
    }

    public String getAgreementLink() {
        return driver.findElement(newsletterAgreementLink).getAttribute("href");
    }

    public void clearAgreementCheckbox() {
        driver.findElement(agreementCheckbox).click();
        waitForElementToAppear(newsletterStartDateInput);
    }

    public void setSex(String sex) {
        driver.findElement(By.cssSelector("#newsletter_Sex input[value = \"" + sex + "\"]")).click();
    }

    public String getSex() {
        return driver.findElement(sexRadioButton).getText().toLowerCase();
    }

    public void setEndingDate(Date date) {
        openEndDateCalendar();
//        driver.findElement(By.cssSelector(".ant-calendar-date-panel")).sendKeys(Keys.PAGE_DOWN);
        SimpleDateFormat dt = new SimpleDateFormat("MMMM d, yyyy", Locale.US);
//        SimpleDateFormat dti = new SimpleDateFormat("yyyy-MM-dd");
        while (!isElementPresent(By.cssSelector("td[title=\"" + dt.format(date) + "\"]"))) {
            driver.findElement(By.cssSelector(".ant-calendar-date-panel")).sendKeys(Keys.PAGE_DOWN);
        }
        driver.findElement(By.cssSelector("td[title=\"" + dt.format(date) + "\"]")).click();
        waitForElementToDisappear(calendarBox);
    }

    public String getSubmitButtonText() {
        return driver.findElement(submitButton).findElement(By.tagName("span")).getText();
    }

    public void clickSubmitButton(Boolean validData) {
        driver.findElement(submitButton).click();
        if (!validData) {
            waitForElementToAppear(errorInputLabel);
        }
    }

    public void selectNewsLetterType(NewsletterType newsletterType) {
        waitForElementToAppear(newsletterTypeList);
        driver.findElement(newsletterTypeList).click();
        driver.findElement(By.cssSelector("ul[role=listbox] li:nth-child(" + newsletterType.getOrder() + ")")).click();
    }

}

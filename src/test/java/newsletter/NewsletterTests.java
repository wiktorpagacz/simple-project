package newsletter;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import common.NewsletterFieldValidationErrors;
import common.NewsletterType;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class NewsletterTests extends BaseTests {


    @Test(testName = "Newsletter subscription with short end date", enabled = true, priority = 2)
    public void trySubscribeForLessThanThirtyDays() {
        Notification dateErrorNotification = new Notification("Error", "\"endDate\" must be at least 30 days after the \"startDate\"!", "close-circle");
        NewsletterForm newsletterEndingDateEqualsStartingDate = new NewsletterForm("adress@email.com", "John", "Doe", NewsletterType.IT, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "male", true);
        NewsletterPage newsletterPage = new NewsletterPage(getDriver());
        NewsletterForm actualNewsletter = new NewsletterForm();
        assertNewsletterPlaceholders(newsletterPage.getNewsletterPlaceholders(actualNewsletter), newsletterEndingDateEqualsStartingDate);
        newsletterPage.fillNewsletterFields(newsletterEndingDateEqualsStartingDate);
        Assert.assertEquals(newsletterPage.getAgreementLink(), NewsletterPage.getExpectedAgreementLink(),
                String.format("Agreement link is incorrect - expected %s but found %s", NewsletterPage.getExpectedAgreementLink(), newsletterPage.getAgreementLink()));
        Assert.assertEquals(newsletterPage.getSubmitButtonText(), "Submit",
                String.format("Wrong submit button text - expected %s, but found %s", "Submit", newsletterPage.getSubmitButtonText()));
        assertNewsletter(newsletterPage.getNewsletter(actualNewsletter), newsletterEndingDateEqualsStartingDate);
        newsletterPage.clickSubmitButton(true);
        NotificationPage notificationPage = new NotificationPage(getDriver());
        assertNotifications(notificationPage.getNotification(), dateErrorNotification);
    }

    @Test(testName = "Newsletter subscription with long date", enabled = true, priority = 3)
    public void subscribeToNewsletter() throws InterruptedException{
        Notification agreementErrorNotification = new Notification("Error", "\"agreement\" must be [true]", "close-circle");
        NewsletterPage newsletterPage = new NewsletterPage(getDriver());
        NewsletterForm expectedNewsletter = new NewsletterForm("adress@email.com", "John", "Doe", NewsletterType.INDUSTRY, Calendar.getInstance().getTime(), Date.from((LocalDate.now().plusMonths(1)).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), "female", true);
        NewsletterForm actualNewsletter = new NewsletterForm();
        PopupPage modalPage = new PopupPage(getDriver());
        Popup expectedSuccessPopup = new Popup("Successfully added to newsletter", "Thank you!", "check-circle", "OK");
        newsletterPage.setNewsLetterEmail(expectedNewsletter.getEmail());
        newsletterPage.clearEmail();
        assertSingleFieldValidation(NewsletterFieldValidationErrors.EMAIL, newsletterPage.getFieldErrorText());
        newsletterPage.setNewsLetterEmail(expectedNewsletter.getEmail());
        newsletterPage.setFirstName(expectedNewsletter.getFirstName());
        newsletterPage.clearFirstName();
        assertSingleFieldValidation(NewsletterFieldValidationErrors.FIRSTNAME, newsletterPage.getFieldErrorText());
        newsletterPage.setFirstName(expectedNewsletter.getFirstName());
        newsletterPage.setSurname(expectedNewsletter.getSurname());
        newsletterPage.clearSurname();
        assertSingleFieldValidation(NewsletterFieldValidationErrors.SURNAME, newsletterPage.getFieldErrorText());
        newsletterPage.setSurname(expectedNewsletter.getSurname());
        newsletterPage.selectNewsLetterType(expectedNewsletter.getNewsletterType());
        newsletterPage.setStartingDate(expectedNewsletter.getStartingDate());
        newsletterPage.clearStartDate();
        assertSingleFieldValidation(NewsletterFieldValidationErrors.STARTING_DATE, newsletterPage.getFieldErrorText());
        newsletterPage.setStartingDate(expectedNewsletter.getStartingDate());
        newsletterPage.setEndingDate(Date.from((LocalDate.now().plusMonths(1)).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        newsletterPage.setSex(expectedNewsletter.getSex());
        newsletterPage.clearAgreementCheckbox();
        newsletterPage.clickSubmitButton(true);
        NotificationPage notificationPage = new NotificationPage(getDriver());
        assertNotifications(notificationPage.getNotification(), agreementErrorNotification);
        newsletterPage.setAgreementAccept(expectedNewsletter.getAgreement());
        Assert.assertEquals(newsletterPage.getAgreementLink(), NewsletterPage.getExpectedAgreementLink(),
                String.format("Agreement link is incorrect - expected %s but found %s", NewsletterPage.getExpectedAgreementLink(), newsletterPage.getAgreementLink()));
        assertNewsletter(newsletterPage.getNewsletter(actualNewsletter), expectedNewsletter);
        newsletterPage.clickSubmitButton(true);
        assertModal(modalPage.getPopup(), expectedSuccessPopup);
    }

    @Test(testName = "Check error labels under fields.", enabled = true, priority = 1)
    public void checkMandatoryLabels() {
        NewsletterPage newsletterPage = new NewsletterPage(getDriver());
        newsletterPage.clickSubmitButton(false);
        assertErrorValidationMessage(newsletterPage.getErrorValidationLabels());
    }
}

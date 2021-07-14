package base;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import common.NewsletterFieldValidationErrors;
import pages.NewsletterForm;
import pages.Notification;
import pages.Popup;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class commonAssertions {
    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    protected static void assertNotifications(Notification actualNotification, Notification expectedNotification) {
        Assert.assertEquals(actualNotification.getMessage(), expectedNotification.getMessage(),
                String.format("Wrong notification message - expected %s, but got %s.", expectedNotification.getMessage() , actualNotification.getMessage()));
        Assert.assertEquals(actualNotification.getDescription(), expectedNotification.getDescription(),
                String.format("Wrong notification description - expected %s, but got %s.", expectedNotification.getDescription() , actualNotification.getDescription()));
        Assert.assertEquals(actualNotification.getIconType(), expectedNotification.getIconType(),
                String.format("Wrong notification icon data - expected %s, but got %s.", expectedNotification.getIconType() , actualNotification.getIconType()));
    }

    protected static void assertNewsletter(NewsletterForm actualNewsletterForm, NewsletterForm expectedNewsletterForm){
        Assert.assertEquals(actualNewsletterForm.getEmail(), expectedNewsletterForm.getEmail(),
                String.format("E-mail address in field is invalid - expected %s, but found %s", expectedNewsletterForm.getEmail(), actualNewsletterForm.getEmail()));
        Assert.assertEquals(actualNewsletterForm.getFirstName(), expectedNewsletterForm.getFirstName(),
                String.format("Firstname in field is invalid - expected %s, but found %s", expectedNewsletterForm.getFirstName(), actualNewsletterForm.getFirstName()));
        Assert.assertEquals(actualNewsletterForm.getSurname(), expectedNewsletterForm.getSurname(),
                String.format("Surname in field is invalid - expected %s, but found %s", expectedNewsletterForm.getSurname(), actualNewsletterForm.getSurname()));
        Assert.assertEquals(actualNewsletterForm.getNewsletterType(), expectedNewsletterForm.getNewsletterType(),
                String.format("Newsletter type in field is invalid - expected %s, but found %s", expectedNewsletterForm.getNewsletterType(), actualNewsletterForm.getNewsletterType()));
        Assert.assertEquals(formatter.format(actualNewsletterForm.getStartingDate()), formatter.format(expectedNewsletterForm.getStartingDate()),
                String.format("Starting date in field is invalid - expected %s, but found %s", formatter.format(expectedNewsletterForm.getStartingDate()), formatter.format(actualNewsletterForm.getStartingDate())));
        Assert.assertEquals(formatter.format(actualNewsletterForm.getEndingDate()), formatter.format(expectedNewsletterForm.getEndingDate()),
                String.format("Ending date in field is invalid - expected %s, but found %s", formatter.format(expectedNewsletterForm.getEndingDate()), formatter.format(actualNewsletterForm.getEndingDate())));
        Assert.assertEquals(actualNewsletterForm.getSex(), expectedNewsletterForm.getSex(),
                String.format("Selected sex radiobutton is invalid - expected %s, but found %s", expectedNewsletterForm.getSex(), actualNewsletterForm.getSex()));
        Assert.assertEquals(actualNewsletterForm.getAgreement(), expectedNewsletterForm.getAgreement(),
                String.format("Agreement checkbox value is invalid - expected %s, but found %s", expectedNewsletterForm.getAgreement(), actualNewsletterForm.getAgreement()));
    }

    public static void assertNewsletterPlaceholders(NewsletterForm acutalNewsletterPlaceholders, NewsletterForm expectedNewsletterPlaceholders) {
        Assert.assertEquals(acutalNewsletterPlaceholders.getEmailPlaceholder(), expectedNewsletterPlaceholders.getEmailPlaceholder() ,
                "Wrong placeholder in email input.");
        Assert.assertEquals(acutalNewsletterPlaceholders.getFirstNamePlaceholder(), expectedNewsletterPlaceholders.getFirstNamePlaceholder(),
                "Wrong placeholder in firstname input.");
        Assert.assertEquals(acutalNewsletterPlaceholders.getSurnamePlaceholder(), expectedNewsletterPlaceholders.getSurnamePlaceholder(),
                "Wrong placeholder in surname input.");
        Assert.assertEquals(acutalNewsletterPlaceholders.getTypePlaceholder(), expectedNewsletterPlaceholders.getTypePlaceholder(),
                "Wrong placeholder in newsletter type input.");
        Assert.assertEquals(acutalNewsletterPlaceholders.getStartingDatePlaceholder(), expectedNewsletterPlaceholders.getStartingDatePlaceholder(),
                "Wrong placeholder in newsletter starting date");
        Assert.assertEquals(acutalNewsletterPlaceholders.getEndingDatePlaceholder(), expectedNewsletterPlaceholders.getEndingDatePlaceholder(),
                "Wrong placeholder in newsletter ending date");
    }

    public void assertSingleFieldValidation(NewsletterFieldValidationErrors validationError, String expectedValidationError){
        Assert.assertEquals(validationError.getErrorText(), expectedValidationError,
                String.format("Wrong validation error: field %s, expected message %s, but found %s", validationError.getFieldName(), validationError.getErrorText(), expectedValidationError));
    }

    public void assertModal(Popup actualPopup, Popup expectedPopup) {
        Assert.assertEquals(actualPopup.getTitle(), expectedPopup.getTitle() ,
                "Wrong modal title.");
        Assert.assertEquals(actualPopup.getMessage(), expectedPopup.getMessage() ,
                "Wrong modal message.");
        Assert.assertEquals(actualPopup.getIconData(), expectedPopup.getIconData() ,
                "Wrong modal icon.");
        Assert.assertEquals(actualPopup.getButton(), expectedPopup.getButton() ,
                "Wrong modal button text.");
    }

    public static void assertErrorValidationMessage(List<WebElement> errorLabels) {
        for(int i = 0; i< errorLabels.size(); i++){
            Assert.assertEquals(errorLabels.get(i).getText(), NewsletterFieldValidationErrors.getErrorTextByOrder(i+1),
                    "Incorrect error label under field!");
        }
    }
}

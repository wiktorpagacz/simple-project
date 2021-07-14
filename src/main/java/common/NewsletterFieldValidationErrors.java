package common;

import java.util.HashMap;
import java.util.Map;

public enum NewsletterFieldValidationErrors {
    EMAIL(1, "Email","The \"E-mail\" field is required!"),
    FIRSTNAME(2, "FirstName", "The \"First name\" field is required!"),
    SURNAME(3, "Surname", "The \"Surname\" field is required!"),
    TYPE(4, "Newsletter Type", "The \"newsletter type\" field is required!"),
    STARTING_DATE(5, "Starting Date", "The \"Start date\" field is required!"),
    CONDITIONS(6, "Agreement", "Accepting terms and condition is required!");

    private final String errorText;
    private final String fieldName;
    private final int order;
    private static final Map<Integer, String> map = new HashMap<>();

    NewsletterFieldValidationErrors(int order, String fieldName, String errorText) {
        this.order = order;
        this.fieldName = fieldName;
        this.errorText = errorText;
    }

    static {
        for (NewsletterFieldValidationErrors newsletterFieldValidationErrors : NewsletterFieldValidationErrors.values()) {
            map.put(newsletterFieldValidationErrors.order, newsletterFieldValidationErrors.errorText);
        }
    }

    public String getErrorText() {
        return this.errorText;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public static String getErrorTextByOrder(int order) {
        return (String) map.get(order);
    }

}
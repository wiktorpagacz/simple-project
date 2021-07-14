package pages;

import common.NewsletterType;

import java.util.Date;

public class NewsletterForm {
    //Form fields and parameteres
    private String email;
    private String firstName;
    private String surname;
    private NewsletterType newsletterType;
    private Date startingDate;
    private Date endingDate;
    private String sex;
    private Boolean agreement;
    //Fields placeholders
    private String emailPlaceholder = "Please input your email address";
    private String firstNamePlaceholder = "Please input your first name";
    private String surnamePlaceholder = "Please input your surname";
    private String typePlaceholder = "Please select a newsletter type";
    private String startingDatePlaceholder = "Select Date";
    private String endingDatePlaceholder = "Select Date";

    public String getEmailPlaceholder() {
        return emailPlaceholder;
    }

    public void setEmailPlaceholder(String emailPlaceholder) {
        this.emailPlaceholder = emailPlaceholder;
    }

    public String getFirstNamePlaceholder() {
        return firstNamePlaceholder;
    }

    public void setFirstNamePlaceholder(String firstNamePlaceholder) {
        this.firstNamePlaceholder = firstNamePlaceholder;
    }

    public String getSurnamePlaceholder() {
        return surnamePlaceholder;
    }

    public void setSurnamePlaceholder(String surnamePlaceholder) {
        this.surnamePlaceholder = surnamePlaceholder;
    }

    public String getTypePlaceholder() {
        return typePlaceholder;
    }

    public void setTypePlaceholder(String typePlaceholder) {
        this.typePlaceholder = typePlaceholder;
    }

    public String getStartingDatePlaceholder() {
        return startingDatePlaceholder;
    }

    public void setStartingDatePlaceholder(String startingDatePlaceholder) {
        this.startingDatePlaceholder = startingDatePlaceholder;
    }

    public String getEndingDatePlaceholder() {
        return endingDatePlaceholder;
    }

    public void setEndingDatePlaceholder(String endingDatePlaceholder) {
        this.endingDatePlaceholder = endingDatePlaceholder;
    }

    public NewsletterForm(){}

    public NewsletterForm(String email, String firstName, String surname, NewsletterType newsletterType, Date startingDate, Date endingDate, String sex, Boolean agreement) {
        this.email = email;
        this.firstName = firstName;
        this.surname = surname;
        this.newsletterType = newsletterType;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.sex = sex;
        this.agreement = agreement;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public NewsletterType getNewsletterType() {
        return newsletterType;
    }

    public void setNewsletterType(NewsletterType newsletterType) {
        this.newsletterType = newsletterType;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Boolean getAgreement() {
        return agreement;
    }

    public void setAgreement(Boolean agreement) {
        this.agreement = agreement;
    }
}

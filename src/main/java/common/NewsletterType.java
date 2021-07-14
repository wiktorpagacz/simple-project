package common;

public enum NewsletterType {
    IT("IT", 1),
    INDUSTRY("Industry", 2),
    MEDICAL("Medical", 3);

    private final int order;
    private final String name;

    NewsletterType(String name, int order){
        this.order = order;
        this.name = name;
    }

    public int getOrder() {
        return this.order;
    }

    public String getName() {
        return this.name;
    }

    public static NewsletterType getByName(String name) throws IllegalArgumentException {
        NewsletterType newsletterType;
        switch(name) {
            case "IT":
                newsletterType = NewsletterType.IT;
                break;
            case "Industry":
                newsletterType = NewsletterType.INDUSTRY;
                break;
            case "Medical":
                newsletterType =NewsletterType.MEDICAL;
                break;
            default:
                throw new IllegalArgumentException("Incorrect NewsletterType name!");
        }
        return newsletterType;
    }
}

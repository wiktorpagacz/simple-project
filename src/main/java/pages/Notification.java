package pages;

public class Notification {
    private String message;
    private String description;
    private String iconData;

    public Notification() {

    }

    public Notification(String message, String description, String iconData) {
        this.message = message;
        this.description = description;
        this.iconData = iconData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconType() {
        return iconData;
    }

    public void setIconData(String iconData) {
        this.iconData = iconData;
    }
}

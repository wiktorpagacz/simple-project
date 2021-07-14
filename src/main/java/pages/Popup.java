package pages;

public class Popup {
    private String title;
    private String message;
    private String iconData;
    private String button;

    public Popup() {

    }

    public Popup(String title, String message, String iconData, String button) {
        this.title = title;
        this.message = message;
        this.iconData = iconData;
        this.button = button;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIconData() {
        return iconData;
    }

    public void setIconData(String iconData) {
        this.iconData = iconData;
    }
}

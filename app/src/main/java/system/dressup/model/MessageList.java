package system.dressup.model;

/**
 * Created by idea on 2018/4/2.
 *
 * @author Soloist
 */

public class MessageList {

    private int headerImageId;

    private String username;

    private String message;

    public MessageList() {
    }

    public MessageList(int headerImageId, String username, String message) {
        this.headerImageId = headerImageId;
        this.username = username;
        this.message = message;
    }

    public int getHeaderImageId() {
        return headerImageId;
    }

    public void setHeaderImageId(int headerImageId) {
        this.headerImageId = headerImageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

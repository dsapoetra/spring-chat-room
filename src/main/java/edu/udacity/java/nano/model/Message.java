package edu.udacity.java.nano.model;

/**
 * WebSocket message model
 */
public class Message {
    // TODO: add message model.

    private String message;
    private String username;
    private String type;
    private String onlineCount;

    public Message(String message, String username, String type, String onlineCount) {
        this.message = message;
        this.username = username;
        this.type = type;
        this.onlineCount = onlineCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(String onlineCount) {
        this.onlineCount = onlineCount;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", username='" + username + '\'' +
                ", type='" + type + '\'' +
                ", onlineCount='" + onlineCount + '\'' +
                '}';
    }
}

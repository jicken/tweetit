package de.adorsys.tweetitgui.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: torben
 * Date: 04.05.12
 * Time: 21:42
 * To change this template use File | Settings | File Templates.
 */
public class TweetDTO {
    private String userId;

    @NotNull
    @Size(min = 2, max = 140)
    private String message;

    private String cdate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    @Override
    public String toString() {
        return "TweetDTO{" +
              "userId='" + userId + '\'' +
              ", message='" + message + '\'' +
              ", cdate='" + cdate + '\'' +
              '}';
    }
}



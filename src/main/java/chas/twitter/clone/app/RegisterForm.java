package chas.twitter.clone.app;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


// If the form is empty, if empty is set as default it will contain empty string
public class RegisterForm {
    @Size(min = 4, max = 20, message = "User ID is 4 to 20 characters")
    @Pattern(regexp = "[a-zA-Z0-9]*", message = "Only alphabets or numbers can be used")
    private String userId;

    @Size(min = 4, max = 20, message = "Password must be 4 to 20 characters")
    @Pattern(regexp = "[a-zA-Z0-9]*", message = "Only alphabets or numbers can be used")
    private String password;

    @Size(max = 25, message = "Handle name is 25 characters or less")
    private String screenName;


    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

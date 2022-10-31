package application.core.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import application.validation.ValidEmail;

public class UserDto {

    @NotNull
    @NotEmpty(message = "Email is required.")
    @ValidEmail
    private String email;

    @NotNull
    @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters.")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

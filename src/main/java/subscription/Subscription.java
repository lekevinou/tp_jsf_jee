package subscription;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Objects;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Subscription implements java.io.Serializable {
    private String email;
    private String password;
    private URL website;
    private Date creationDate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String password) {
        return this.password != null && password != null && !password.isEmpty() && this.password.equals(password);
    }

    public URL getWebsite() {
        return website;
    }

    public void setWebsite(URL siteWeb) {
        this.website = siteWeb;
    }

    public boolean isWebsiteAvailable() {
        if (this.website == null) {
            return false;
        }
        try (InputStream s = this.website.openStream()) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean checkEmail() {
        return Objects.toString(email, "").matches("\\S+@\\S+");
    }

    public boolean checkPassword() {
        return Objects.toString(password, "").length() >= 8;
    }

}

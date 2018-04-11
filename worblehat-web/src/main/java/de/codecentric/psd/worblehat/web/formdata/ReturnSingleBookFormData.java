package de.codecentric.psd.worblehat.web.formdata;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * This class represent the form data of the return book form.
 */
public class ReturnSingleBookFormData {

    @NotEmpty(message = "{empty.returnAllBookFormData.emailAddress}")
    @Email(message = "{notvalid.returnAllBookFormData.emailAddress}")
    private String emailAddress;

    private String isbn;

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}

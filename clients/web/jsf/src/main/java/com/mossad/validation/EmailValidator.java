package com.mossad.validation;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Piotr
 */
@FacesValidator("com.mossad.EmailValidator")
public class EmailValidator implements Validator {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\."
        + "[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*"
        + "(\\.[A-Za-z]{2,})$";
    private Pattern pattern;
    private Matcher matcher;

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException {

        matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {

            FacesMessage msg =
                new FacesMessage("E-mail validation failed.",
                    "Invalid E-mail format.");
            // this message is anyway overriden by settings in facelet but bundle could be used here
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}
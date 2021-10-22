package com.mossad.validation;


import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

/**
 * @author Piotr
 */
@FacesValidator("com.mossad.PasswordValidator")
public class PasswordValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException {
        String password = (String) value;

        if (password.length() < 5) {
            FacesMessage msg =
                new FacesMessage("Password is not long enough.",
                    "Invalid password.");
            // this message is anyway overriden by settings in facelet but bundle could be used here
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            UIInput input = (UIInput) component;
            input.setValue(value);
            throw new ValidatorException(msg);
        }
    }
}
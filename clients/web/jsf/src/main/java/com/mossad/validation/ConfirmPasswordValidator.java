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
@FacesValidator("com.mossad.ConfirmPasswordValidator")
public class ConfirmPasswordValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException {
        UIInput confirmComponent = (UIInput) component.getAttributes().get("confirmFor");
        String confirm = (String) confirmComponent.getValue();

        if (!value.equals(confirm)) {
            FacesMessage msg =
                new FacesMessage("Passwords do not match.",
                    "Passwords do not match.");
            // this message is anyway overriden by settings in facelet but bundle could be used here
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            UIInput input = (UIInput) component;
            input.setValue(value);
            throw new ValidatorException(msg);
        }
    }
}
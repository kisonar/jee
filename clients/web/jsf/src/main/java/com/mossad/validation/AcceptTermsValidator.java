package com.mossad.validation;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

/**
 * @author Piotr
 */
@FacesValidator("com.mossad.AcceptTermsValidator")
public class AcceptTermsValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException {

        if (!((Boolean) value)) {

            FacesMessage msg =
                new FacesMessage("You must accept terms and conditions.",
                    "You must accept terms and conditions.");
            // this message is anyway overriden by settings in facelet but bundle could be used here
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.cs.cs490.mycompany.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Bilguun
 */
@FacesValidator(value = "PhonenumberValidator")
public class PhonenumberValidator implements Validator {

    private static final String expression = "\\d{3}[-\\s]\\d{3}[-\\s]\\d{4}";

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        String input = String.valueOf(value);

        Pattern pattern = Pattern.compile(expression);

        Matcher matcher = pattern.matcher(input);

        if (!matcher.matches()) {
            FacesMessage msg
                    = new FacesMessage("Phone number  validation failed.",
                            "Invalid Phone Number format - Format should be xxx-xxx-xxxx");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

}

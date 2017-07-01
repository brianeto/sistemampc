/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.cliente.controladores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Andres
 */
@FacesValidator(value = "passwordValidator")
public class PasswordValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String campo = (String) component.getAttributes().get("campo");
        UIInput otherValue = (UIInput) context.getViewRoot().findComponent(campo);
        if (!value.equals(otherValue.getValue())) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"","Las contraseñas no coinciden."));
        }
    }

}

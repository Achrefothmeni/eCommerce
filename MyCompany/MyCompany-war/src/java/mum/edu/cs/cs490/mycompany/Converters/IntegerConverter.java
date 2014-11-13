/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.Converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Bilguun
 */
@FacesConverter(forClass = mum.edu.cs.cs490.mycompany.Converters.IntegerConverter.class, value="IntegerConverter")
public class IntegerConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer toParse = null;
        if(value != null){
            try {
                toParse = Integer.parseInt(value);
            } catch (Exception e) {
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "incorrect as Integer - Check value", "Can't convert Integer to String");
                throw new ConverterException(facesMessage);
            }
        }
        
        return toParse;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof Integer){
            return Integer.toString((Integer) value);
        }else{
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "incorrect as Integer - Check value", "Can't convert Integer to String");
            throw new ConverterException(facesMessage);
        }
    }
    
    
    
}

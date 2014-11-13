/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.cs.cs490.mycompany.Converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@FacesConverter(forClass = mum.edu.cs.cs490.mycompany.Converters.DateConverter.class, value = "DateConverter")
public class DateConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date date = null;
            try {
                date = sdf.parse(value);
            } catch (ParseException ex) {
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "incorrect as Date - Format should be : MM/dd/YYYY", "Can't convert Date to String");
                throw new ConverterException(facesMessage);
            }

            return date;
        } else {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "incorrect as Date", "Can't convert Date to String");
            throw new ConverterException(facesMessage);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Date) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            return sdf.format((Date) value);
        } else {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "incorrect as Date", "Can't convert Date to String");
            throw new ConverterException(facesMessage);
        }
    }

}

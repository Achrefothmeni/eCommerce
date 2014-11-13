/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.cs.cs490.mycompany.Converters;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import mum.edu.cs.cs490.mycompany.entities.Category;
import mum.edu.cs.cs490.mycompany.facade.CategoryFacade;

/**
 *
 * @author Bilguun
 */
@FacesConverter(forClass = mum.edu.cs.cs490.mycompany.Converters.CategoryConverter.class, value = "CategoryConverter")
public class CategoryConverter implements Converter {

    @EJB
    private CategoryFacade cf;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Category category = cf.getCategoryByName(value);

        if (category != null) {
            return category;
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something happen when try to convert category", "Check Input");

            throw new ConverterException(fm);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Category) {
            return ((Category) value).getName();
        }

        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something happen when try to convert category", "Check Input");

        throw new ConverterException(fm);
    }

}

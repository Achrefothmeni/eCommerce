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
import mum.edu.cs.cs490.mycompany.entities.Brand;
import mum.edu.cs.cs490.mycompany.entities.Category;
import mum.edu.cs.cs490.mycompany.facade.BrandFacade;

/**
 *
 * @author Bilguun
 */
@FacesConverter(forClass = mum.edu.cs.cs490.mycompany.Converters.BrandConverter.class, value = "BrandConverter")
public class BrandConverter implements Converter {

    @EJB
    private BrandFacade bf;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Brand brand = bf.getBrandByName(value);

        if (brand != null) {
            return brand;
        }

        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Check Input", "Something happen when try to convert brand");

        throw new ConverterException(fm);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof Brand) {
            return ((Brand) value).getName();
        }

        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Check Input", "Something happen when try to convert brand");

        throw new ConverterException(fm);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.cs.cs490.mycompany.managedbeans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import mum.edu.cs.cs490.mycompany.entities.Brand;
import mum.edu.cs.cs490.mycompany.entities.Category;
import mum.edu.cs.cs490.mycompany.entities.Customer;
import mum.edu.cs.cs490.mycompany.entities.Product;
import mum.edu.cs.cs490.mycompany.facade.BrandFacade;
import mum.edu.cs.cs490.mycompany.facade.CategoryFacade;
import mum.edu.cs.cs490.mycompany.facade.CustomerFacade;
import mum.edu.cs.cs490.mycompany.facade.ProductFacade;

/**
 *
 * @author Bilguun
 */
@Named
@RequestScoped
public class ProductMB {

    @EJB
    private CategoryFacade cf;

    @EJB
    private ProductFacade pf;

    @EJB
    private BrandFacade bf;

    @EJB
    private CustomerFacade ccf;

    private Product product;
    private Brand brand;

    /**
     * Creates a new instance of ProductMB
     */
    public ProductMB() {
        if (product == null) {
            product = new Product();
        }
    }

    /**
     * ******* Accessors Methods **************
     */
    public List<Category> getCategories() {
        return cf.getAll();
    }

    public List<Brand> getBrands() {
        return bf.getAll();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * ******** Action Method ******************
     */
    public void addProduct(ActionEvent actionEvent) {
        if (product != null && brand != null) {

            Customer vendor = ccf.getCustomerByUsername("billy");

            product.setVendor(vendor);
            product.addBrands(brand);

            pf.save(product);

            product = null;
        }
    }

    
}

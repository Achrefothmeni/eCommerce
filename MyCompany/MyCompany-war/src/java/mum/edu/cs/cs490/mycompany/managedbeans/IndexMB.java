/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.cs.cs490.mycompany.managedbeans;

import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import mum.edu.cs.cs490.mycompany.entities.Brand;
import mum.edu.cs.cs490.mycompany.entities.Category;
import mum.edu.cs.cs490.mycompany.entities.Product;
import mum.edu.cs.cs490.mycompany.facade.CategoryFacade;
import mum.edu.cs.cs490.mycompany.facade.CustomerFacade;
import mum.edu.cs.cs490.mycompany.facade.ProductFacade;

/**
 *
 * @author Bilguun
 */
@Named
@RequestScoped
public class IndexMB {
    
    @EJB
    private ProductFacade pf;
    
    @EJB
    private CategoryFacade cf;
    
    @EJB
    private CustomerFacade ccf;
    
    @Inject
    private ProductDetailsMB productDetailMB;
    
    public IndexMB() {
    }

    public List<Product> getProducts() {
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
        Category category = (Category) request.getAttribute("selectedCategory");
        
        if(category != null)
            return category.getProducts();
        
        return pf.getAll();
    }
    
    public List<Category> getCategories(){
        return cf.getAll();
    }

    public String getBrandName(Product product) {
        if (product.getBrands().size() > 0) {
            Brand brand = product.getBrands().get(0);

            return brand.getName();
        }
        
        return null;
    }
    
    public String actionFilterCategories(Category category){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        
        request.setAttribute("selectedCategory", category);
        
        return "index";
    }
    
    public String actionProductDetails(Product product){
        productDetailMB.setProduct(product);
        return productDetailMB.toString();
    }
    
    public String getImage() {
        Random r = new Random();
        
        int n = r.nextInt(4) + 1;
        
        StringBuilder sb = new StringBuilder("image");
        
        sb.append(n);
        sb.append(".jpg");

        return sb.toString();
    }

}

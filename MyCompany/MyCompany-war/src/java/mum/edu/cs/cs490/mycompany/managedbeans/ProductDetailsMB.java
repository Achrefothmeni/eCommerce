/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;
import mum.edu.cs.cs490.mycompany.entities.Customer;
import mum.edu.cs.cs490.mycompany.entities.Product;
import mum.edu.cs.cs490.mycompany.entities.ShoppingCart;
import mum.edu.cs.cs490.mycompany.facade.CustomerFacade;
import mum.edu.cs.cs490.mycompany.facade.ShoppingCartFacade;

/**
 *
 * @author Bilguun
 */
@Named
@SessionScoped
public class ProductDetailsMB implements Serializable{
    
    private static final String productDetailsMB = "productDetails";
    
    @EJB
    private ShoppingCartFacade scf;
    
    @EJB
    private CustomerFacade ccf;
    
    private Product product;
    private Integer selectedQuantity;
    
    @Inject
    private SessionMB sessionMB;

    /**
     * Creates a new instance of ProductDetailsMB
     */
    public ProductDetailsMB() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getSelectedQuantity() {
        return selectedQuantity;
    }

    public void setSelectedQuantity(Integer selectedQuantity) {
        this.selectedQuantity = selectedQuantity;
    }

    public List<Integer> getQuantity(){
        return product.getQuantity();
    }
    
    public String getImage() {
        Random r = new Random();
        
        int n = r.nextInt(4) + 1;
        
        StringBuilder sb = new StringBuilder("image");
        
        sb.append(n);
        sb.append(".jpg");

        return sb.toString();
    }
    
    public String actionAddBasket(){
        Customer customer = sessionMB.getCustomer();
        
        if(customer == null){
            customer = ccf.getCustomerByUsername("NickyMinaj");
        }
        
        ShoppingCart sc = new ShoppingCart();
        
        sc.setProduct(product);
        sc.setQuantity(selectedQuantity);
        sc.setCustomer(sessionMB.getCustomer());
        
        scf.save(sc);
        
        customer.addShoppingCart(sc);
        
        ccf.updateOrSave(customer);
        
        return "index";
    }
    
    @Override
    public String toString(){
        return productDetailsMB;
    }
}

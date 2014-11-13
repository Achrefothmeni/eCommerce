package mum.edu.cs.cs490.mycompany.managedbeans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import mum.edu.cs.cs490.mycompany.entities.Customer;
import mum.edu.cs.cs490.mycompany.entities.ShoppingCart;
import mum.edu.cs.cs490.mycompany.enums.AddressType;
import mum.edu.cs.cs490.mycompany.facade.ShoppingCartFacade;

/**
 *
 * @author Bilguun
 */
@Named
@RequestScoped
public class BasketMB {

    @EJB
    private ShoppingCartFacade scf;

    @Inject
    private SessionMB sessionMB;

    /**
     * Creates a new instance of Basket
     */
    public BasketMB() {
    }
    public boolean isEmptyShoppingCart(){
        if(getShoppingCarts() != null && !getShoppingCarts().isEmpty()){
            return false;
        }
        
        return true;
    }

    public List<ShoppingCart> getShoppingCarts() {
        Customer cus = sessionMB.getCustomer();

        if (cus != null) {
            return cus.getShoppingCarts();
        }
        return new ArrayList<>();
    }

    public void actionRemoveProduct(ShoppingCart shoppingCart) {
        if(this.getShoppingCarts().size() > 0 && this.getShoppingCarts().contains(shoppingCart))
            this.getShoppingCarts().remove(shoppingCart);
        
        scf.delete(shoppingCart);
    }

    public void actionUpdateQuantity(ShoppingCart shoppingCart) {
        scf.update(shoppingCart);
    }
    
    public String actionCheckOut(){
        sessionMB.setAddressType(AddressType.SHIPPING);
        return "address";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.cs.cs490.mycompany.managedbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import mum.edu.cs.cs490.mycompany.entities.Address;
import mum.edu.cs.cs490.mycompany.entities.Card;
import mum.edu.cs.cs490.mycompany.entities.Customer;
import mum.edu.cs.cs490.mycompany.entities.Order;
import mum.edu.cs.cs490.mycompany.entities.OrderItem;
import mum.edu.cs.cs490.mycompany.entities.ShoppingCart;
import mum.edu.cs.cs490.mycompany.enums.AddressType;
import mum.edu.cs.cs490.mycompany.facade.CustomerFacade;
import mum.edu.cs.cs490.mycompany.facade.OrderFacade;
import mum.edu.cs.cs490.mycompany.facade.OrderItemFacade;
import mum.edu.cs.cs490.mycompany.facade.ShoppingCartFacade;

/**
 *
 * @author Bilguun
 */
@Named(value = "confirmOrderMB")
@RequestScoped
public class ConfirmOrderMB {

    @Inject
    private SessionMB sessionMB;
    
    @EJB
    private OrderItemFacade oif;
    
    @EJB
    private OrderFacade of;
    
    @EJB
    private ShoppingCartFacade scf;
    
    @EJB
    private CustomerFacade cf;

    private Address address;
    private Card card;

    /**
     * Creates a new instance of ConfirmOrder
     */
    public ConfirmOrderMB() {
    }

    public Address getAddress() {
        if (address == null) {
            for (Address a : sessionMB.getCustomer().getAddresses()) {
                if (a.getAddressType().equals(AddressType.SHIPPING)) {
                    address = a;
                }
            }
        }

        if (address == null) {
            address = new Address();
        }

        return address;
    }

    public Card getCard() {
        if (card == null) {
            card = sessionMB.getPaymentCard();
        }

        return card;
    }
    
    public Customer getCustomer(){
        return sessionMB.getCustomer();
    }

    public String getCardNumber() {
        String value = sessionMB.getPaymentCard().getCardNumber();
        value = value.substring(value.length() - 4, value.length());

        return value;
    }
    
    public String actionConfirm(){
        Order order = new Order();
        
        order.setShipDate(new Date());
        
        List<OrderItem> orderItems = new ArrayList<>();
        
        int totalPrice = 0;
        
        of.saveOrUpdate(order);
        
        List<ShoppingCart> shoppingCarts = this.getCustomer().getShoppingCarts();
        
        for(ShoppingCart sc : shoppingCarts){
            OrderItem oi = new OrderItem();
            
            oi.setOrder(order);
            oi.setProduct(sc.getProduct());
            oi.setQuantity(sc.getQuantity());
            
            totalPrice += sc.getProduct().getPrice();
            
            orderItems.add(oi);
            
            oif.saveOrUpdate(oi);
        }
        
        
        order.setOrderItems(orderItems);
        order.setTotalPriceAmount(new Double(totalPrice));
        
        of.saveOrUpdate(order);
        
        for (int i = 0; i < shoppingCarts.size(); i++) {
            scf.delete(shoppingCarts.get(i));
        }
        
        this.getCustomer().getShoppingCarts().clear();
        
        cf.updateOrSave(this.getCustomer());
        
        return "thankyou";
    }
}

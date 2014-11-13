/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.cs.cs490.mycompany.managedbeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import mum.edu.cs.cs490.mycompany.entities.Card;
import mum.edu.cs.cs490.mycompany.entities.Customer;
import mum.edu.cs.cs490.mycompany.enums.AddressType;

/**
 *
 * @author Bilguun
 */
@Named
@SessionScoped
public class SessionMB implements Serializable {

    private Customer customer;
    private AddressType addressType;
    private Card paymentCard;

    /**
     * Creates a new instance of SessionMB
     */
    public SessionMB() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public Card getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(Card paymentCard) {
        this.paymentCard = paymentCard;
    }
}

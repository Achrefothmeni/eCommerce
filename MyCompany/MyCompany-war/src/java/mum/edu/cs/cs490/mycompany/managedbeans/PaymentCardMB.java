/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.cs.cs490.mycompany.managedbeans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import mum.edu.cs.cs490.mycompany.entities.Card;
import mum.edu.cs.cs490.mycompany.entities.Customer;
import mum.edu.cs.cs490.mycompany.enums.PaymentCardType;
import mum.edu.cs.cs490.mycompany.facade.CardFacade;
import mum.edu.cs.cs490.mycompany.facade.CustomerFacade;

/**
 *
 * @author Bilguun
 */
@Named
@RequestScoped
public class PaymentCardMB {

    @Inject
    private SessionMB sessionMB;
    
    @EJB
    private CardFacade cf;
    
    @EJB
    private CustomerFacade cusf;

    private PaymentCardType cardType;
    private Customer customer;
    private PaymentCardType selectedCardType;
    private Card card;

    /**
     * Creates a new instance of PaymentCardMB
     */
    public PaymentCardMB() {
    }

    public Customer getCustomer() {
        if (customer == null) {
            customer = sessionMB.getCustomer();
        }

        return customer;
    }

    public PaymentCardType[] getCardTypes() {
        return PaymentCardType.values();
    }

    public PaymentCardType getSelectedCardType() {
        return selectedCardType;
    }

    public void setSelectedCardType(PaymentCardType selectedCardType) {
        this.selectedCardType = selectedCardType;
    }

    public Card getCard() {
        if (card == null) {
            card = new Card();
        }
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
    
    public String actionSaveCard(){
        
        card.setCustomer(getCustomer());
        card.setCardType(selectedCardType);
        
        cf.save(card);
        
        getCustomer().addCards(card);
        
        cusf.updateOrSave(getCustomer());
        
        sessionMB.setPaymentCard(card);
        
        return "confirmOrder";
        
    }

}

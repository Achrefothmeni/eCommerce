/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.managedbeans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import mum.edu.cs.cs490.mycompany.entities.Customer;
import mum.edu.cs.cs490.mycompany.entities.Role;
import mum.edu.cs.cs490.mycompany.enums.AddressType;
import mum.edu.cs.cs490.mycompany.facade.RoleFacade;
import mum.edu.cs.cs490.mycompany.utils.Encrypter;

/**
 *
 * @author Bilguun
 */
@Named(value = "customerMB")
@RequestScoped
public class CustomerMB {
    
    private static final String CUSTOMER = "Customer";
    
    @EJB
    private RoleFacade rf;
    
    @Inject
    private SessionMB sessionMB;
    
    private Customer customer;
    private String passwordConfirm;

    /**
     * Creates a new instance of CustomerMB
     */
    public CustomerMB() {
        if(customer == null){
            customer = new Customer();
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    
    public String customerAdd(){
    
        if(customer.getPassword().equals(passwordConfirm)){
            System.err.println("Yes here");
            Role r = rf.getRoleByName(CUSTOMER);
            
            customer.setRole(r);
            
            String password = Encrypter.sha256(customer.getPassword());
            
            customer.setPassword(password);
            
            sessionMB.setCustomer(customer);
            sessionMB.setAddressType(AddressType.HOME);
            
            return "address";
        }else{
            return null;
        }
    }
}

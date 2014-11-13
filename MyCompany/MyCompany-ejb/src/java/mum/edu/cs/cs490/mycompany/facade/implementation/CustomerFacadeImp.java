/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.cs.cs490.mycompany.facade.implementation;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import mum.edu.cs.cs490.mycompany.ejb.CustomerService;
import mum.edu.cs.cs490.mycompany.entities.Customer;
import mum.edu.cs.cs490.mycompany.facade.CustomerFacade;

/**
 *
 * @author Bilguun
 */
@Stateless
public class CustomerFacadeImp implements CustomerFacade {

    @EJB
    private CustomerService cs;

    @Override
    public void save(Customer customer) {
        cs.save(customer);
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return cs.getCustomerByUsername(username);
    }

    @Override
    public void update(Customer customer) {
        cs.updateCustomer(customer);
    }

    @Override
    public void updateOrSave(Customer customer) {
        cs.updateOrInsert(customer);
    }
    
    

}

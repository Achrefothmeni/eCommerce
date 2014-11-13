/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.facade;

import javax.ejb.Local;
import mum.edu.cs.cs490.mycompany.entities.Customer;

/**
 *
 * @author Bilguun
 */
@Local
public interface CustomerFacade {
    
    public abstract void save(Customer customer);
    
    public abstract void update(Customer customer);
    
    public abstract void updateOrSave(Customer customer);
    
    public abstract Customer getCustomerByUsername(String username);
    
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.ejb;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import mum.edu.cs.cs490.mycompany.dao.GenericDAO;
import mum.edu.cs.cs490.mycompany.entities.Customer;

/**
 *
 * @author Bilguun
 */
@Stateless
public class CustomerService extends GenericDAO<Customer>{
    
    public CustomerService(){
        super(Customer.class);
    }
    
    public boolean updateCustomer(Customer customer){
        try {
            super.update(customer);
        } catch (Exception e) {
            e.printStackTrace();
            
            return false;
        }
        
        return true;
    }
    
    public void updateOrInsert(Customer customer){
        if(customer.getId() == null){
            super.save(customer);
        }else{
            super.update(customer);
        }
    }
    
    public Customer getCustomerByUsername(String username){
        Map<String, Object> parameters = new HashMap<>();
        
        parameters.put("username", username);
        
        return super.findOneResult(Customer.getCustomerByUsername, parameters);
    }
}

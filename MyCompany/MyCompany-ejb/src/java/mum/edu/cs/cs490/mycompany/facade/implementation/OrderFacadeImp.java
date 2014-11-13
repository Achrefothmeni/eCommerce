/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.facade.implementation;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import mum.edu.cs.cs490.mycompany.ejb.OrderService;
import mum.edu.cs.cs490.mycompany.entities.Order;
import mum.edu.cs.cs490.mycompany.facade.OrderFacade;

/**
 *
 * @author Bilguun
 */
@Stateless
public class OrderFacadeImp implements OrderFacade{
    
    @EJB
    private OrderService os;

    @Override
    public void saveOrUpdate(Order order) {
        if(order.getId() == null)
            os.save(order);
        else 
            os.update(order);
    }
    
    
}

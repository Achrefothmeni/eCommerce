/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.facade.implementation;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import mum.edu.cs.cs490.mycompany.ejb.OrderItemService;
import mum.edu.cs.cs490.mycompany.entities.OrderItem;
import mum.edu.cs.cs490.mycompany.facade.OrderItemFacade;

/**
 *
 * @author Bilguun
 */
@Stateless
public class OrderItemFacadeImp implements OrderItemFacade{
    
    @EJB
    private OrderItemService ois;

    @Override
    public void saveOrUpdate(OrderItem orderItem) {
        if(orderItem.getId() == null)
            ois.save(orderItem);
        else
            ois.update(orderItem);
    }
}

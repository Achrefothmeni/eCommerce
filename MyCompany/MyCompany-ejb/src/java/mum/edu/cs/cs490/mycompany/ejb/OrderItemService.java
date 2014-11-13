/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.ejb;

import javax.ejb.Stateless;
import mum.edu.cs.cs490.mycompany.dao.GenericDAO;
import mum.edu.cs.cs490.mycompany.entities.OrderItem;

/**
 *
 * @author Bilguun
 */
@Stateless
public class OrderItemService extends GenericDAO<OrderItem>{

    public OrderItemService() {
        super(OrderItem.class);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.facade;

import javax.ejb.Local;
import mum.edu.cs.cs490.mycompany.entities.Order;

/**
 *
 * @author Bilguun
 */
@Local
public interface OrderFacade {
    
    public abstract void saveOrUpdate(Order order);
}

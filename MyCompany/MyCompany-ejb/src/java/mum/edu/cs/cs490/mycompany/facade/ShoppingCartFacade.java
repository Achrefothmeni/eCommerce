/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.facade;

import java.util.List;
import javax.ejb.Local;
import mum.edu.cs.cs490.mycompany.entities.ShoppingCart;

/**
 *
 * @author Bilguun
 */
@Local
public interface ShoppingCartFacade {
    
    public abstract void save(ShoppingCart shoppingCart);
    
    public abstract List<ShoppingCart> getAll();
    
    public abstract void delete(ShoppingCart shoppingCart);
    
    public abstract void update(ShoppingCart shoppingCart);
    
}

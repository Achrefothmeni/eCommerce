/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.cs.cs490.mycompany.facade.implementation;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mum.edu.cs.cs490.mycompany.ejb.ShoppingCartService;
import mum.edu.cs.cs490.mycompany.entities.ShoppingCart;
import mum.edu.cs.cs490.mycompany.facade.ShoppingCartFacade;

/**
 *
 * @author Bilguun
 */
@Stateless
public class ShoppingCartFacadeImp implements ShoppingCartFacade {

    @EJB
    private ShoppingCartService scs;

    @Override
    public void save(ShoppingCart shoppingCart) {
        scs.save(shoppingCart);
    }

    @Override
    public List<ShoppingCart> getAll() {
        return scs.getAll();
    }

    @Override
    public void delete(ShoppingCart shoppingCart) {
        scs.delete(shoppingCart.getId(), ShoppingCart.class);
    }

    @Override
    public void update(ShoppingCart shoppingCart) {
        scs.update(shoppingCart);
    }
    
    
}

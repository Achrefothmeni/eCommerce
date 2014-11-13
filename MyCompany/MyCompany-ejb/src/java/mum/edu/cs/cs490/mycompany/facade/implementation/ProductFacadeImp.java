/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.facade.implementation;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mum.edu.cs.cs490.mycompany.ejb.ProductService;
import mum.edu.cs.cs490.mycompany.entities.Product;
import mum.edu.cs.cs490.mycompany.facade.ProductFacade;

/**
 *
 * @author Bilguun
 */
@Stateless
public class ProductFacadeImp implements ProductFacade{
    
    @EJB
    private ProductService ps;

    @Override
    public void save(Product product) {
        ps.save(product);
    }

    @Override
    public List<Product> getAll() {
        return ps.getAll();
    }
}

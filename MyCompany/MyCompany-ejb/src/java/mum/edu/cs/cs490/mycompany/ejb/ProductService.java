/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.ejb;

import javax.ejb.Stateless;
import mum.edu.cs.cs490.mycompany.dao.GenericDAO;
import mum.edu.cs.cs490.mycompany.entities.Product;

/**
 *
 * @author Bilguun
 */
@Stateless
public class ProductService extends GenericDAO<Product>{

    public ProductService() {
        super(Product.class);
    }
}

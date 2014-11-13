/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.facade.implementation;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mum.edu.cs.cs490.mycompany.ejb.BrandService;
import mum.edu.cs.cs490.mycompany.entities.Brand;
import mum.edu.cs.cs490.mycompany.facade.BrandFacade;

/**
 *
 * @author Bilguun
 */
@Stateless
public class BrandFacadeImp implements BrandFacade{
    
    @EJB
    private BrandService bs;

    @Override
    public Brand getBrandByName(String name) {
        return bs.getCategoryByName(name);
    }

    @Override
    public List<Brand> getAll() {
        return bs.getAll();
    }
    
}

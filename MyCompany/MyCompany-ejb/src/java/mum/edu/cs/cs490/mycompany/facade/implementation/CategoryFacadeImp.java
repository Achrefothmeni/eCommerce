/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.facade.implementation;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mum.edu.cs.cs490.mycompany.ejb.CategoryService;
import mum.edu.cs.cs490.mycompany.entities.Category;
import mum.edu.cs.cs490.mycompany.facade.CategoryFacade;

/**
 *
 * @author Bilguun
 */
@Stateless
public class CategoryFacadeImp implements CategoryFacade{
    
    @EJB
    private CategoryService cs;

    @Override
    public Category getCategoryByName(String name) {
        return cs.getCategoryByName(name);
    }

    @Override
    public List<Category> getAll() {
        return cs.getAll();
    }
}

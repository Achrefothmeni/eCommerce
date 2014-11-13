/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.ejb;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import mum.edu.cs.cs490.mycompany.dao.GenericDAO;
import mum.edu.cs.cs490.mycompany.entities.Brand;

/**
 *
 * @author Bilguun
 */
@Stateless
public class BrandService extends GenericDAO<Brand>{
    
    private static final String NAME = "name";

    public BrandService() {
        super(Brand.class);
    }
    
    public Brand getCategoryByName(String name){
        Map<String, Object> parameters = new HashMap<>();
        
        parameters.put(NAME, name);
        
        return super.findOneResult(Brand.getBrandByName, parameters);
    }
}

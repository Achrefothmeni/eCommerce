/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.facade;

import java.util.List;
import javax.ejb.Local;
import mum.edu.cs.cs490.mycompany.entities.Brand;

/**
 *
 * @author Bilguun
 */
@Local
public interface BrandFacade {
    
    public abstract Brand getBrandByName(String name);
    
    public abstract List<Brand> getAll();
}

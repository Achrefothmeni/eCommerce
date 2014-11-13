/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.facade;

import java.util.List;
import javax.ejb.Local;
import mum.edu.cs.cs490.mycompany.entities.Role;

/**
 *
 * @author Bilguun
 */
@Local
public interface RoleFacade {
    
    public abstract void save(Role dog);
    
    public abstract Role getRoleByName(String name);
 
    public abstract Role update(Role dog);
 
    public abstract void delete(Role dog);
 
    public abstract Role find(int entityID);
 
    public abstract List<Role> findAll();
    
}

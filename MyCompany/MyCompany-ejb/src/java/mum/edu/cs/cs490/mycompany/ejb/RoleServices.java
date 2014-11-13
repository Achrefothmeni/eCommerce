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
import mum.edu.cs.cs490.mycompany.entities.Role;

/**
 *
 * @author Bilguun
 */
@Stateless
public class RoleServices extends GenericDAO<Role>{
    
    public RoleServices() {
        super(Role.class);
    }
    
    public Role getRoleByName(String name){
        Map<String, Object> parameters = new HashMap<>();
        
        parameters.put("name", name);
        
        return super.findOneResult(Role.findRoleByName, parameters);
    }
}

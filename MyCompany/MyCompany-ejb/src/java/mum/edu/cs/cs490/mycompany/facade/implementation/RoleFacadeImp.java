/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.facade.implementation;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mum.edu.cs.cs490.mycompany.ejb.RoleServices;
import mum.edu.cs.cs490.mycompany.entities.Role;
import mum.edu.cs.cs490.mycompany.facade.RoleFacade;

/**
 *
 * @author Bilguun
 */
@Stateless
public class RoleFacadeImp implements RoleFacade{
    
    @EJB
    private RoleServices rs;

    @Override
    public void save(Role role) {
        rs.save(role);
    }

    @Override
    public Role update(Role role) {
        return null;
    }

    @Override
    public void delete(Role role) {
    }

    @Override
    public Role find(int entityID) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Role getRoleByName(String name) {
        return rs.getRoleByName(name);
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.managedbeans;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import mum.edu.cs.cs490.mycompany.entities.Role;
import mum.edu.cs.cs490.mycompany.facade.RoleFacade;


/**
 *
 * @author Bilguun
 */
@Named
@RequestScoped
public class RoleMB {
    
    @EJB
    private RoleFacade rs;

    /**
     * Creates a new instance of RoleMB
     */
    public RoleMB() {
    }
    
    
    public void actionCreateRole(ActionEvent actionEvent){
        Role role = new Role();
        
        role.setName("Customer");
        
        rs.save(role);
    }
    
}

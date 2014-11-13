/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.ejb;

import javax.ejb.Stateless;
import mum.edu.cs.cs490.mycompany.dao.GenericDAO;
import mum.edu.cs.cs490.mycompany.entities.Address;

/**
 *
 * @author Bilguun
 */
@Stateless
public class AddressService extends GenericDAO<Address>{

    public AddressService() {
        super(Address.class);
    }
    
    
}

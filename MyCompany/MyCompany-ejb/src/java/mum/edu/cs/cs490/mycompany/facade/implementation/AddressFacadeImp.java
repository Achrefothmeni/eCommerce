/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.facade.implementation;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import mum.edu.cs.cs490.mycompany.ejb.AddressService;
import mum.edu.cs.cs490.mycompany.entities.Address;
import mum.edu.cs.cs490.mycompany.facade.AddressFacade;

/**
 *
 * @author Bilguun
 */
@Stateless
public class AddressFacadeImp implements AddressFacade{
    
    @EJB
    private AddressService as;

    @Override
    public void save(Address address) {
        as.save(address);
    }

    @Override
    public void updateOrSave(Address address) {
        if(address.getId() == null){
            as.save(address);
        }else{
            as.update(address);
        }
    }
    
}

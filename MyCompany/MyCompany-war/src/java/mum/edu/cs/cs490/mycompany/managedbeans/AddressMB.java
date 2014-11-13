/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.cs.cs490.mycompany.managedbeans;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mum.edu.cs.cs490.mycompany.entities.Address;
import mum.edu.cs.cs490.mycompany.entities.Customer;
import mum.edu.cs.cs490.mycompany.enums.AddressType;
import mum.edu.cs.cs490.mycompany.facade.AddressFacade;
import mum.edu.cs.cs490.mycompany.facade.CustomerFacade;

/**
 *
 * @author Bilguun
 */
@Named
@RequestScoped
public class AddressMB {

    private static final String Address = "address";

    @EJB
    private CustomerFacade cf;

    @EJB
    private AddressFacade af;

    @Inject
    private SessionMB sessionMB;

    private Address address;

    public AddressMB() {
    }

    public Address getAddress() {
        if (address == null) {
            for (Address a : sessionMB.getCustomer().getAddresses()) {
                if (a.getAddressType().equals(AddressType.SHIPPING)) {
                    address = a;
                }
            }
        }

        if (address == null) {
            address = new Address();
        }
        
        return address;
    }

    public String getAddressType() {
        return sessionMB.getAddressType().toString().toLowerCase();
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String actionSaveAddress() {
        String page = "checkout";

        address.setAddressType(sessionMB.getAddressType());

        Customer customer = sessionMB.getCustomer();

        if (customer.getId() == null) {
            page = "index";
        }
        address.setCustomer(customer);

        cf.updateOrSave(customer);
        af.updateOrSave(address);

        return page;
    }

    @Override
    public String toString() {
        return Address;
    }

}

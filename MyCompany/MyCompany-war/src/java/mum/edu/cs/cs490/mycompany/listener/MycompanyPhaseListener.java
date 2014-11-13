/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.edu.cs.cs490.mycompany.listener;

import javax.ejb.EJB;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;
import mum.edu.cs.cs490.mycompany.facade.CustomerFacade;
import mum.edu.cs.cs490.mycompany.managedbeans.SessionMB;

/**
 *
 * @author Bilguun
 */
public class MycompanyPhaseListener implements PhaseListener {

    @Inject
    private SessionMB sessionMB;

    @EJB
    private CustomerFacade ccf;

    @Override
    public void afterPhase(PhaseEvent event) {
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        if (sessionMB.getCustomer() == null) {
            sessionMB.setCustomer(ccf.getCustomerByUsername("NickyMinaj"));
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}

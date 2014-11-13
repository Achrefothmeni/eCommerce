/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.facade.implementation;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import mum.edu.cs.cs490.mycompany.ejb.CardServices;
import mum.edu.cs.cs490.mycompany.entities.Card;
import mum.edu.cs.cs490.mycompany.facade.CardFacade;

/**
 *
 * @author Bilguun
 */
@Stateless
public class CardFacadeImp implements CardFacade{
    
    @EJB
    private CardServices cs;

    @Override
    public void save(Card card) {
        cs.save(card);
    }
}

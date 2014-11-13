/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.ejb;

import javax.ejb.Stateless;
import mum.edu.cs.cs490.mycompany.dao.GenericDAO;
import mum.edu.cs.cs490.mycompany.entities.Card;

/**
 *
 * @author Bilguun
 */
@Stateless
public class CardServices extends GenericDAO<Card>{

    public CardServices() {
        super(Card.class);
    }
}

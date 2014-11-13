/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.enums;

/**
 *
 * @author Bilguun
 */
public enum PaymentCardType {
    
    VISA(0), MASTER(1);
    
    private int value;

    PaymentCardType(int val) {
        this.value = val;
    }
    
    public int getValue(){
        return value;
    }
    
}

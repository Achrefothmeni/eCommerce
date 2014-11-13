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
public enum AddressType {

    HOME(0), WORK(1), SHIPPING(2);

    private int value;

    private AddressType(int value) {
        this.value = value;
    }
    
    public int getValue(){
        return value;
    }

}

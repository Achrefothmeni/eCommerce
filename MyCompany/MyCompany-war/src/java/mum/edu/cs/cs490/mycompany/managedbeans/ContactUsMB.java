/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.managedbeans;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import mum.edu.cs.cs490.mycompany.utils.MailUtil;

/**
 *
 * @author Bilguun
 */
@Named(value = "contactUsMB")
@RequestScoped
public class ContactUsMB {
    
    private static final String ContactUSMB = "contact";
    
    private String customerName;
    private String customerEmail;
    private String content;
    
    private Boolean sent;

    /**
     * Creates a new instance of ContactUsMB
     */
    public ContactUsMB() {
        if(sent == null){
            sent = false;
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean isSent() {
        return sent;
    }

    public void setSent(Boolean sent) {
        this.sent = sent;
    }
    
    public String actionSendEmail(){
        sent = MailUtil.send(content, null, null, "Customer feedback");
        
        return this.toString();
    }
    
    public String actionIndex(){
        return "index";
    }
    
    @Override
    public String toString(){
        return ContactUSMB;
    }
}

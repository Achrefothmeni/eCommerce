/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mum.edu.cs.cs490.mycompany.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bOyunchimeg
 */
@Entity
@Table(name = "ORDERS")
public class Order implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipDate;
    
    private String shipStatus;
    private Double totalPriceAmount;
    private Double totalShipCost;
    private Double totalTaxes;
    private Double totalAmount;
    
    @Lob
    private String comments;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderItem> orderItems;
    
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
    
    @ManyToMany(mappedBy = "orders", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "order")
    private Payment payment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public String getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(String shipStatus) {
        this.shipStatus = shipStatus;
    }

    public Double getTotalPriceAmount() {
        return totalPriceAmount;
    }

    public void setTotalPriceAmount(Double totalPriceAmount) {
        this.totalPriceAmount = totalPriceAmount;
    }

    public Double getTotalShipCost() {
        return totalShipCost;
    }

    public void setTotalShipCost(Double totalShipCost) {
        this.totalShipCost = totalShipCost;
    }

    public Double getTotalTaxes() {
        return totalTaxes;
    }

    public void setTotalTaxes(Double totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + id.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", orderDate=" + orderDate + ", shipDate=" + shipDate + ", shipStatus=" + shipStatus + ", totalPriceAmount=" + totalPriceAmount + ", totalShipCost=" + totalShipCost + ", totalTaxes=" + totalTaxes + ", totalAmount=" + totalAmount + ", comments=" + comments + ", orderItems=" + orderItems + ", customer=" + customer + ", addresses=" + addresses + ", payment=" + payment + '}';
    }
}

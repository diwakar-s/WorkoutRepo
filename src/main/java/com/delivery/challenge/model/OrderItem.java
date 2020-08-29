package com.delivery.challenge.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name="order_items")
public class OrderItem {

	public OrderItem() {
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="order_item_id")
    private Long orderItemId;
    
	
	private String productId;
    
    @Column(name="order_item_quantity")
    private Integer quantity;
    
//    @ManyToOne(fetch = FetchType.LAZY,optional = false)
//    @JoinColumn(name="orderId",nullable = false)
//    private Order order;
//    
    
    
    

    @Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", productId=" + productId + ", quantity=" + quantity
				;
	}

	public Long getOrderItemId() {
        return orderItemId;
    }

    public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	
	public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

   
    public Integer getQuantity() {
        return quantity;
    }

    
	public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
package com.niit.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/*In the Java Persistence API (JPA) a persistent class is referred to as an entity.
An entity is a plain old Java object (POJO) class that is mapped to the database and configured for
usage through JPA using annotations and/or XML.*/
@Entity
public class Customer 
{
	
	//The @Idannotation is inherited from javax.persistence.Id， indicating the member field below is the primary key of current entity.
	//The @GeneratedValue annotation is to configure the way of increment of the specified column(field)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String firstname;
private String lastname;
private String phonenumber;
@OneToOne(cascade=CascadeType.ALL)
private User user;//FK user_email


@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="billing_id")
private BillingAddress billingaddress;//billingaddress_id


public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getPhonenumber() {
	return phonenumber;
}
public void setPhonenumber(String phonenumber) {
	this.phonenumber = phonenumber;
}
public BillingAddress getBillingaddress() {
	return billingaddress;
}
public void setBillingaddress(BillingAddress billingaddress) {
	this.billingaddress = billingaddress;
}
public ShippingAddress getShippingaddress() {
	return shippingaddress;
}
public void setShippingaddress(ShippingAddress shippingaddress) {
	this.shippingaddress = shippingaddress;
}
@OneToOne(cascade=CascadeType.ALL)
private ShippingAddress shippingaddress;//shippingaddress_id

}

package com.luxoft.javabdd.bank;

import java.util.*;

public abstract class CreditOffer {

	protected String id;
	protected Set<Customer> customersList = new HashSet<>();
	protected String creditOfferType;

	protected double amount;

	public CreditOffer(String id, String creditOfferType) {
		this.id = id;
		this.creditOfferType = creditOfferType;
	}

	public CreditOffer(String id, String creditOfferType, double amount) {
		this.id = id;
		this.creditOfferType = creditOfferType;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public Set<Customer> getCustomersList() {
		return Collections.unmodifiableSet(customersList);
	}

	public abstract boolean addCustomer(Customer customer);

	public abstract boolean removeCustomer(Customer customer);

	public abstract int calculateBonusPoints(Customer customer);

}

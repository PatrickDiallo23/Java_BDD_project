package com.luxoft.javabdd.bank;

public class BusinessCreditOffer extends CreditOffer {

    public BusinessCreditOffer(String id) {
        super(id, "Business");
    }

    public BusinessCreditOffer(String id, double amount) {
        super(id, "Business", amount);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if (customer.isVip()) {
            return customersList.add(customer);
        }
        return false;
    }

    @Override
    public boolean removeCustomer(Customer customer) {
        return false;
    }

    @Override
    public int calculateBonusPoints(Customer customer) {
        int bonusPoints;
        if (customer.isVip()) {
            bonusPoints = (int) (amount * 0.15); // 15% bonus for VIP customers
        } else {
            bonusPoints = (int) (amount * 0.07); // 7% bonus for usual customers
        }
        return bonusPoints;
    }
}

package com.luxoft.javabdd.bank;

public class PremiumCreditOffer extends CreditOffer{

    public PremiumCreditOffer(String id){
        super(id, "Premium");
    }

    public PremiumCreditOffer(String id, double amount){
        super(id, "Premium", amount);
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
        customersList.remove(customer);
        return false;
    }

    @Override
    public int calculateBonusPoints(Customer customer) {
        int bonusPoints;
        if (customer.isVip()) {
            bonusPoints = (int) (amount * 0.2); // 20% bonus for VIP customers
        } else {
            bonusPoints = (int) (amount * 0.1); // 10% bonus for usual customers
        }
        return bonusPoints;
    }
}

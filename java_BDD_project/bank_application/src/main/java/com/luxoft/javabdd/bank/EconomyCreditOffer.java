package com.luxoft.javabdd.bank;

public class EconomyCreditOffer extends CreditOffer {

    public EconomyCreditOffer(String id) {
        super(id, "Economy");
    }

    public EconomyCreditOffer(String id, double amount) {
        super(id, "Economy", amount);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return customersList.add(customer);
    }

    @Override
    public boolean removeCustomer(Customer customer) {
        if (!customer.isVip()) {
            return customersList.remove(customer);
        }
        return false;
    }

        @Override
        public int calculateBonusPoints(Customer customer) {
            int bonusPoints;
            if (customer.isVip()) {
                bonusPoints = (int) (amount * 0.1); // 10% bonus for VIP customers
            } else {
                bonusPoints = (int) (amount * 0.05); // 5% bonus for usual customers
            }
            return bonusPoints;
        }

}

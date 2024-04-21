package tests;

import com.luxoft.javabdd.bank.*;
import org.jbehave.core.annotations.*;

import static org.junit.jupiter.api.Assertions.*;

public class BankOperationsStory {

    private CreditOffer creditOffer;
    private EconomyCreditOffer economyCreditOffer;
    private BusinessCreditOffer businessCreditOffer;
    private PremiumCreditOffer premiumCreditOffer;
    private Customer customer;
    private boolean result;
    private int bonusPoints;

    //task 6
    @Given("an economy credit offer with ID $id")
    public void anEconomyCreditOfferWithId(String id) {
        economyCreditOffer = new EconomyCreditOffer(id);
    }

    @Given("a usual customer named $name")
    public void aUsualCustomerNamed(String name) {
        customer = new Customer(name, false);
    }

    @When("the usual customer is added to the economy offer")
    public void theUsualCustomerIsAddedToTheEconomyOffer() {
        result = economyCreditOffer.addCustomer(customer);
    }

    @Then("the usual customer should be added successfully")
    public void theUsualCustomerShouldBeAddedSuccessfully() {
        assertTrue(result);
    }

    @Given("a usual customer with name $name added to the economy offer")
    public void aUsualCustomerWithNameAddedToTheEconomyOffer(String name) {
        customer = new Customer(name, false);
        economyCreditOffer.addCustomer(customer);
    }

    @When("the usual customer is removed from the economy offer")
    public void theUsualCustomerIsRemovedFromTheEconomyOffer() {
        result = economyCreditOffer.removeCustomer(customer);
    }

    @Then("the usual customer should be removed successfully")
    public void theUsualCustomerShouldBeRemovedSuccessfully() {
        assertTrue(result, "Usual customer should be removed successfully");
        assertFalse(economyCreditOffer.getCustomersList().contains(customer), "Usual customer should not be in Economy offer after removal");
    }

    @Given("a VIP customer named $name")
    public void aVipCustomerNamed(String name) {
        customer = new Customer(name, true);
    }

    @When("the VIP customer is added to the economy offer")
    public void theVIPCustomerIsAddedToTheEconomyOffer() {
        result = economyCreditOffer.addCustomer(customer);
    }

    @Then("the VIP customer should be added successfully")
    public void theVIPCustomerShouldBeAddedSuccessfully() {
        assertTrue(result, "VIP customer should be added successfully");
    }

    @Given("a VIP customer with name $name added to the economy offer")
    public void aVIPCustomerWithNameAddedToTheEconomyOffer(String name) {
        customer = new Customer(name, true);
        economyCreditOffer.addCustomer(customer);
    }

    @When("the VIP customer is removed from the economy offer")
    public void theVIPCustomerIsRemovedFromTheEconomyOffer() {
        result = economyCreditOffer.removeCustomer(customer);
    }

    @Then("the VIP customer should not be removed")
    public void theVIPCustomerShouldNotBeRemoved() {
        assertFalse(result, "VIP customer should not be removed");
    }

    @Given("a business credit offer with ID $id")
    public void aBusinessCreditOfferWithId(String id) {
        businessCreditOffer = new BusinessCreditOffer(id);
    }

    @When("the usual customer is added to the business offer")
    public void theUsualCustomerIsAddedToTheBusinessOffer() {
        result = businessCreditOffer.addCustomer(customer);
    }

    @When("the VIP customer is added to the business offer")
    public void theVIPCustomerIsAddedToTheBusinessOffer() {
        result = businessCreditOffer.addCustomer(customer);
    }

    @Then("the usual customer should not be added")
    public void theUsualCustomerShouldNotBeAdded() {
        assertFalse(result, "Usual customer should not be added");
    }
    @When("the usual customer is removed from any offer")
    public void theUsualCustomerIsRemovedFromAnyOffer() {
        if (businessCreditOffer != null) {
            result = businessCreditOffer.removeCustomer(customer);
        } else if (economyCreditOffer != null) {
            result = economyCreditOffer.removeCustomer(customer);
        }
    }
    @Then("the usual customer should not be removed")
    public void theUsualCustomerShouldNotBeRemoved() {
        assertFalse(result);
    }
    @When("the VIP customer is removed from any offer")
    public void theVIPCustomerIsRemovedFromAnyOffer() {
        if (businessCreditOffer != null) {
            result = businessCreditOffer.removeCustomer(customer);
        } else if (economyCreditOffer != null) {
            result = economyCreditOffer.removeCustomer(customer);
        }
    }

    //task 7

    @Given("a premium credit offer with ID $id")
    public void aPremiumCreditOfferWithId(String id) {
        premiumCreditOffer = new PremiumCreditOffer(id);
    }

    @When("the usual customer is added to the premium offer")
    public void theUsualCustomerIsAddedToThePremiumOffer() {
        result = premiumCreditOffer.addCustomer(customer);
    }

    @When("the VIP customer is added to the premium offer")
    public void aVIPCustomerAddedToThePremiumOffer() {
        result = premiumCreditOffer.addCustomer(customer);
    }

    @Given("a $type named $name added to the premium offer")
    public void aCustomerNamedAddedToThePremiumOffer(String type, String name) {
        if (type.equals("VIP")) {
            customer = new Customer(name, true);
        } else {
            customer = new Customer(name, false);
        }
        premiumCreditOffer.addCustomer(customer);
    }

    @When("the customer is removed from the premium offer")
    public void theCustomerIsRemovedFromThePremiumOffer() {
        result = premiumCreditOffer.removeCustomer(customer);
    }

    @Then("the customer should be removed successfully")
    public void theCustomerShouldBeRemovedSuccessfully() {
        assertFalse(result, "Customer should be removed successfully");
        assertFalse(premiumCreditOffer.getCustomersList().contains(customer), "Customer should not be in Premium offer after removal");
    }

    //task 8

    @Given("a $offerType credit offer type with ID $id")
    public void aCreditOfferWithId(String offerType, String id) {
        System.out.println("credit offer type = " + offerType);
        switch (offerType) {
            case "economy":
                economyCreditOffer = new EconomyCreditOffer(id);
                break;
            case "business":
                businessCreditOffer = new BusinessCreditOffer(id);
                break;
            case "premium":
                premiumCreditOffer = new PremiumCreditOffer(id);
                break;
            default:
                throw new IllegalArgumentException("Invalid credit offer type: " + offerType);
        }
    }

    @Given("a customer named $name added to the credit offer")
    public void aCustomerNamedAddedToTheCreditOffer(String name) {
        customer = new Customer(name, false);
        if (economyCreditOffer != null) {
            economyCreditOffer.addCustomer(customer);
        } else if (businessCreditOffer != null) {
            businessCreditOffer.addCustomer(customer);
        } else if (premiumCreditOffer != null) {
            premiumCreditOffer.addCustomer(customer);
        }
    }

//    @Given("a $type customer named $name added to the credit offer")
//    public void aCustomerNamedAddedToTheCreditOffer(String type, String name) {
//        System.out.println("customerType for credit offer = " + type);
//        switch (type) {
//            case "economy":
//                creditOffer = economyCreditOffer;
//                break;
//            case "business":
//                creditOffer = businessCreditOffer;
//                break;
//            case "premium":
//                creditOffer = premiumCreditOffer;
//                break;
//        }
//        if (creditOffer != null) {
//            if (type.equals("VIP")) {
//                customer = new Customer(name, true);
//            } else {
//                customer = new Customer(name, false);
//            }
//            creditOffer.addCustomer(customer);
//        }
//    }

    @When("the same customer is added to the credit offer again")
    public void theSameCustomerIsAddedToTheCreditOfferAgain() {
        if (economyCreditOffer != null) {
            result = economyCreditOffer.addCustomer(customer);
        } else if (businessCreditOffer != null) {
            result = businessCreditOffer.addCustomer(customer);
        } else if (premiumCreditOffer != null) {
            result = premiumCreditOffer.addCustomer(customer);
        }
    }
    @Then("the customer should not be added again")
    public void theCustomerShouldNotBeAddedAgain() {
        assertFalse(result, "Customer should not be added again to the credit offer");
    }

    //task 9

    @Given("An economy credit offer with ID $id and credit amount $creditAmount")
    public void anEconomyCreditOfferWithIdAndCreditAmount(String id, double creditAmount) {
        economyCreditOffer = new EconomyCreditOffer(id, creditAmount);
    }

    @Given("A business credit offer with ID $id and credit amount $creditAmount")
    public void aBusinessCreditOfferWithIdAndCreditAmount(String id, double creditAmount) {
        businessCreditOffer = new BusinessCreditOffer(id, creditAmount);
    }

    @Given("A premium credit offer with ID $id and credit amount $creditAmount")
    public void aPremiumCreditOfferWithIdAndCreditAmount(String id, double creditAmount) {
        premiumCreditOffer = new PremiumCreditOffer(id, creditAmount);
    }

    @Given("A $customerType named $name")
    public void aCustomerNamed(String customerType, String name) {
        boolean isVip = customerType.equalsIgnoreCase("VIP");
        System.out.println("customerType = " + customerType);
        System.out.println("isVip = " + isVip);
        customer = new Customer(name, isVip);
    }

    @When("The bonus points are calculated for the customer for economy offer")
    public void theBonusPointsAreCalculatedForTheCustomer() {
        bonusPoints = economyCreditOffer.calculateBonusPoints(customer);
    }

    @When("The bonus points are calculated for the customer for business offer")
    public void theBonusPointsAreCalculatedForTheCustomerForBusinessOffer() {
        bonusPoints = businessCreditOffer.calculateBonusPoints(customer);
    }

    @When("The bonus points are calculated for the customer for premium offer")
    public void theBonusPointsAreCalculatedForTheCustomerForPremiumOffer() {
        bonusPoints = premiumCreditOffer.calculateBonusPoints(customer);
    }

    @Then("The bonus points for business offer should be $expectedBonusPoints")
    public void theBonusPointsForBusinessOfferShouldBe(int expectedBonusPoints) {
        assertEquals(expectedBonusPoints, bonusPoints, "Bonus points calculation for business offer is incorrect");
    }

    @Then("The bonus points for premium offer should be $expectedBonusPoints")
    public void theBonusPointsForPremiumOfferShouldBe(int expectedBonusPoints) {
        assertEquals(expectedBonusPoints, bonusPoints, "Bonus points calculation for premium offer is incorrect");
    }

    @Then("The bonus points should be $expectedBonusPoints")
    public void theBonusPointsShouldBe(int expectedBonusPoints) {
        assertEquals(expectedBonusPoints, bonusPoints, "Bonus points calculation is incorrect");
    }
}

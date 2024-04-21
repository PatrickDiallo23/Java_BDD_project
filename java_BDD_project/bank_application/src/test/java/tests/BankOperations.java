package tests;

import com.luxoft.javabdd.bank.*;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

public class BankOperations {

    private CreditOffer creditOffer;
    private EconomyCreditOffer economyCreditOffer;
    private BusinessCreditOffer businessCreditOffer;
    private PremiumCreditOffer premiumCreditOffer;
    private Customer customer;
    private boolean result;

    private int bonusPoints;

    //task2
    @Given("an economy credit offer with ID {string}")
    public void anEconomyCreditOfferWithId(String id) {
        economyCreditOffer = new EconomyCreditOffer(id);
    }

    @Given("a business credit offer with ID {string}")
    public void aBusinessCreditOfferWithId(String id) {
        businessCreditOffer = new BusinessCreditOffer(id);
    }

    @Given("a usual customer named {string}")
    public void aUsualCustomerNamed(String name) {
        customer = new Customer(name, false);
    }

    @Given("a VIP customer named {string}")
    public void aVipCustomerNamed(String name) {
        customer = new Customer(name, true);
    }

    @When("the usual customer is added to the economy offer")
    public void theUsualCustomerIsAddedToTheEconomyOffer() {
        result = economyCreditOffer.addCustomer(customer);
    }

    @Given("a usual customer named {string} added to the economy offer")
    public void aUsualCustomerNamedAddedToTheEconomyOffer(String name) {
        customer = new Customer(name, false);
        economyCreditOffer.addCustomer(customer);
    }

    @Given("a VIP customer named {string} added to the economy offer")
    public void aVIPCustomerNamedAddedToTheEconomyOffer(String name) {
        customer = new Customer(name, true);
        economyCreditOffer.addCustomer(customer);
    }

    @When("the usual customer is removed from the economy offer")
    public void theUsualCustomerIsRemovedFromTheEconomyOffer() {
        result = economyCreditOffer.removeCustomer(customer);
    }

    @When("the VIP customer is removed from the economy offer")
    public void theVIPCustomerIsRemovedFromTheEconomyOffer() {
        result = economyCreditOffer.removeCustomer(customer);
    }

    @Then("the usual customer should be removed successfully")
    public void theUsualCustomerShouldBeRemovedSuccessfully() {
        assertTrue(result);
        assertFalse(economyCreditOffer.getCustomersList().contains(customer));
    }

    @Then("the usual customer should not be removed")
    public void theUsualCustomerShouldNotBeRemoved() {
        assertFalse(result);
    }

    @When("the VIP customer is added to the economy offer")
    public void theVIPCustomerIsAddedToTheEconomyOffer() {
        result = economyCreditOffer.addCustomer(customer);
    }

    @When("the VIP customer is added to the business offer")
    public void theVIPCustomerIsAddedToTheBusinessOffer() {
        result = businessCreditOffer.addCustomer(customer);
    }

    @When("the usual customer is added to the business offer")
    public void theUsualCustomerIsAddedToTheBusinessOffer() {
        result = businessCreditOffer.addCustomer(customer);
    }

    @When("the usual customer is removed from any offer")
    public void theUsualCustomerIsRemovedFromAnyOffer() {
        if(businessCreditOffer != null) {
            result = businessCreditOffer.removeCustomer(customer);
        }
        else if(economyCreditOffer != null) {
            result = economyCreditOffer.removeCustomer(customer);
        }
    }

    @When("the VIP customer is removed from any offer")
    public void theVIPCustomerIsRemovedFromAnyOffer() {
        if(businessCreditOffer != null) {
            result = businessCreditOffer.removeCustomer(customer);
        }
        else if(economyCreditOffer != null) {
            result = economyCreditOffer.removeCustomer(customer);
        }
    }

    @Then("the usual customer should be added successfully")
    public void theUsualCustomerShouldBeAddedSuccessfully() {
        assertTrue(result);
    }


    @Then("the VIP customer should not be removed")
    public void theVIPCustomerShouldNotBeRemoved() {
        assertFalse(result);
    }

    //task3
    @Given("a premium credit offer with ID {string}")
    public void aPremiumCreditOfferWithId(String id) {
        premiumCreditOffer = new PremiumCreditOffer(id);
    }

    @Given("a customer named {string} added to the premium offer")
    public void aCustomerNamedAddedToThePremiumOffer(String name) {
        customer = new Customer(name, false);
        premiumCreditOffer.addCustomer(customer);
    }

    @Given("a VIP customer named {string} added to the premium offer")
    public void aVIPCustomerNamedAddedToThePremiumOffer(String name) {
        customer = new Customer(name, true);
        premiumCreditOffer.addCustomer(customer);
    }

    @Given("the VIP customer is added to the premium offer")
    public void aVIPCustomerAddedToThePremiumOffer() {
        result = premiumCreditOffer.addCustomer(customer);
    }
    @When("the usual customer is added to the premium offer")
    public void theUsualCustomerIsAddedToThePremiumOffer() {
        result = premiumCreditOffer.addCustomer(customer);
    }

    @When("the customer is removed from the premium offer")
    public void theCustomerIsRemovedFromThePremiumOffer() {
        result = premiumCreditOffer.removeCustomer(customer);
    }

    @Then("the usual customer should not be added")
    public void theUsualCustomerShouldNotBeAdded() {
        assertFalse(result);
    }

    @Then("the VIP customer should be added successfully")
    public void theVIPCustomerShouldBeAddedSuccessfully() {
        assertTrue(result);
    }

    @Then("the customer should be removed successfully")
    public void theCustomerShouldBeRemovedSuccessfully() {
        assertFalse(result);
        assertFalse(premiumCreditOffer.getCustomersList().contains(customer));
    }

    //task4

    @Given("a {string} credit offer with ID {string}")
    public void aCreditOfferWithId(String offerType, String id) {
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

    @Given("a customer named {string} added to the credit offer")
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
        assertFalse(result);
    }

    //task 5

    @Given("an economy credit offer with ID {string} and credit amount {double}")
    public void anEconomyCreditOfferWithIdAndCreditAmount(String id, double creditAmount) {
        economyCreditOffer = new EconomyCreditOffer(id, creditAmount);
    }

    @Given("A {string} named {string}")
    public void aCustomerNamed(String customerType, String name) {
        boolean isVip = customerType.equalsIgnoreCase("VIP");
        customer = new Customer(name, isVip);
    }

    @When("the bonus points are calculated for the customer")
    public void theBonusPointsAreCalculatedForTheCustomer() {
        bonusPoints = economyCreditOffer.calculateBonusPoints(customer);
    }

    @Then("the bonus points should be {int}")
    public void theBonusPointsShouldBe(int expectedBonusPoints) {
        assertEquals(expectedBonusPoints, bonusPoints);
    }

    @Given("a business credit offer with ID {string} and credit amount {double}")
    public void aBusinessCreditOfferWithIdAndCreditAmount(String id, double creditAmount) {
        businessCreditOffer = new BusinessCreditOffer(id, creditAmount);
    }

    @Given("a premium credit offer with ID {string} and credit amount {double}")
    public void aPremiumCreditOfferWithIdAndCreditAmount(String id, double creditAmount) {
        premiumCreditOffer = new PremiumCreditOffer(id, creditAmount);
    }

    @When("the bonus points are calculated for the customer for business offer")
    public void theBonusPointsAreCalculatedForTheCustomerForBusinessOffer() {
        bonusPoints = businessCreditOffer.calculateBonusPoints(customer);
    }

    @When("the bonus points are calculated for the customer for premium offer")
    public void theBonusPointsAreCalculatedForTheCustomerForPremiumOffer() {
        bonusPoints = premiumCreditOffer.calculateBonusPoints(customer);
    }

    @Then("the bonus points for business offer should be {int}")
    public void theBonusPointsForBusinessOfferShouldBe(int expectedBonusPoints) {
        assertEquals(expectedBonusPoints, bonusPoints);
    }

    @Then("the bonus points for premium offer should be {int}")
    public void theBonusPointsForPremiumOfferShouldBe(int expectedBonusPoints) {
        assertEquals(expectedBonusPoints, bonusPoints);
    }

}

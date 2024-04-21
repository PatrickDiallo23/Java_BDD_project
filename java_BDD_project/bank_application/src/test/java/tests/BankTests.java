package tests;

import com.luxoft.javabdd.bank.BusinessCreditOffer;
import com.luxoft.javabdd.bank.CreditOffer;
import com.luxoft.javabdd.bank.Customer;
import com.luxoft.javabdd.bank.EconomyCreditOffer;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Bank tests")
class BankTest {

    @Nested
    @DisplayName("EconomyCreditOfferTest")
    class EconomyCreditOfferTest {

        @Nested
        @DisplayName("UsualCustomer")
        class UsualCustomer {

            @Test
            @DisplayName("Should add usual customer to economy offer")
            void shouldAddUsualCustomerToEconomyOffer() {
                // Arrange
                EconomyCreditOffer offer = new EconomyCreditOffer("1");
                Customer usualCustomer = new Customer("John", false);

                // Act
                boolean added = offer.addCustomer(usualCustomer);

                // Assert
                assertAll("Adding Usual Customer to Economy Offer",
                        () -> assertTrue(added),
                        () -> assertTrue(offer.getCustomersList().contains(usualCustomer))
                );
            }

            @Test
            @DisplayName("Should remove usual customer from economy offer")
            void shouldRemoveUsualCustomerFromEconomyOffer() {
                // Arrange
                EconomyCreditOffer offer = new EconomyCreditOffer("2");
                Customer usualCustomer = new Customer("John", false);
                offer.addCustomer(usualCustomer);

                // Act
                boolean removed = offer.removeCustomer(usualCustomer);

                // Assert
                assertTrue(removed, "Usual customer should be removed from Economy offer");
                assertFalse(offer.getCustomersList().contains(usualCustomer), "Usual customer should not be in Economy offer after removal");
            }
        }

        @Nested
        @DisplayName("VipCustomer")
        class VipCustomer {

            @Test
            @DisplayName("Should add VIP customer to economy offer")
            void shouldAddVipCustomerToEconomyOffer() {
                // Arrange
                EconomyCreditOffer offer = new EconomyCreditOffer("3");
                Customer vipCustomer = new Customer("Alice", true);

                // Act
                boolean added = offer.addCustomer(vipCustomer);

                // Assert
                assertAll("Adding VIP Customer to Economy Offer",
                        () -> assertTrue(added),
                        () -> assertTrue(offer.getCustomersList().contains(vipCustomer))
                );
            }

            @Test
            @DisplayName("Should not remove VIP customer from economy offer")
            void shouldNotRemoveVipCustomerFromEconomyOffer() {
                // Arrange
                EconomyCreditOffer offer = new EconomyCreditOffer("4");
                Customer vipCustomer = new Customer("Emma", true);
                offer.addCustomer(vipCustomer);

                // Act
                boolean removed = offer.removeCustomer(vipCustomer);

                // Assert
                assertFalse(removed, "VIP customer should not be removed from Economy offer");
            }
        }
    }

    @Nested
    @DisplayName("BusinessCreditOfferTest")
    class BusinessCreditOfferTest {

        @Nested
        @DisplayName("UsualCustomer")
        class UsualCustomer {

            @Test
            @DisplayName("Should not add usual customer to business offer")
            void shouldNotAddUsualCustomerToBusinessOffer() {
                // Arrange
                BusinessCreditOffer offer = new BusinessCreditOffer("5");
                Customer usualCustomer = new Customer("Mike", false);

                // Act
                boolean added = offer.addCustomer(usualCustomer);

                // Assert
                assertFalse(added, "Usual customer should not be added to Business offer");
            }

            @Test
            @DisplayName("Should not remove usual customer from any offer")
            void shouldNotRemoveUsualCustomerFromAnyOffer() {
                // Arrange
                BusinessCreditOffer offer = new BusinessCreditOffer("6");
                Customer usualCustomer = new Customer("Kate", false);

                // Act
                boolean removed = offer.removeCustomer(usualCustomer);

                // Assert
                assertFalse(removed, "Usual customer should not be removed from any offer");
            }
        }

        @Nested
        @DisplayName("VipCustomer")
        class VipCustomer {

            @Test
            @DisplayName("Should add VIP customer to business offer")
            void shouldAddVipCustomerToBusinessOffer() {
                // Arrange
                BusinessCreditOffer offer = new BusinessCreditOffer("7");
                Customer vipCustomer = new Customer("Tom", true);

                // Act
                boolean added = offer.addCustomer(vipCustomer);

                // Assert
                assertAll("Adding VIP Customer to Business Offer",
                        () -> assertTrue(added),
                        () -> assertTrue(offer.getCustomersList().contains(vipCustomer))
                );
            }

            @Test
            @DisplayName("Should not remove VIP customer from any offer")
            void shouldNotRemoveVipCustomerFromAnyOffer() {
                // Arrange
                BusinessCreditOffer offer = new BusinessCreditOffer("8");
                Customer vipCustomer = new Customer("Emma", true);

                // Act
                boolean removed = offer.removeCustomer(vipCustomer);

                // Assert
                assertFalse(removed, "VIP customer should not be removed from any offer");
            }
        }
    }

}

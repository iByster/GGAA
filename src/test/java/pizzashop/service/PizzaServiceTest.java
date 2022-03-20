package pizzashop.service;

import static org.junit.jupiter.api.Assertions.*;

class PizzaServiceTest {
    @DisplayName("Test tables valid")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void testTablesV(int value) throws Exception {
        //Arrange
        double amount = 20d;
        PaymentType paymentType = PaymentType.Card;
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        //Act
        boolean result = pizzaService.addPayment(value, paymentType, amount);

        //Assert
        assertEquals(true, result);
    }

    @RepeatedTest(2)
    void testAmmountV() throws Exception {
        //Arrange
        int t = 3;
        PaymentType paymentType = PaymentType.Card;
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        //Act
        boolean result = pizzaService.addPayment(t, paymentType, 20d);

        //Assert
        assertEquals(true, result);
    }

    @Timeout(1000)
    void testPaymentTypeV() throws Exception {
        //Arrange
        int t = 3;
        PaymentType paymentType = PaymentType.Cash;
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        //Act
        boolean result = pizzaService.addPayment(t, paymentType, 20d);

        //Assert
        assertEquals(true, result);
    }

    @DisplayName("Test tables invalid")
    @ParameterizedTest
    @ValueSource(ints = {-100, 90})
    void testTablesN(int value) throws Exception {
        //Arrange
        double amount = 20d;
        PaymentType paymentType = PaymentType.Card;
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        //Act
        assertThrows(Exception.class, () -> {pizzaService.addPayment(value, paymentType, amount);});
    }

    @RepeatedTest(2)
    void testAmmountN() throws Exception {
        //Arrange
        int t = 3;
        PaymentType paymentType = PaymentType.Card;
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        //Act
        assertThrows(Exception.class, () -> {pizzaService.addPayment(t, paymentType, -20d);});
    }
}
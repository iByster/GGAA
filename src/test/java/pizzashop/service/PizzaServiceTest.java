package pizzashop.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pizzashop.model.MenuDataModel;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;

import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class PizzaServiceTest {
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

    @Test
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

    @Test
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

    @Test
    void testAmmountBVAV2() throws Exception {
        //Arrange
        double value = Double.MAX_VALUE;
        int t = 3;
        PaymentType paymentType = PaymentType.Card;
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        //Act
        boolean result = pizzaService.addPayment(t, paymentType, value);

        //Assert
        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 8})
    void testTablesBVAV(int value) throws Exception {
        //Arrange
        double amount = 20d;
        PaymentType paymentType = PaymentType.Card;
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        //Act
        boolean result = pizzaService.addPayment(value, paymentType, amount);

        //Assert
        assertEquals(true, result);
    }

    @Test
    void testAmmountBVAV() throws Exception {
        //Arrange
        double value = 1.5d;
        int t = 3;
        PaymentType paymentType = PaymentType.Card;
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        //Act
        boolean result = pizzaService.addPayment(t, paymentType, value);

        //Assert
        assertEquals(true, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 9})
    void testTablesBVAN(int value) throws Exception {
        //Arrange
        double amount = 20d;
        PaymentType paymentType = PaymentType.Card;
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        //Act
        assertThrows(Exception.class, () -> {pizzaService.addPayment(value, paymentType, amount);});
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1d})
    void testAmountBVAN(double value) throws Exception {
        //Arrange
        PaymentType paymentType = PaymentType.Card;
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        //Act
        assertThrows(Exception.class, () -> {pizzaService.addPayment(1, paymentType, value);});
    }
}